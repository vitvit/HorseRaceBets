package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.authorization.User;

public interface UserService {
	
	public User findUserById(Integer id);

	public void addUser(User user);

	public void removeUser(Integer id);

	public List<User> findAllUsers();

	public User findUserWithBets(String username);
	
	public User findUserWithBetsById(Integer id);

	public User findUser(String username);
}
