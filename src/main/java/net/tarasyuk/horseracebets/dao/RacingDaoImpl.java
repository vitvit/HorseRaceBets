package net.tarasyuk.horseracebets.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.tarasyuk.horseracebets.data.Horse;
import net.tarasyuk.horseracebets.data.Racing;

@Repository
public class RacingDaoImpl implements RacingDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addRacing(Racing racing) {
		sessionFactory.getCurrentSession().save(racing);
	}

	public List<Racing> findAllRacings() {
		return sessionFactory.getCurrentSession().createQuery("from Racing")
				.list();
	}

	public Racing findRacing(Integer id) {
		Racing racing = (Racing) sessionFactory.getCurrentSession().load(
				Racing.class, id);
		return racing;
	}

	public void removeRacing(Integer id) {
		Racing racing = (Racing) sessionFactory.getCurrentSession().load(
				Racing.class, id);
		sessionFactory.getCurrentSession().delete(racing);
	}
}
