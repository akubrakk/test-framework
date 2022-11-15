package io.swagger.petstore.responses;

import lombok.Data;

@Data
public class GeneralResponse{
	private int code;
	private String type;
	private String message;
	private String username;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int userStatus;
}