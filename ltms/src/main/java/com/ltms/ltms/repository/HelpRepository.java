package com.ltms.ltms.repository;
import com.ltms.ltms.entity.HelpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends JpaRepository<HelpEntity, Long > {

}
