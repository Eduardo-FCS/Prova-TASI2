package br.edu.univas.eduardo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.eduardo.dto.DeliveryDTO;
import br.edu.univas.eduardo.entities.DeliveryEntity;
import br.edu.univas.eduardo.repositories.DeliveryRepository;

@Service
public class DeliveryService {
	
	private DeliveryRepository repo;
	
	@Autowired
	public DeliveryService(DeliveryRepository del) {
		this.repo = del;
	}
	
	public DeliveryEntity toEntity(DeliveryDTO dto) {
		return new DeliveryEntity(dto.getOrderCode(), dto.getCpf(), dto.getDate(), dto.getCep(), dto.getDeliveryStatus(), dto.isActive());
	}
	
	public void createProduct(DeliveryDTO delivery) {
		repo.save(toEntity(delivery));
	}
	
	public DeliveryEntity findById(long code) {
		Optional<DeliveryEntity> obj = repo.findById(code);
		DeliveryEntity entity = obj.orElse(null);
		return entity;
	}
	
	public void activeDelivery(Long code) {
		Optional<DeliveryEntity> x = repo.findById(code);
		if (x.isEmpty()) {
			throw new RuntimeException("Haven't the code " + code + "              ");
		}
		DeliveryEntity delivery = x.get();
		delivery.setActive(!delivery.isActive());
		repo.save(delivery);
	}
	
	
}
