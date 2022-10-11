package br.com.av04.paymentservicepb.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormDtoError {

	private String field;
    private String error;

}
