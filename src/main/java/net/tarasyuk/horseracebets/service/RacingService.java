package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.data.Racing;

public interface RacingService {

	public void addRacing(Racing racing);

	public void removeRacing(Integer id);

	public List<Racing> findAllRacings();

	public Racing findRacingWithHorses(Integer id);

}
