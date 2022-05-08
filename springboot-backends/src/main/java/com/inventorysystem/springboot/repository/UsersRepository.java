package com.inventorysystem.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorysystem.springboot.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	public Optional<Users> findByUsername(String username);
}
