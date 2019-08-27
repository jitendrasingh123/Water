package com.cinfy.water.model.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinfy.water.model.User;

@Repository
@Transactional
public interface LoginRepository extends JpaRepository<User, Integer>{

	@Query("select account  from User account where upper(account.password)=upper(?1) "+
	        " and ( upper(account.userId)=upper(?2)  or upper(account.mobile)=upper(?3) )" )
	User findByPasswordAndEmailOrMobileAllIgnoreCase (String password,String userId, String mobile);
	
	@Query("select r from User r where r.role='admin' ")
	List<User>  findThroughRole();
  
}
