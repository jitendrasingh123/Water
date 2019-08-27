package com.cinfy.water.model.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.CaseRegistration;

@Repository
@Transactional
public interface CaseRegistrationRepository extends JpaRepository<CaseRegistration, Integer>{

	 @Query("select r from CaseRegistration r where r.id=:id ")
	 CaseRegistration findByCaseId(@Param("id") Integer id);
	 
	 @Query("select r from CaseRegistration r  ")
	 CaseRegistration findAll(@Param("id") Integer id);
	 
	
		 
	 @Query("select r from CaseRegistration r where r.caseTypeId.id=:caseTypeId and  r.caseNo=:caseNo and  r.caseYear=:caseYear  ")
	 List<CaseRegistration> findByCaseTypeIdCaseNoYear(@Param("caseTypeId") Integer caseTypeId,@Param("caseNo") Integer caseNo,@Param("caseYear") Integer caseYear);
	 
	 @Query("select r from CaseRegistration r where r.caseTypeId.id=:caseTypeId and  r.caseNo=:caseNo and  r.caseYear=:caseYear  and r.zoneId.id=:zoneId ")
	 List<CaseRegistration> findByCaseTypeIdCaseNoYear(@Param("caseTypeId") Integer caseTypeId,@Param("caseNo") Integer caseNo,@Param("caseYear") Integer caseYear,@Param("zoneId") Integer zoneId);
	 
	 @Query("select r from CaseRegistration r where r.caseTypeId.id=:caseTypeId and  r.caseNo=:caseNo and  r.caseYear=:caseYear  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findByCaseTypeIdCaseNoYear(@Param("caseTypeId") Integer caseTypeId,@Param("caseNo") Integer caseNo,@Param("caseYear") Integer caseYear,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	  
	 @Query("select r from CaseRegistration r where r.caseTypeId.id=:caseTypeId and  r.caseNo=:caseNo and  r.caseYear=:caseYear  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId ")
	 List<CaseRegistration> findByCaseTypeIdCaseNoYear(@Param("caseTypeId") Integer caseTypeId,@Param("caseNo") Integer caseNo,@Param("caseYear") Integer caseYear,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);

	 
	 
	 @Query("select r from CaseRegistration r where r.zoneId.id=:zoneId and  r.circleId.id=:circleId and  r.divisionId.id=:divisionId  ")
	 List<CaseRegistration> findByZoneCircleDivision(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	 
	 @Query("select r from CaseRegistration r where r.zoneId.id=:zoneId and  r.circleId.id=:circleId and  r.divisionId.id=:divisionId and  r.responsHearingDateId.hearingDate>= :fromDateHearing and   r.responsHearingDateId.hearingDate<=:toDateHearing  ")
	 List<CaseRegistration> findByZoneCircleDivisionHearingDate(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId,@Param("fromDateHearing") java.sql.Date fromDateHearing,@Param("toDateHearing") java.sql.Date toDateHearing);
	 
	 @Query("select r from CaseRegistration r where r.zoneId.id=:zoneId and  r.circleId.id=:circleId  and  r.responsHearingDateId.hearingDate>= :fromDateHearing and   r.responsHearingDateId.hearingDate<=:toDateHearing  ")
	 List<CaseRegistration> findByZoneCircleHearingDate(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("fromDateHearing") java.sql.Date fromDateHearing,@Param("toDateHearing") java.sql.Date toDateHearing);
	 
	 @Query("select r from CaseRegistration r where r.zoneId.id=:zoneId  and  r.responsHearingDateId.hearingDate>= :fromDateHearing and   r.responsHearingDateId.hearingDate<=:toDateHearing  ")
	 List<CaseRegistration> findByZoneHearingDate(@Param("zoneId") Integer zoneId,@Param("fromDateHearing") java.sql.Date fromDateHearing,@Param("toDateHearing") java.sql.Date toDateHearing);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate>= :fromDateHearing and   r.responsHearingDateId.hearingDate<=:toDateHearing  ")
	 List<CaseRegistration> findByHearingDate(@Param("fromDateHearing") java. sql.Date fromDateHearing,@Param("toDateHearing") java.sql.Date toDateHearing);
	 
	 
	 @Query("select r from CaseRegistration r where r.zoneId.id=:zoneId and  r.circleId.id=:circleId  ")
	 List<CaseRegistration> findByZoneCircle(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	
	 @Query("select r from CaseRegistration r where r.zoneId.id=:zoneId  ")
	 List<CaseRegistration> findByZone(@Param("zoneId") Integer zoneId);
	 
	 @Query("select r from CaseRegistration r where r.courtNameId.id=:courtId  ")
	 List<CaseRegistration> findByCourtId(@Param("courtId") Integer courtId);	 
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2")
	 List<CaseRegistration> findByLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId")
	 List<CaseRegistration> findByLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findByLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId")
	 List<CaseRegistration> findByLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	 
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2")
	 List<CaseRegistration> findByLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId")
	 List<CaseRegistration> findByLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findByLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2 and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId")
	 List<CaseRegistration> findByLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	 
	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2")
	Integer findByCountLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2);
	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId")
		Integer findByCountLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId);
	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
		Integer findByCountLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2 and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId")
		Integer findByCountLast30DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	 
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId")
	 List<CaseRegistration> findByNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId);
	
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findByNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId ")
	 List<CaseRegistration> findByNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
		
	 @Query("select r from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2")
	 List<CaseRegistration> findByNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2);
	
	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2")
	 Integer findByCountNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2);
	
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId")
	 List<CaseRegistration> findByCountNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId);
	
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findByCountNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId ")
	 List<CaseRegistration> findByCountNext7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	

	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate <= :sqlDate1 and   r.responsHearingDateId.hearingDate >= :sqlDate2")
	 Integer findByCountLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2);
	 
	 
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId")
	 List<CaseRegistration> findByCountLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId);
	
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findByCountLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	
	 @Query("select count(r) from CaseRegistration r where r.responsHearingDateId.hearingDate >= :sqlDate1 and   r.responsHearingDateId.hearingDate<= :sqlDate2  and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId ")
	 List<CaseRegistration> findByCountLast7DayHearingDate(@Param("sqlDate1") java.sql.Date sqlDate1,@Param("sqlDate2") java.sql.Date sqlDate2,@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
		
	
	 
	 @Query("select r from CaseRegistration r where r.caseStatus='Running' ")
	 List<CaseRegistration> findTotalCasesPending();
	 
	 @Query("select r from CaseRegistration r where r.caseStatus='Running' and r.zoneId.id=:zoneId ")
	 List<CaseRegistration> findTotalCasesPending(@Param("zoneId") Integer zoneId);
	 
	 @Query("select r from CaseRegistration r where r.caseStatus='Running' and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findTotalCasesPending(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	 
	 @Query("select r from CaseRegistration r where r.caseStatus='Running' and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId ")
	 List<CaseRegistration> findTotalCasesPending(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	 
	 @Query("select count(r) from CaseRegistration r where r.caseStatus='Running' ")
	 List<CaseRegistration> findCountTotalCasesPending();
	 
	 @Query("select count(r) from CaseRegistration r where r.caseStatus='Running' and r.zoneId.id=:zoneId")
	 List<CaseRegistration> findCountTotalCasesPending(@Param("zoneId") Integer zoneId);
	 
	 @Query("select count(r) from CaseRegistration r where r.caseStatus='Running' and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId")
	 List<CaseRegistration> findCountTotalCasesPending(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId);
	 
	 @Query("select count(r) from CaseRegistration r where r.caseStatus='Running' and r.zoneId.id=:zoneId  and  r.circleId.id=:circleId  and  r.divisionId.id=:divisionId")
	 List<CaseRegistration> findCountTotalCasesPending(@Param("zoneId") Integer zoneId,@Param("circleId") Integer circleId,@Param("divisionId") Integer divisionId);
	 
	 
	
	 
}
