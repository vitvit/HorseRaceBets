package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.data.Bet;

public interface BetService {

	public void addBet(Bet bet, String username);

	public List<Bet> listBet();

	public void removeBet(Bet bet);

	public Bet findBet(int id);
	
	public List<Bet> findBetsByUser(String username);
		
}