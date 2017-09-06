package be.natural_corner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"be.natural_corner.service", "be.natural_corner.rest", "be.natural_corner.repositories"})
public class NaturalCornerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaturalCornerAppApplication.class, args);
	}
}
