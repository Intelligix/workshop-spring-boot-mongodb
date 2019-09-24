package com.intelligix.WorkshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligix.WorkshopMongo.domain.User;
import com.intelligix.WorkshopMongo.dto.UserDTO;
import com.intelligix.WorkshopMongo.respository.UserRepository;
import com.intelligix.WorkshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll () {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert (User obj) {
		return repository.insert(obj);
	}
	
	public void delete (String id) {
		findById (id);
		repository.deleteById(id);
	}
	
	public User update (User obj) {
		User newObj = findById(obj.getId());
		updateData (newObj, obj);
		return repository.save(obj);		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

	public User fromDTO (UserDTO user) {
		return new User (user.getId(), user.getName(), user.getEmail());
	}
	
}
