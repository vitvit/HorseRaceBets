package net.tarasyuk.horseracebets.authorization;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class UserRole {
	
	@ManyToMany(mappedBy="userRoles")
	private Set<User> user = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	private ListRole listRole;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id;

	public ListRole getListRole() {
		return listRole;
	}

	public void setListRole(ListRole listRole) {
		this.listRole = listRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
