package be.natural_corner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.natural_corner.domain.Address;
import be.natural_corner.domain.User;
import be.natural_corner.repositories.UserRepository;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepo.findOne(String.valueOf(id));
	}

	@Override
	public User getUserByEMail(String eMail) {
		return userRepo.findOne(eMail);
	}


	@Override
	public void createUser(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		userRepo.delete(u);
	}
	
	
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepo.delete(String.valueOf(id));
	}
	

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
	}

}
