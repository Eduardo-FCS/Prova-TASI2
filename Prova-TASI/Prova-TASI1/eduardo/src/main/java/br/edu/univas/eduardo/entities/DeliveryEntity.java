package br.edu.univas.eduardo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderCode;
	private String cpf;
	private String date;
	private int cep;
	private String deliveryStatus;
	private boolean active;

}
