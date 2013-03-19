package com.traincoders.intf;

public interface User {
	
	public String getNickname();
	public void setNickname(String nickname);

	public String getName();
	public void setName(String name);

	public String getLastName();
	public void setLastName(String lastName);

	public Integer getUserAge();
	public void setUserAge(Integer userAge);

	public Float getWeight();
	public void setWeight(Float weight);

	public Float getHeight();
	public void setHeight(Float height);

	public char getGender();
	public void setGender(char gender);

	public Long getProdId();
	public void setProdId(Long prodId);

	public java.util.Date getConsumedDate();
	public void setConsumedDate(java.util.Date consumedDate);

	public Integer getAmountConsumed();
	public void setAmountConsumed(Integer amountConsumed);

}
