package net.tarasyuk.horseracebets.service;

import java.util.ArrayList;
import java.util.List;

import net.tarasyuk.horseracebets.dao.BetDao;
import net.tarasyuk.horseracebets.dao.HorseDao;
import net.tarasyuk.horseracebets.dao.RacingDao;
import net.tarasyuk.horseracebets.data.Bet;
import net.tarasyuk.horseracebets.data.Horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HorseServiceImpl implements HorseService {

	@Autowired
	HorseDao horseDao;
	@Autowired
	BetDao betDao;
	@Autowired
	RacingDao racingDao;

	@Transactional
	public void addHorse(Horse horse) {
		horseDao.addHorse(horse);

	}

	@Transactional
	public List<Horse> listHorse() {
		return horseDao.listHorse();
	}

	@Transactional
	public void removeHorse(Integer id) {
		horseDao.removeHorse(id);

	}

	@Transactional
	public Horse findHorseById(Integer horseId) {
		return horseDao.findHorseById(horseId);
	}

	@Transactional
	public Horse findBetsByHorse(Integer id) {
		Horse horse = findHorseById(id);
		List<Bet> bets = betDao.findBetsByHorse(id);
		horse.setBets(bets);
		return horse;
	}

	public List<Horse> initHorsesForRacing(int number) {
		List<Horse> horses = new ArrayList<>();

		for (int i = 0; i < number; i++) {
			horses.add(new Horse());
		}

		return horses;
	}

}
