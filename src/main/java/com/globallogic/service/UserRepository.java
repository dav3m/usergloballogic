	package com.globallogic.service;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	UserEntity findById(String id);
	UserEntity findByEmailAndPassword(String email, String password);
}
