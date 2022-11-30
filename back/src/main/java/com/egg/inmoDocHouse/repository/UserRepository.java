package com.egg.inmoDocHouse.repository;

import com.egg.inmoDocHouse.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.StyledEditorKit;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    <Optional> UserEntity findByEmail(String email);

    <Optional> UserEntity findByUsernameOrEmail(String username, String email);

    <Optional> UserEntity findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
