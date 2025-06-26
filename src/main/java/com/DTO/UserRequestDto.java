package com.DTO;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Validated
public class UserRequestDto {
	
	
	@NotBlank
	@NotNull(message="username should not be null")
	private String username;
	
	@Min(value =18)
	private String age;
	
	
	@Size(min=10,max=50,message="address size should be within this given size")
	private String address;

}
