package com.cinfy.water.model.repositories;


import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.ResponsHearingDate;
import com.cinfy.water.model.ResponsHearingDateOld;

@Repository
@Transactional
public interface ResponsHearingDateOldRepository extends JpaRepository<ResponsHearingDateOld, Integer>{

	 @Query("select r from ResponsHearingDateOld r where r.id=:id ")
	 ResponsHearingDateOld findByCaseId(@Param("id") Integer id);
	 
	
}
