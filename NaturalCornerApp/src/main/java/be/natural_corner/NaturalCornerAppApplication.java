package be.natural_corner;


import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.natural_corner.domain.Product;
import be.natural_corner.domain.User;
import be.natural_corner.repositories.IProductRepository;
import be.natural_corner.repositories.IUserRepository;

@SpringBootApplication(scanBasePackages= {"be.natural_corner.service", "be.natural_corner.rest", "be.natural_corner.repositories"})
public class NaturalCornerAppApplication {
	Logger log = LoggerFactory.getLogger(NaturalCornerAppApplication.class);
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(NaturalCornerAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
			// save some users
			User[] users = new User[] {
				 userRepository.save(new User("pwd", "test0@mail.com")),
				 userRepository.save(new User("pwd", "test1@mail.com")),
				 userRepository.save(new User("pwd", "test2@mail.com")),
				 userRepository.save(new User("pwd", "test3@mail.com")),
				 userRepository.save(new User("pwd", "test4@mail.com")),
				 userRepository.save(new User("pwd", "test5@mail.com"))};
			if(users!=null)
				log.debug(Arrays.toString(users));
			else
				log.debug("not such object as users array");
				
			// fetch all customers
			 log.info("Employes found with findAll():");
			 log.info("-------------------------------");
			 for (User customer : userRepository.findAll()) {
				 log.info(customer.toString());
			 }
			 
			 // save some products.
			 
			 Product[] products = new Product[] {
					 productRepository.save(new Product(0L, "orange", new BigDecimal("1.0"), "fruits", true, false)),
					 productRepository.save(new Product(0L, "pomme", new BigDecimal("2.0"), "fruits", true, false)),
					 productRepository.save(new Product(0L, "cerise", new BigDecimal("2.5"), "fruits", true, false)),
					 productRepository.save(new Product(0L, "céléri", new BigDecimal("0.5"), "légumes", true, false)),
					 productRepository.save(new Product(0L, "salade", new BigDecimal("0.99"), "légumes", true, false)),
					 productRepository.save(new Product(0L, "poireau", new BigDecimal("5.55"), "légumes", true, false))
			 };
			 
			 if(products!=null)
					log.debug(Arrays.toString(products));
				else
					log.debug("not such object as users array");
			// fetch all customers
			 log.info("Products found with findAll():");
			 log.info("-------------------------------");
			 for (Product product : productRepository.findAll()) {
				 log.info(product.toString());
			 }
		};
	}
}
