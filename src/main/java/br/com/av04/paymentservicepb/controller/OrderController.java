package br.com.av04.paymentservicepb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.av04.paymentservicepb.controller.form.OrderForm;
import br.com.av04.paymentservicepb.dto.OrderDto;

import br.com.av04.paymentservicepb.services.PaymentService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/order/payment")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<OrderDto> showAll(){
        return paymentService.showOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> showById (@PathVariable @NotNull Long id) {
        OrderDto orderDtoById = paymentService.showOrderById(id);
        if (orderDtoById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.showOrderById(id));
    }
    
    @PostMapping
    public ResponseEntity<OrderDto> newRegister(@RequestBody @Valid OrderForm form, UriComponentsBuilder uriBuilder){
        try {
            OrderDto orderDtoPost = paymentService.newOrder(form);
            URI uri = uriBuilder.path("/api/v1/order/payment/{id}").buildAndExpand(orderDtoPost.getOrderId()).toUri();
            return ResponseEntity.created(uri).body(orderDtoPost);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}