package com.cinfy.water.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.MZone;

@Repository
@Transactional
public interface MZoneRepository extends JpaRepository<MZone, Integer>{

	MZone getById(Integer id);

	
  
}
