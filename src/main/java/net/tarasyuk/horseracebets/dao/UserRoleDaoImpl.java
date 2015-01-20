package net.tarasyuk.horseracebets.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.tarasyuk.horseracebets.authorization.ListRole;
import net.tarasyuk.horseracebets.authorization.UserRole;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	SessionFactory sessionFactory;

	public UserRole findRole(ListRole role) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserRole r where r.listRole=:listRole");
		query.setParameter("listRole", role);
		UserRole result = (UserRole) query.uniqueResult();

		if (result == null) {
			UserRole newRole = new UserRole();
			newRole.setListRole(role);
			sessionFactory.getCurrentSession().save(newRole);
			return newRole;
			
		}
		return result;
	}

}
