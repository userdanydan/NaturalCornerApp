package be.natural_corner.service;

import java.util.List;

import be.natural_corner.domain.Address;
import be.natural_corner.domain.User;

public interface IUserService {
	
	List<User> getAllUsers();
	User getUserById(int id);
	User getUserByEMail(String eMail);
	void createUser(User u);
	void deleteUser(User u);
	void deleteUser(int id);
	void updateUser(User u);
}	
