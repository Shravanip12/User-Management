package com.Service;

import java.util.List;

import com.DTO.UserDTO;
import com.Entity.User;

public interface UserService {

	User addUserInService(User user);

	public void deleteUserInService(int id);

	void updateUserInService(User user);

	UserDTO fetchUserInService(int id);

	void SendMailInUs();

	
}
