package br.com.av04.paymentservicepb.controller.form;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.av04.paymentservicepb.model.Item;
import br.com.av04.paymentservicepb.model.Payment;
import br.com.av04.paymentservicepb.model.enums.CurrencyType;
import br.com.av04.paymentservicepb.model.enums.DocumentType;
import br.com.av04.paymentservicepb.model.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {

    @Valid
    private List<@Valid Item> items;

    @NotNull
    @Min(value = 0)
    private BigDecimal shipping;

    @NotNull
    @Min(value = 0)
    private BigDecimal discount; 
    
    @NotNull
    private Payment payment;

    private PaymentType payment_type;

    private CurrencyType currency_type;
    
    private DocumentType document_type;
  
}
