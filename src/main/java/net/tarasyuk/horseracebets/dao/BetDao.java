package net.tarasyuk.horseracebets.dao;

import java.util.List;

import net.tarasyuk.horseracebets.data.Bet;

public interface BetDao {

	public void addBet(Bet bet);

	public List<Bet> listBet();

	public void removeBet(Bet bet);

	public Bet findOne(int id);
	
	public List<Bet> findBetsByUser(String username);
	
	public List<Bet> findBetsByHorse(Integer id);
	
}
