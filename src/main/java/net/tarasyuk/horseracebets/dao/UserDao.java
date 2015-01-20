package net.tarasyuk.horseracebets.dao;

import java.util.List;

import net.tarasyuk.horseracebets.authorization.User;


public interface UserDao {
	
	public User findUserById(Integer id);

	public void addUser(User user);

	public User findUser(String username);

	public void removeUser(Integer id);

	public List<User> findAllUsers();


}
