package net.tarasyuk.horseracebets.dao;

import java.util.List;

import net.tarasyuk.horseracebets.data.Horse;

public interface HorseDao {

	public void addHorse(Horse horse);

	public List<Horse> listHorse();

	public void removeHorse(Integer id);

	public Horse findHorseById(Integer id);

	// public Set<Horse> findHorsesByRacing(Integer id);
}
