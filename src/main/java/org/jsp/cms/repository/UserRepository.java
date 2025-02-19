package org.jsp.cms.repository;

import java.util.Optional;

import org.jsp.cms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	
//	@Query("select u from User u where u.username=?1 and u.password=?2")
	Optional<User> findByUsernameAndPassword(String username, String password);

}
