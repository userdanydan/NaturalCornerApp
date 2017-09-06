package be.natural_corner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.natural_corner.domain.User;
import be.natural_corner.repositories.UserRepository;

@SpringBootApplication(scanBasePackages= {"be.natural_corner.service", "be.natural_corner.rest", "be.natural_corner.repositories"})
public class NaturalCornerAppApplication {
	Logger log = LoggerFactory.getLogger(NaturalCornerAppApplication.class);
	
	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(NaturalCornerAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
			// save some customers
			User user1 = repository.save(new User("test0@mail.com", "pwd"));
			User user2 =repository.save(new User("test1@mail.com", "pwd"));
			User user3 =repository.save(new User("test2@mail.com", "pwd"));
			if(user1!=null)
				log.debug(user1.toString());
			else
				log.debug("not such object as user1");
				
			// fetch all customers
			 log.info("Employes found with findAll():");
			 log.info("-------------------------------");
			 for (User customer : repository.findAll()) {
				 log.info(customer.toString());
			 }

		};
	}
}
