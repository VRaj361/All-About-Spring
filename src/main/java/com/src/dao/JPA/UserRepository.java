package com.src.dao.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.src.bean.JPA.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	List<UserEntity> findById(String id);
	List<UserEntity> findByNameAndCity(String name,String city);
	
	//@Query -> JPQL (Hibernate)
	//       -> Native query
	
	@Query("select u from UserEntity u")
	public List<UserEntity> getAllUser();
	
	@Query("select u from UserEntity u where u.name= :x")
	public List<UserEntity> getUserByName(@Param("x")String name);
	//pass other parameter with using and in query JPQL
	
	@Query(value = "select * from users where city = :n",nativeQuery = true)
	public List<UserEntity> getUserByCity(@Param("n")String city);
}
