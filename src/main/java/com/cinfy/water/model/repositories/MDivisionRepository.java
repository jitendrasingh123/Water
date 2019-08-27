package com.cinfy.water.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cinfy.water.model.MDivision;

@Repository
@Transactional
public interface MDivisionRepository extends JpaRepository<MDivision, Integer>{

	@Query("SELECT division FROM MDivision division WHERE division.circleId.id =:circleId")
	List<MDivision> findDivisionByCircleId(@Param("circleId") Integer circleId);
  
}
