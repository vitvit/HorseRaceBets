package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.authorization.User;
import net.tarasyuk.horseracebets.dao.BetDao;
import net.tarasyuk.horseracebets.dao.UserDao;
import net.tarasyuk.horseracebets.data.Bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BetServiceImpl implements BetService {

	@Autowired
	private BetDao betDao;
	@Autowired
	private UserDao userDao;

	@Transactional
	public Bet findBet(int id) {
		return betDao.findOne(id);
	}

	@Transactional
	public void addBet(Bet bet, String username) {
		User user = userDao.findUser(username);
		bet.setUser(user);
		betDao.addBet(bet);

	}

	@Transactional
	public List<Bet> listBet() {
		return betDao.listBet();

	}

	@Transactional
	// @PreAuthorize("#blog.user.username == authentication.name or hasRole('ADMIN')")
	public void removeBet(@P("bet") Bet bet) {
		betDao.removeBet(bet);
	}

	@Transactional
	public List<Bet> findBetsByUser(String username) {
		return betDao.findBetsByUser(username);
	}

}
