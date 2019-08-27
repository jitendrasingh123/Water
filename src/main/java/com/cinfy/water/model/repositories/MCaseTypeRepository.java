package com.cinfy.water.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.MCaseType;

@Repository
@Transactional
public interface MCaseTypeRepository extends JpaRepository<MCaseType, Integer>{

}
