package net.tarasyuk.horseracebets.dao;

import java.util.List;

import net.tarasyuk.horseracebets.data.Racing;

public interface RacingDao {

	public void addRacing(Racing racing);

	public void removeRacing(Integer id);

	public List<Racing> findAllRacings();

	public Racing findRacing(Integer id);

}
