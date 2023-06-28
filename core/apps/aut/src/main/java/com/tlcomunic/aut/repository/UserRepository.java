package com.tlcomunic.aut.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tlcomunic.aut.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);

	public void deleteByEmail(String email);
}
