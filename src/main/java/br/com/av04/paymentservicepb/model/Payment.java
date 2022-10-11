package br.com.av04.paymentservicepb.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.av04.paymentservicepb.model.enums.CardBrand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
    @Enumerated(EnumType.STRING)
    private CardBrand brand;
    
    @Size(min = 13, max = 16)
    private String card_number;

    @NotNull
    private String cardholder_name;

    @NotNull
    @Size(min = 3, max = 3)
    private String security_code;

    @NotNull
    @Length(min = 2, max = 2)
    @Min(value=1) @Max(value = 12)
    private Integer expiration_month;

    @NotNull
    @Length(min = 2, max = 2)
    @Min(value=23)
    private Integer expiration_year;
    
}
