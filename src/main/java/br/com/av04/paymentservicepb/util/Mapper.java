package br.com.av04.paymentservicepb.util;

import br.com.av04.paymentservicepb.dto.OrderDto;
import br.com.av04.paymentservicepb.model.Order;
import br.com.av04.paymentservicepb.model.enums.PaymentStatus;

public class Mapper {

    private Long orderId;

    private double total;

    private String paymentId;

    private PaymentStatus paymentStatus;

    private String message;

    public static OrderDto convertOrder(Order order) {
       OrderDto orderDto = new OrderDto(
               order.getOrderId(),
                order.getTotal(),
                order.getPaymentId(),
                order.getPaymentStatus(),
                order.getMessage());

       return orderDto;
    }

}
