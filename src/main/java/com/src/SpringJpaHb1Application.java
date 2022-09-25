package com.src;


import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.src.bean.JPA.UserEntity;
import com.src.dao.JPA.UserRepository;

@SpringBootApplication
public class SpringJpaHb1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHb1Application.class, args);
		
		
		//data insert into database using Main file
//		ApplicationContext context =  SpringApplication.run(SpringJpaHb1Application.class, args);
//		UserRepository userRepo = context.getBean(UserRepository.class);
		
		//1) save single user
		
//		UserEntity user = new UserEntity();
//		user.setName("Malaya");
//		user.setCity("Baroda");
		
//		System.out.println(userRepo.save(user))	;'
		
		//2) save multiple user
		
//		UserEntity user1 = new UserEntity();
//		user1.setCity("Surat");
//		user1.setName("Kanak");
//
//		UserEntity user2 = new UserEntity();
//		user2.setCity("Jamnager");
//		user2.setName("Vibhav");
//		
//		List<UserEntity> users = List.of(user1,user2);
//		Iterable<UserEntity> user = userRepo.saveAll(users);
//		user.forEach((e)->{
//			System.out.println(e.getName());
//		});
		
		//3) update user of some user
		
		//findbyId is bydefault work on int datatype(serial)
//		List<UserEntity> user = userRepo.findById("bda3f00b-e435-42c3-b902-6ffa4d30e81b");
//		for(UserEntity u:user) {
//			System.out.println(u.getName());
//		}
		
		//4) find by all user
//		Iterable<UserEntity> users=userRepo.findAll();
//		users.forEach((e)->{
//			System.out.println(e.getName());
//			//get all user data
//		});
		
		//5) delete some user
//		Iterable<UserEntity> users=userRepo.findAll();
//		users.forEach((e)->{
//			if(e.getName().equals("Malaya")) {
//				userRepo.delete(e);
//			}
//		});

		//6) Custom Method
//		List<UserEntity> users=userRepo.findByNameAndCity("Vibhav", "Jamnager");
//		for(UserEntity user:users) {
//			System.out.println(user.getName()+" "+user.getCity()+" "+user.getId());
//		}
		//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
		
		//7) Print all data using Query in JPQL Query
//		List<UserEntity> users = userRepo.getAllUser();
//		for(UserEntity user:users) {
//			System.out.println(user.getName()+" "+user.getCity()+" "+user.getId());
//		}
		
		//8) Print user using name Custom Query
//		List<UserEntity> users = userRepo.getUserByName("Vibhav");
//		for(UserEntity user:users) {
//			System.out.println(user.getName()+" "+user.getCity()+" "+user.getId());
//		}
		
		//9) Print the user using city custom Query native query
//		List<UserEntity> users = userRepo.getUserByCity("Surat");
//		for(UserEntity user:users) {
//			System.out.println(user.getName()+" "+user.getCity()+" "+user.getId());
//		}
		
	}

}
