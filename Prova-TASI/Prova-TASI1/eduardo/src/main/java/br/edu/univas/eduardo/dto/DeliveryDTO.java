package br.edu.univas.eduardo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.univas.eduardo.entities.DeliveryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryDTO {

	private long orderCode;
	private String cpf;
	private String date;
	private int cep;
	private String deliveryStatus;
	private boolean active;

	public DeliveryDTO(DeliveryEntity delivery) {
		this.orderCode = delivery.getOrderCode();
		this.cpf = delivery.getCpf();
		this.date = delivery.getDate();
		this.cep = delivery.getCep();
		this.deliveryStatus = delivery.getDeliveryStatus();
		this.active = delivery.isActive();
	}
}