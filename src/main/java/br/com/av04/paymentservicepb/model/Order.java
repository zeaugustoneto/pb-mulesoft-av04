package br.com.av04.paymentservicepb.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.av04.paymentservicepb.model.enums.CurrencyType;
import br.com.av04.paymentservicepb.model.enums.DocumentType;
import br.com.av04.paymentservicepb.model.enums.PaymentStatus;
import br.com.av04.paymentservicepb.model.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

	@JoinColumn(name ="order_item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Transient
	@OneToMany(targetEntity = Order.class, fetch = FetchType.EAGER)
	private List<Item> items;

	private BigDecimal shipping;

	private BigDecimal discount;

	private BigDecimal total = new BigDecimal(0);

	@Transient
	private Payment payment;
	
	@Column(name = "payment_id")
	private String paymentId = UUID.randomUUID().toString();

	@Column(name = "document_type")
	@Enumerated(EnumType.STRING)
	private DocumentType document_type;
	
	@Enumerated(EnumType.STRING)
	private PaymentType payment_type;

	@Enumerated(EnumType.STRING)
	private CurrencyType currency_type;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	private String message;


	// func p/ calcular total dos itens
	private BigDecimal totalPriceItems() {
		items.forEach(i -> setTotal(getTotal().add(new BigDecimal(i.getQty()).multiply(i.getValue()))));
		setTotal(getTotal().add(getShipping()));
		return getTotal().subtract(getDiscount());
	}
	
	  public void aux() {
	        this.total = totalPriceItems();
	    }
	

}
