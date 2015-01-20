package net.tarasyuk.horseracebets.dao;

import java.util.List;

import net.tarasyuk.horseracebets.authorization.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	
	public User findUser(String username) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User u where u.username=:username");
		query.setParameter("username", username);
		User result = (User) query.uniqueResult();

		if (result == null)
			throw new UsernameNotFoundException("username: " + username
					+ " not found");

		return result;

	}

	public void addUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);

	}

	
	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, id);
		sessionFactory.getCurrentSession().delete(user);
		
	}

	
	public List<User> findAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	
	public User findUserById(Integer id) {
		return (User) sessionFactory.getCurrentSession().load(
					User.class, id);
		 
	}

}
