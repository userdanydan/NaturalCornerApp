package be.natural_corner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.natural_corner.domain.Product;

public interface IProductRepository extends JpaRepository<Product, String>{
	

}
