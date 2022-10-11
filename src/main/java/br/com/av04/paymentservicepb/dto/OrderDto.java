package br.com.av04.paymentservicepb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import br.com.av04.paymentservicepb.model.enums.PaymentStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private BigDecimal total;
    private String paymentId;

    private PaymentStatus paymentStatus;

    private String message;
    


}
