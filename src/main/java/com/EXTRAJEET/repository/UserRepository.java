package com.EXTRAJEET.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EXTRAJEET.entities.UserDetail;
@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long>{
 Optional<UserDetail> findByUsername (String Username);
}
