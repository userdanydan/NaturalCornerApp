package be.natural_corner.repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import be.natural_corner.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	

}
