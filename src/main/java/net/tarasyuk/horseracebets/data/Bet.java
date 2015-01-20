package net.tarasyuk.horseracebets.data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.tarasyuk.horseracebets.authorization.User;

@Entity
@Table(name = "BETS")
public class Bet {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
//	@NotNull(message = "Sign in!")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private User user;
	
	@NotNull(message = "Select horse")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Horse horse;

	@Min(1)
	@Column(name = "BETVALUE")
	private int betValue;
	
	@Column(name = "DATE")
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Racing racing;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Racing getRacing() {
		return racing;
	}

	public void setRacing(Racing racing) {
		this.racing = racing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public int getBetValue() {
		return betValue;
	}

	public void setBetValue(int betValue) {
		this.betValue = betValue;
	}



	

}
