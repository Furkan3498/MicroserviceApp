package com.company.orders.Service;

import com.company.orders.OrderRepo.OrderRepository;
import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderResponse.OrderCreateResponse;
import com.company.orders.Service.abstraction.OrderService;
import com.company.orders.exception.NotFoundException;
import org.springframework.stereotype.Service;

import static com.company.orders.entity.enums.ErrorMessage.ORDER_NOT_FOUND;
import static com.company.orders.mapper.OrderMapper.ORDER_MAPPER;
import static java.lang.String.format;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderCreateRequest orderCreateRequest) {

    }

    @Override
    public OrderCreateResponse getOrderById(Long id) {
      return  orderRepository.findById(id).map(ORDER_MAPPER::mapToDto).orElseThrow(()-> new NotFoundException(format(ORDER_NOT_FOUND.getMessage()
      ,id)));
    }
}
