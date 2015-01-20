package net.tarasyuk.horseracebets.authorization;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.validation.constraints.Size;

import net.tarasyuk.horseracebets.annotation.UniqueUsername;
import net.tarasyuk.horseracebets.data.Bet;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER")
public class User implements UserDetails{
	
	private static final long serialVersionUID = -4546700979813562982L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
	
	@Size(min= 3, message="login must be least as 3 charachters")
	@Column(name = "USERNAME", unique=true)
	@UniqueUsername(message="Such username already exist!")
	private String username;

	@Size(min= 4, message="login must be least as 4 charachters")
	@Column(name = "PASSWORD")
	private String password;
	
	@Size(min = 1, message="invalid e-mail")
	@Email
	@Column(name= "EMAIL")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<UserRole> userRoles = new HashSet<>();
	
	@OneToMany(cascade={/**CascadeType.PERSIST, CascadeType.MERGE,*/CascadeType.REMOVE}, mappedBy = "user")
	List<Bet> bets;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> result=new ArrayList<>();
		
		for(UserRole userRole:userRoles){
			result.add(new SimpleGrantedAuthority(userRole.getListRole().name()));
		}
		return result;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
