package com.traincoders.edb;

import com.traincoders.intf.Consumable;

public class EdbConsumable implements Consumable {
	
	private String nickname;
	private Long prodId;
	private java.util.Date consumedDate;
	private Integer amountConsumed;
	
	public EdbConsumable() {
		super();
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
