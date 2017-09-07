package be.natural_corner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.natural_corner.domain.Address;
import be.natural_corner.domain.Product;
import be.natural_corner.repositories.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository productRepo;
	
	public IProductRepository getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(IProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		List<Product> products = productRepo.findAll();
		for(Product product : products) {
			if(product.getProductId()==id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		return productRepo.findOne(name);
	}


	@Override
	public void createProduct(Product u) {
		// TODO Auto-generated method stub
		productRepo.save(u);
	}

	@Override
	public void deleteProduct(Product u) {
		// TODO Auto-generated method stub
		productRepo.delete(u);
	}
	
	
	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepo.delete(String.valueOf(id));
	}
	

	@Override
	public void updateProduct(Product u) {
		// TODO Auto-generated method stub
		productRepo.save(u);
	}



}
