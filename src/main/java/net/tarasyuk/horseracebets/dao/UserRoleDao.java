package net.tarasyuk.horseracebets.dao;

import net.tarasyuk.horseracebets.authorization.ListRole;
import net.tarasyuk.horseracebets.authorization.UserRole;

public interface UserRoleDao {

		public UserRole findRole(ListRole role);
		
}
