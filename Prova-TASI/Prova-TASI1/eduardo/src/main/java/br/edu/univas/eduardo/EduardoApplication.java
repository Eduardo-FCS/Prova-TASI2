package br.edu.univas.eduardo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.eduardo.entities.DeliveryEntity;
import br.edu.univas.eduardo.repositories.DeliveryRepository;

@SpringBootApplication
public class EduardoApplication implements CommandLineRunner {
	
	@Autowired
	private DeliveryRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(EduardoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		DeliveryEntity p1 = new DeliveryEntity(1, "1123453344", "14/04/2023", 3756420, "Em entrega", true);
		repo.save(p1);
		DeliveryEntity p2 = new DeliveryEntity(2, "1234567890", "10/01/2012", 3754000, "Entregue", false);
		repo.save(p2);
	}

}
