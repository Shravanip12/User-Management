package com.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.DTO.UserDTO;
import com.DTO.UserRequestDto;
import com.Entity.User;
import com.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/exponent/user/v1")
@Tag(name = "User Related operation" , description = "All User operation Like ADD,DELETE,GET,PUT,POST")//swagger related annotation


public class UserController {
	@Autowired
	private UserService us;

	final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Operation(summary = "User Registration", description = "In this api we are registring USer")//swagger related annotation
	@PostMapping("/validChcek")
	public ResponseEntity<?> ValidateAPI(@RequestBody @Valid UserRequestDto userRdto) {
		log.info("user details" + userRdto);
		log.debug("debug" + userRdto);
//		User u = us.addUserInService(user);
		return new ResponseEntity(userRdto, HttpStatus.OK);

	}
	@DeleteMapping("/deleteuser")
	public ResponseEntity<?> deleteUsersOnTheBasisOfID(@RequestParam("uid") int id) {
		us.deleteUserInService(id);
		log.info("user deleted");
		return new ResponseEntity("user deletd", HttpStatus.OK);
//	
	}
	@PutMapping("/updateuser")
	public ResponseEntity<?>updateUserByUid(@RequestBody User user ){
		us.updateUserInService(user);
		return new ResponseEntity("user deletd", HttpStatus.OK);
	}
	
	@GetMapping("/getallUser/{id}")
	@Cacheable("id1")
	public ResponseEntity<?> fetchuser(@PathVariable("id")int id){
		log.info("user id"+id);
		UserDTO ures=us.fetchUserInService(id);
		return new ResponseEntity(ures, HttpStatus.OK);
	}
	
	@PostMapping("/sendmail")
	public ResponseEntity<?> SendingMail() {
		us.SendMailInUs();
		
//		User u = us.addUserInService(user);
		return new ResponseEntity("mail sent successfully", HttpStatus.OK);
}
}
