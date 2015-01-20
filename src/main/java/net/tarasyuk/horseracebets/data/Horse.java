package net.tarasyuk.horseracebets.data;


import java.util.List;

import net.tarasyuk.horseracebets.data.Bet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HORSES")
public class Horse {
	@Id
	@Column(name = "horse_ID")
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "at least 2 characters!")
	@Column(name = "HORSENAME")
	private String horseName;

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	@Min(value = 1, message = "must be more then 1.0")
	@Column(name = "KOEFICIENT")
	private double koeficient;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "horse")
	List<Bet> bets;
	
//	@ManyToMany(mappedBy="horses")
//	private List<Racing> racingList;                   
	
	public Integer getId() {
		return id;
	}

//	public List<Racing> getRacingList() {
//		return racingList;
//	}

//	public void setRacingList(List<Racing> racingList) {
//		this.racingList = racingList;
//	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public double getKoeficient() {
		return koeficient;
	}

	public void setKoeficient(double koeficient) {
		this.koeficient = koeficient;
	}

}
