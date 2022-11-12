package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;



public class CustomCropReceived {
	
	
	
	private Long advertisementId;
	private boolean isReceived;
	private Long accountId;
	
	
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getAdvertisementId() {
		return advertisementId;
	}
	public void setAdvertisementId(Long advertisementId) {
		this.advertisementId = advertisementId;
	}
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	
	
}
