package com.byteforce.user_api.application.mapper;

import com.byteforce.user_api.application.dto.UserDTO;
import com.byteforce.user_api.domain.entity.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper implements Mapper<User, UserDTO> {


	@Override
	public UserDTO mapTo(User user) {
		return new UserDTO(
			user.getId(),
			user.getName(),
			user.getUsername());
	}

	@Override
	public User mapFrom(UserDTO userDTO) {
		return new User(
			userDTO.getId(),
			userDTO.getName(),
			userDTO.getUsername());
	}

	@Override
	public List<UserDTO> mapToList(List<User> users) {
		return users.stream()
			.map(this::mapTo)
			.collect(Collectors.toList());
	}

	@Override
	public List<User> mapFromList(List<UserDTO> userDTOS) {
		return userDTOS.stream()
			.map(this::mapFrom)
			.collect(Collectors.toList());
	}
}
