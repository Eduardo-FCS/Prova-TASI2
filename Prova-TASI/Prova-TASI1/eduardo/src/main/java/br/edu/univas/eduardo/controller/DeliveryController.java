package br.edu.univas.eduardo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.eduardo.dto.DeliveryDTO;
import br.edu.univas.eduardo.entities.DeliveryEntity;
import br.edu.univas.eduardo.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryService service;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody DeliveryDTO delivery) {
		service.createProduct(delivery);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<DeliveryDTO> getDeliveryById(@PathVariable Long code) {
	    DeliveryEntity delivery = service.findById(code);
	    if (delivery == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        DeliveryDTO ent = new DeliveryDTO(delivery);
	        return ResponseEntity.ok().body(ent);
	    }
	}

	@PutMapping("/active/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void activeDelivery(@PathVariable Long code) {
		service.activeDelivery(code);
	}

}
