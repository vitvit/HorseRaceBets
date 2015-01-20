package net.tarasyuk.horseracebets.dao;

import java.util.Date;
import java.util.List;

import net.tarasyuk.horseracebets.data.Bet;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BetDaoImpl implements BetDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addBet(Bet bet) {
		bet.setDate(new Date());
		sessionFactory.getCurrentSession().save(bet);
	}

	@SuppressWarnings("unchecked")
	public List<Bet> listBet() {
		return sessionFactory.getCurrentSession().createQuery("from Bet")
				.list();

	}

	public Bet findOne(int id) {
		Bet bet = (Bet) sessionFactory.getCurrentSession().load(Bet.class, id);
		return bet;
	}

	public void removeBet(Bet bet) {
		sessionFactory.getCurrentSession().delete(bet);
	}

	public List<Bet> findBetsByUser(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Bet bet where bet.user.username=:username");
		query.setParameter("username", username);
		return query.list();
	}

	public List<Bet> findBetsByHorse(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Bet bet where bet.horse.id=:id");
		query.setParameter("id", id);
		return query.list();
	}

}
