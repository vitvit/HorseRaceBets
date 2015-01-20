package net.tarasyuk.horseracebets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.tarasyuk.horseracebets.dao.HorseDao;
import net.tarasyuk.horseracebets.dao.RacingDao;
import net.tarasyuk.horseracebets.data.Racing;

@Service
public class RacingServiceImpl implements RacingService {

	@Autowired
	RacingDao racingDao;
	@Autowired
	HorseDao horseDao;

	@Transactional
	public void addRacing(Racing racing) {
		racingDao.addRacing(racing);
	}

	@Transactional
	public List<Racing> findAllRacings() {
		return racingDao.findAllRacings();
	}

	@Transactional
	public Racing findRacingWithHorses(Integer id) {
		return racingDao.findRacing(id);

	}

	@Transactional
	public void removeRacing(Integer id) {
		racingDao.removeRacing(id);

	}
}
