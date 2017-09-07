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

import be.natural_corner.domain.User;
import be.natural_corner.service.IUserService;

@RestController

public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class); 
	@Autowired
	private IUserService service;

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		
		User resultat = service.getUserById(Long.parseLong(id));
		if (resultat != null) {
			logger.debug(resultat.toString());
			return new ResponseEntity<User>(resultat, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> tous = service.getAllUsers();
		logger.debug("public ResponseEntity<List<User>> getAllUsers() from UserController");
		logger.debug(tous.toString());
		return new ResponseEntity<List<User>>(tous, HttpStatus.OK);
	}

	// @PostMapping
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User u) {
		service.createUser(u);
		logger.debug("public ResponseEntity<List<User>> getAllUsers() from UserController");
		logger.debug(u.toString());
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") Long id) {
		User result = service.getUserById(id);
		service.deleteUser(result);
		logger.debug(result.toString());
		return new ResponseEntity<User>(result, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User u) {
		service.updateUser(u);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

}
