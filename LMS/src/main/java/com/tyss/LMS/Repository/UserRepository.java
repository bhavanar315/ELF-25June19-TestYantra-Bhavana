package com.tyss.LMS.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tyss.LMS.dto.UserDetails;



public interface UserRepository extends CrudRepository<UserDetails, Integer> {
	@Query("Select u from UserDetails u where u.email=:email")
	public UserDetails findByEmail(@Param("email") String email);
	
	
	@Query("SELECT u FROM UserDetails u WHERE " +
//            "LOWER(u.userId) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "(u.firstName) LIKE (CONCAT('%',:searchTerm, '%'))")
    List<UserDetails> findBySearchTerm(@Param("searchTerm") String searchTerm);
    	

}
