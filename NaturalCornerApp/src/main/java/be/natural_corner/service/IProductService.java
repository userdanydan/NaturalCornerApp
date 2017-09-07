package be.natural_corner.service;

import java.util.List;

import be.natural_corner.domain.Product;

public interface IProductService {
	
	List<Product> getAllProducts();
	Product getProductById(Long id);
	Product getProductByName(String eMail);
	void createProduct(Product u);
	void deleteProduct(Product u);
	void deleteProduct(Long id);
	void updateProduct(Product u);
}	
