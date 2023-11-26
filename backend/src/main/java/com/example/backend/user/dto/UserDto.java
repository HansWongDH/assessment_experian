package com.example.backend.user.dto;

public class UserDto {
	public Long id;
	public String firstName;
	public String lastName;
	public String email;

	public UserDto() {};
	
	public UserDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
