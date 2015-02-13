package net.tarasyuk.horseracebets.data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "racing")
public class Racing {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@OneToMany(mappedBy = "racing")
	List<Bet> bets;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private Date date;

	@Size(min = 2, message = "at least 2 characters!")
	@Column(name = "hippodrome")
	private String hippodrome;

	private final  Integer numberOfHorses = 5;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "racing_horses", joinColumns = @JoinColumn(name = "racing_id"), inverseJoinColumns = @JoinColumn(name = "horse_id"))
	private List<Horse> horses;

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Horse> getHorses() {
		return horses;
	}

	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}

	public String getHippodrome() {
		return hippodrome;
	}

	public void setHippodrome(String hippodrome) {
		this.hippodrome = hippodrome;
	}

	public int getNumberOfHorses() {
		return numberOfHorses;
	}
}
