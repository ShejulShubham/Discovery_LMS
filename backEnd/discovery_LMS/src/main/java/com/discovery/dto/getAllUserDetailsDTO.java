package com.discovery.dto;

import com.discovery.entities.BorrowStatus;
import com.discovery.entities.UserRole;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class getAllUserDetailsDTO {
	
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private UserRole role;
	
	private String book;
	
	private BorrowStatus bStatus;
	
	private String status;
	
	
	
}
