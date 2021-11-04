package com.user.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByRole(String role);
	
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1, u.role = ?2 where u.id = ?3")
	int setUserInfoById(String name, String role, long l);
	
}
