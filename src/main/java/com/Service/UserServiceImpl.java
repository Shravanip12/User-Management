package com.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.DTO.UserDTO;
import com.Entity.User;
import com.Entity.UserRepo;
import com.ExceptionHandler.UserNotFoundException;
import com.mysql.jdbc.log.Log;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private JavaMailSender jms;
	
	@Override
	public User addUserInService(User user) {

		log.info("Userserviceimpl" + user);
		User us = ur.save(user);
		return us;

	}

	@Override
	public void deleteUserInService(int id) {
		User u = ur.findById(id).get();
		ur.delete(u);

	}

	@Override
	public void updateUserInService(User user) {
		ur.save(user);
	}

	@Override
	public UserDTO fetchUserInService(int id) {

//		User u = ur.findById(id).orElseThrow(n -> new UserNotFoundException("User id invalid"));

		User u = ur.findById(id).get();
		
//		u=null;
//		if(u==null) {
//			throw new UserNotFoundException("user id invalid");
//		}
////		
		
		
		log.info("user:" + u);

		String str = null;
		try {
			System.out.println(str.toLowerCase());
		} catch (Exception e) {
			log.error("handles null pointer exception");
		}

//		
//		UserDTO response=new UserDTO();
//		response.setGender(u.getGender());
//		response.setUaddress(u.getUaddress());
//		response.setEmail(u.getEmail());
//		response.setUname(u.getUname());
//		return response;         -----------this code for dto

//		 ModelMapper-below code for using modelmapper

		ModelMapper convert = new ModelMapper();
		UserDTO response = convert.map(u, UserDTO.class);
		return response;
	}

	@Override
	public void SendMailInUs() {
		SimpleMailMessage sms=new SimpleMailMessage();
//		sms.setCc("");
		sms.setTo("shravanipatil9130@gmail.com");
		sms.setSubject("mail testing");
		sms.setText("hi welcome to the empire"
				+ ""
				+ ""
				+ ""
				+ "thanks");
	
		
//		MimeMessage msg=jms.createMimeMessage();
//		
//		
//		
//		try {
//			
//			MimeMessageHelper msgh=new MimeMessageHelper(msg);
//			msgh.setTo("shravanipatil9130@gmail.com,pshravani811@gmail.com");
////			msgh.addAttachment("offer letter", new File("C:\\ss.png"));
//			msgh.setText("hi");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		//you will have to add html template in place of image path
		
		jms.send(sms);
		
		
		
	}

}
