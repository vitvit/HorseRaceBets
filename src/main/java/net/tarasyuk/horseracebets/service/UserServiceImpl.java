package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.authorization.ListRole;
import net.tarasyuk.horseracebets.authorization.User;
import net.tarasyuk.horseracebets.authorization.UserRole;
import net.tarasyuk.horseracebets.dao.BetDao;
import net.tarasyuk.horseracebets.dao.UserDao;
import net.tarasyuk.horseracebets.dao.UserRoleDao;
import net.tarasyuk.horseracebets.data.Bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BetDao betDao;
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userDao.findUser(username);
	}
	@Transactional
	public User findUserById(Integer id){
		return userDao.findUserById(id);
	}
	
	@Transactional
	public void addUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		UserRole role = userRoleDao.findRole(ListRole.USER); //for registration as admin set "ListRole.ADMIN"
		user.getUserRoles().add(role);
		userDao.addUser(user);

	}

	@Transactional
	public void removeUser(Integer id) {
		userDao.removeUser(id);
		
	}

	@Transactional
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Transactional
	public User findUserWithBets(String username) {
		User user = (User) loadUserByUsername(username); 
		List<Bet> bets = betDao.findBetsByUser(username);
		user.setBets(bets);
		return user;
	}
	@Transactional
	public User findUserWithBetsById(Integer id) {
		User user = findUserById(id);
		 
		return findUserWithBets(user.getUsername());
	}
	@Transactional
	public User findUser(String username) {
		return userDao.findUser(username);
		
	}
	
	
}
