package com.cinfy.water.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.MCircle;

@Repository
@Transactional
public interface MCircleRepository extends JpaRepository<MCircle, Integer>{

	@Query("SELECT circle FROM MCircle circle WHERE circle.zoneId.id =:zoneId")
	List<MCircle> findCircleByzoneId(@Param("zoneId") Integer zoneId);
  
}
