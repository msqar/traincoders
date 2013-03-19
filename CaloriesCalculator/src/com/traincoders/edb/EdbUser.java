package com.traincoders.edb;

import com.traincoders.intf.User;

public class EdbUser implements User {
	
	private String nickname;
	private String name;
	private String lastName;
	private Integer userAge;
	private Float weight;
	private Float height;
	private char gender;
	private Long prodId;
	private java.util.Date consumedDate;
	private Integer amountConsumed;
	
	public EdbUser(){
		super();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public java.util.Date getConsumedDate() {
		return consumedDate;
	}

	public void setConsumedDate(java.util.Date consumedDate) {
		this.consumedDate = consumedDate;
	}

	public Integer getAmountConsumed() {
		return amountConsumed;
	}

	public void setAmountConsumed(Integer amountConsumed) {
		this.amountConsumed = amountConsumed;
	}   

}
