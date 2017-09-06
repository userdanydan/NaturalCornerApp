package be.natural_corner.rest;

import java.util.List;

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

	@Autowired
	private IUserService service;


	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> tous = service.getAllUsers();
		return new ResponseEntity<List<User>>(tous, HttpStatus.OK);
	}

	// @PostMapping
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User u) {
		service.createUser(u);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {

		User resultat = service.getUserById(Integer.parseInt(id));
		if (resultat != null) {
			return new ResponseEntity<User>(resultat, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/Users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") String id) {
		User result = service.getUserById(Integer.parseInt(id));
		service.deleteUser(result);
		return new ResponseEntity<User>(result, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User u) {
		service.updateUser(u);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

}
