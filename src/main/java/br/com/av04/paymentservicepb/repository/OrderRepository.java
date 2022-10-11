package br.com.av04.paymentservicepb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.av04.paymentservicepb.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
