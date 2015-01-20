package net.tarasyuk.horseracebets.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RACING")
public class Racing {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

//	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(name="Horses", joinColumns=@JoinColumn(name="horse_id"), inverseJoinColumns=@JoinColumn(name="racing_id"))
//	private List<Horse> horses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public List<Horse> getHorses() {
//		return horses;
//	}

//	public void setHorses(List<Horse> horses) {
//		this.horses = horses;
//	}

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

	@OneToMany( mappedBy = "racing")
	List<Bet> bets;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "DATE")
	private Date date;
	
	@Size(min = 2, message = "at least 2 characters!")
	@Column(name="Hippodrome")
	private String hippodrome;

	public String getHippodrome() {
		return hippodrome;
	}

	public void setHippodrome(String hippodrome) {
		this.hippodrome = hippodrome;
	}

}
