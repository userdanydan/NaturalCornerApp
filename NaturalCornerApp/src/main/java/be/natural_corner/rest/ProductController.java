package be.natural_corner.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.natural_corner.domain.Product;
import be.natural_corner.service.IProductService;

@RestController

public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class); 
	@Autowired
	private IProductService service;

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
		
		Product resultat = service.getProductById(Long.parseLong(id));
		if (resultat != null) {
			logger.debug(resultat.toString());
			return new ResponseEntity<Product>(resultat, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/products/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
		
		Product resultat = service.getProductByName(name);
		if (resultat != null) {
			logger.debug(resultat.toString());
			return new ResponseEntity<Product>(resultat, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> tous = service.getAllProducts();
		logger.debug("public ResponseEntity<List<Product>> getAllProducts() from ProductController");
		logger.debug(tous.toString());
		return new ResponseEntity<List<Product>>(tous, HttpStatus.OK);
	}

	// @PostMapping
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product u) {
		service.createProduct(u);
		logger.debug("public ResponseEntity<List<Product>> getAllProducts() from ProductController");
		logger.debug(u.toString());
		return new ResponseEntity<Product>(u, HttpStatus.CREATED);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
		Product result = service.getProductById(id);
		service.deleteProduct(result);
		logger.debug(result.toString());
		return new ResponseEntity<Product>(result, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody Product u) {
		service.updateProduct(u);
		return new ResponseEntity<Product>(u, HttpStatus.CREATED);
	}

}
