package com.byteforce.user_api.application.service;

import com.byteforce.user_api.application.dto.UserDTO;
import com.byteforce.user_api.application.mapper.UserMapper;
import com.byteforce.user_api.domain.entity.User;
import com.byteforce.user_api.infrastructure.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final Logger log = LoggerFactory.getLogger(UserService.class);
	private UserRepository repository;
	private UserMapper mapper;

	public UserService(UserRepository repository) {
		this.repository = repository;
		this.mapper = new UserMapper();
	}

	public List<UserDTO> findAll(){
		List<User> users = repository.findAll();
		return mapper.mapToList(users);
	}

	public Optional<UserDTO> findById(Long id) {
		return repository.findById(id)
			.map(mapper::mapTo);
	}


	public Optional<UserDTO> save(User user){
		if(user.getId() != null){
			log.warn("Dont put id to create a user");
			return Optional.empty();
		}
		User userSave = repository.save(user);
		return Optional.ofNullable(mapper.mapTo(userSave));
	}

	public Optional<UserDTO> update(Long id, User user) {
		if (user.getId() != null) {
			log.warn("User body can't have id, it must be in the path");
			return Optional.empty();
		}

		Optional<User> existingUserOpt = repository.findById(id);
		if (existingUserOpt.isEmpty()) {
			log.warn("User not found");
			return Optional.empty();
		}

		User existingUser = existingUserOpt.get();
		if ( user.getName() != null) {
			existingUser.setName(user.getName());
		}
		if (user.getUsername() != null) {
			existingUser.setUsername(user.getUsername());
		}
		if (user.getPassword() != null) {
			existingUser.setPassword(user.getPassword());
		}

		User updatedUser = repository.save(existingUser);
		return Optional.ofNullable(mapper.mapTo(updatedUser));
	}

	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		log.warn("User Not found");
		return false;
	}

}
