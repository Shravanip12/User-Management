package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.Entity.User;
import com.Entity.UserRepo;

@SpringBootApplication
@EnableCaching
public class Sb7UserProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb7UserProject1Application.class, args);
		
//		ConfigurableApplicationContext conn=SpringApplication.run(Sb7UserProject1Application.class, args);
//		UserRepo ur=conn.getBean(UserRepo.class);
		
//		User u=new User();
//		u.setUname("ram");
//		u.setPhn(8765432);
//		u.setUaddress("pune");
//		
//		User u1=new User();
//		u.setUname("pappu");
//		u.setPhn(9876543);
//		u.setUaddress("pmc");
//		
//		List<User> usr=new ArrayList<User>();
//		usr.add(u);
//		
//		ur.deleteAllById(ids);
	}

}
