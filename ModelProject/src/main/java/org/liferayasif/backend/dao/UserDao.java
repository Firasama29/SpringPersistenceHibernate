package org.liferayasif.backend.dao;

import java.util.List;

import org.liferayasif.backend.model.User;

public interface UserDao {

	public List<User> getAllUsers();
	
	public User getUserById(Integer id);
	
	public User addUser(User user);
	
	public void deleteUser(Integer id);
	
	public User updateUser(User user);
	
	public List<User> findByName(String name);
	
}
