package br.edu.univas.test.eduardo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {

	private long orderCode;
	private String cpf;
	private String date;
	private int cep;
	private String deliveryStatus;
	private boolean active;
}
