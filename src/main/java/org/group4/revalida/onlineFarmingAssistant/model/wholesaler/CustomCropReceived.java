package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;



public class CustomCropReceived {
	
	
	
	private Long advertisementId;
	private boolean isReceived;
	private Long accountId;
	private Long bidId;
	private String orderIdRef;
	
	
	
	public String getOrderIdRef() {
		return orderIdRef;
	}
	public void setOrderIdRef(String orderIdRef) {
		this.orderIdRef = orderIdRef;
	}
	public Long getBidId() {
		return bidId;
	}
	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}
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
