package com.ltms.ltms.repository;

import com.ltms.ltms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository extends JpaRepository<UserEntity, Long> { //Spring data repository
//    List<UserEntity> findByPrice(Double price); #custom find method which is not present in JpaRepository

}