package com.springbootmongodb.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the User")
//@JsonIgnoreProperties(value = {"email","dateOfBirth"})
//@JsonFilter(value = "userFilter")
@Document(collection = "UserCollection")
public class User {

	@Id
	private long userId;

	@ApiModelProperty(value = "minimum user name length is 2")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String userName;

	// @JsonIgnore
	private String email;

	@ApiModelProperty(notes = "only allowed past dates, not future dates")
	@Past(message = "Date of bith given is past date , please give valide date")
	private LocalDate dateOfBirth;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}

}