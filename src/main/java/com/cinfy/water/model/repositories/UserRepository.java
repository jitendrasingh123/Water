package com.cinfy.water.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select account  from User account where upper(account.password)=upper(?1) "
			+ " and ( upper(account.userId)=upper(?2)  or upper(account.mobile)=upper(?3) )")
	User findByPasswordAndEmailOrMobileAllIgnoreCase(String password, String userId, String mobile);

	@Query("select r from User r where r.role='admin' ")
	List<User> findThroughRole();
	
	@Query("SELECT CASE WHEN COUNT(account) > 0 THEN true ELSE false END FROM User account WHERE account.mobile=:mobileNo")
    boolean existsByMobile(@Param("mobileNo") String mobileNo);
	
	@Query("SELECT CASE WHEN COUNT(account) > 0 THEN true ELSE false END FROM User account WHERE account.userId=:userId")
    boolean existsByEmail(@Param("userId") String userId);

	@Query("SELECT r FROM User r WHERE r.id=:id ")
	User findById(@Param("id") Integer id);

	List<User> findByUserId(String email);

	List<User> findByMobile(String phone);

	@Query("select account from User account")
	List<User> findAllUser();

	User findByUserIdOrMobileAllIgnoreCase(String userId, String phone);

	@Query("select account from User account where upper(account.password)=upper(?1) "
			+ " and ( upper(account.userId)=upper(?2)  or upper(account.mobile)=upper(?3) )")
	User findByPasswordAndUserIdOrMobileAllIgnoreCase(String password, String email, String phone);

	@Query("SELECT r FROM User r WHERE r.zoneId.id=:zoneId AND r.circleId.id=:circleId AND r.divisionId.id=:divisionId")
	List<User> findByZoneCircleDivision(@Param("zoneId") Integer zoneId,
			@Param("circleId") Integer circleId, @Param("divisionId") Integer divisionId);
	
	@Query("SELECT r FROM User r WHERE r.zoneId.id=:zoneId AND r.circleId.id=:circleId")
	List<User> findByZoneCircle(@Param("zoneId") Integer zoneId,
			@Param("circleId") Integer circleId);
	
	@Query("SELECT r FROM User r WHERE r.zoneId.id=:zoneId")
	List<User> findByZone(@Param("zoneId") Integer zoneId);
	

	@Modifying
	@Query("UPDATE User r SET r.deviceToken =:deviceToken WHERE r.id=:id ")
	void updateDeviceToken(@Param("deviceToken") String deviceToken, @Param("id") Integer id);

}
