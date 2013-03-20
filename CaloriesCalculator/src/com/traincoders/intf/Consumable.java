package com.traincoders.intf;

public interface Consumable {
	
	public String getNickname();
	public void setNickname(String nickname);
	
	public Long getProdId();
	public void setProdId(Long prodId);
	
	public java.util.Date getConsumedDate();
	public void setConsumedDate(java.util.Date consumedDate);
	
	public Integer getAmountConsumed();
	public void setAmountConsumed(Integer amountConsumed);

}
