package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository,
							RepositoryRestConfiguration restConfiguration) {
		restConfiguration.exposeIdsFor(Product.class);
		return args -> {
			productRepository.save(new Product(null,"ecouteur",55,2));
			productRepository.save(new Product(null,"portable",100,6));
			productRepository.save(new Product(null,"clavier",1000,10));
			productRepository.save(new Product(null,"machine a laver",23000,16));
			productRepository.save(new Product(null,"ordinateur",2000,10));
			productRepository.save(new Product(null,"Tv",3600,66));
			productRepository.findAll().forEach(p->{
				System.out.println(p.getName().toString());
			});
		};
	}
}
