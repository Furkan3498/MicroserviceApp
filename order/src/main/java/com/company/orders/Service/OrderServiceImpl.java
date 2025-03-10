package com.company.orders.Service;

import com.company.orders.OrderRepo.OrderRepository;
import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderResponse.OrderCreateResponse;
import com.company.orders.Service.abstraction.OrderService;
import com.company.orders.client.ProductClient;
import com.company.orders.entity.OrderEntity;
import com.company.orders.entity.client.ReduceQuantityRequest;
import com.company.orders.entity.enums.OrderStatus;
import com.company.orders.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.company.orders.entity.enums.ErrorMessage.ORDER_NOT_FOUND;
import static com.company.orders.mapper.OrderMapper.ORDER_MAPPER;
import static java.lang.String.format;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    @Transactional
    public void createOrder(OrderCreateRequest orderCreateRequest) {
        OrderEntity orderentity = ORDER_MAPPER.mapToEntity(orderCreateRequest);
        ReduceQuantityRequest reduceQuantityRequest = new ReduceQuantityRequest(
                orderCreateRequest.getProductId(),
                orderCreateRequest.getQuantity()
        );

        try {
            productClient.reduceQuantity(reduceQuantityRequest);
            orderentity.setStatus(OrderStatus.APPROVED);

        }catch (Exception e){
            orderentity.setStatus(OrderStatus.REJECTED);
        }

        orderRepository.save(orderentity);

    }

    @Override
    public OrderCreateResponse getOrderById(Long id) {
      return  orderRepository.findById(id).map(ORDER_MAPPER::mapToDto).orElseThrow(()-> new NotFoundException(format(ORDER_NOT_FOUND.getMessage()
      ,id)));
    }
}
