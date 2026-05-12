package com.EXTRAJEET.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.EXTRAJEET.entities.UserDetail;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserDetail, Long>{
 Mono<UserDetail> findByUsername (String Username);
}
