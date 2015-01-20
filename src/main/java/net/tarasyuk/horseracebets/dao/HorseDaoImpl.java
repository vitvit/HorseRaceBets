package net.tarasyuk.horseracebets.dao;

import java.util.List;

import net.tarasyuk.horseracebets.data.Horse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HorseDaoImpl implements HorseDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addHorse(Horse horse) {
		sessionFactory.getCurrentSession().save(horse);

	}

	@SuppressWarnings("unchecked")
	public List<Horse> listHorse() {
		return sessionFactory.getCurrentSession().createQuery("from Horse")
				.list();

	}

	public void removeHorse(Integer id) {
		Horse horse = (Horse) sessionFactory.getCurrentSession().load(
				Horse.class, id);
		sessionFactory.getCurrentSession().delete(horse);
	}

	public Horse findHorseById(Integer id) {
		return (Horse) sessionFactory.getCurrentSession().load(Horse.class, id);
	}

	
	//public List<Horse> findHorsesByRacing(Integer id) {
		
		//return null;
	//}

}
