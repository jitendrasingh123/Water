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

@Repository
@Transactional
public interface ResponsHearingDateRepository extends JpaRepository<ResponsHearingDate, Integer>{

	 @Query("select r from ResponsHearingDate r where r.id=:id ")
	 ResponsHearingDate findByCaseId(@Param("id") Integer id);
	 
	 @Modifying
	 @Query("update ResponsHearingDate r set r.responsDate =:responsDate,r.hearingDate =:hearingDate where r.id =:id ")
	 void updateResponsHearingDate(@Param("id") Integer id,@Param("responsDate") Date responsDate,@Param("hearingDate") Date hearingDate);
}
