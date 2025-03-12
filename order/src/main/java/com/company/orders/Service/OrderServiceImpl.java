package com.company.orders.Service;

import com.company.orders.OrderRepo.OrderRepository;
import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderRequest.client.CreatePaymentRequest;
import com.company.orders.OrderResponse.OrderCreateResponse;
import com.company.orders.OrderResponse.client.ProductResponse;
import com.company.orders.Service.abstraction.OrderService;
import com.company.orders.client.PaymentClient;
import com.company.orders.client.ProductClient;
import com.company.orders.entity.OrderEntity;
import com.company.orders.OrderRequest.client.ReduceQuantityRequest;
import com.company.orders.entity.enums.OrderStatus;
import com.company.orders.exception.NotFoundException;
import com.company.orders.mapper.PaymentMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

import static com.company.orders.entity.enums.ErrorMessage.ORDER_NOT_FOUND;
import static com.company.orders.mapper.OrderMapper.ORDER_MAPPER;
import static java.lang.String.format;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final PaymentClient  paymentClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
        this.paymentClient = paymentClient;
    }

    @Override
    @Transactional
    public void createOrder(OrderCreateRequest orderCreateRequest) {
        OrderEntity orderentity = ORDER_MAPPER.mapToEntity(orderCreateRequest);
        ProductResponse productById = productClient.getProductById(orderCreateRequest.getProductId());


        BigDecimal totalAmount = productById.getPrice()
                .multiply(BigDecimal
                        .valueOf(orderCreateRequest.getQuantity()));
        orderentity.setAmount(totalAmount);
        ReduceQuantityRequest reduceQuantityRequest = new ReduceQuantityRequest(
                orderCreateRequest.getProductId(),
                orderCreateRequest.getQuantity()
        );
        orderRepository.save(orderentity);
        productClient.reduceQuantity(reduceQuantityRequest);
        try {
            paymentClient.pay(PaymentMapper.PAYMENT_MAPPER.createPaymentRequest(orderentity,orderCreateRequest,totalAmount));
            orderentity.setStatus(OrderStatus.APPROVED);

        }catch (Exception e){
            orderentity.setStatus(OrderStatus.REJECTED);
        }




    }

    @Override
    public OrderCreateResponse getOrderById(Long id) {
      return  orderRepository.findById(id).map(ORDER_MAPPER::mapToDto).orElseThrow(()-> new NotFoundException(format(ORDER_NOT_FOUND.getMessage()
      ,id)));
    }
}
