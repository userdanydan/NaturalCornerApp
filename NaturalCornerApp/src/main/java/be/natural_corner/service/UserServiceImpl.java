package be.natural_corner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.natural_corner.domain.Address;
import be.natural_corner.domain.User;
import be.natural_corner.repositories.IUserRepository;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepo;
	
	public IUserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(IUserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		List<User> users = userRepo.findAll();
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
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
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepo.delete(String.valueOf(id));
	}
	

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
	}

}
