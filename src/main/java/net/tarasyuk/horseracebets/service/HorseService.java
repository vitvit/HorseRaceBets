package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.data.Horse;

public interface HorseService {
	
	public void addHorse(Horse horse);

	public List<Horse> listHorse();

	public void removeHorse(Integer id);
	
	public Horse findHorseById(Integer horseId);
	
	public Horse findBetsByHorse(Integer id);
	
	public List<Horse> initHorsesForRacing(int number);
	
}
