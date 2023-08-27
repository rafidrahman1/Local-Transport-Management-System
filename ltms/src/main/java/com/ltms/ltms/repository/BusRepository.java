package com.ltms.ltms.repository;

import com.ltms.ltms.entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface BusRepository extends JpaRepository<BusEntity, Long> { //Spring data repository
//    List<BusEntity> findByPrice(Double price); #custom find method which is not present in JpaRepository

}