package com.cinfy.water.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.State;

@Repository
@Transactional
public interface MStateRepository extends JpaRepository<State, Integer>{

	State getById(Integer id);
  
}
