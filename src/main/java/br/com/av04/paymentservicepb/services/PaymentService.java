package br.com.av04.paymentservicepb.services;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import br.com.av04.paymentservicepb.controller.form.OrderForm;
import br.com.av04.paymentservicepb.dto.OrderDto;
import br.com.av04.paymentservicepb.model.Order;
import br.com.av04.paymentservicepb.repository.OrderRepository;

@Service
@Getter
public class PaymentService {
	@Autowired
	private ModelMapper modelMapper;

	public PaymentService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Autowired
	private OrderRepository orderRepository;

	public OrderDto newOrder(OrderForm form) {
		Order order = modelMapper.map(form, Order.class);
		order.getTotal();
		orderRepository.save(order);
		return modelMapper.map(order, OrderDto.class);
	}

	public List<OrderDto> showOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders.stream().map(o -> modelMapper.map(o, OrderDto.class)).collect(Collectors.toList());
	}

	public OrderDto showOrderById(Long id) {

		return modelMapper.map(orderRepository.findById(id), OrderDto.class);
	}

}
