package pe.edu.ucsp.oms.repository;

import java.util.List;

import pe.edu.ucsp.oms.domain.User;

public interface UserDao extends GenericDao<User, Integer> {
	User findByEmail(String email);

	List<User> filterByEmail(String email);
}
