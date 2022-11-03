package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDateTime;

public class CustomBid {

	private Long accountId;
	private Long postId;
	private double bidPrice;
	private String bidMsg;
	private LocalDateTime bidDate;
	private boolean isActive;
	private boolean isPaid;
	private boolean isApproved;
	private LocalDateTime dateApproved;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getBidMsg() {
		return bidMsg;
	}
	public void setBidMsg(String bidMsg) {
		this.bidMsg = bidMsg;
	}
	public LocalDateTime getBidDate() {
		return bidDate;
	}
	public void setBidDate(LocalDateTime bidDate) {
		this.bidDate = bidDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public LocalDateTime getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(LocalDateTime dateApproved) {
		this.dateApproved = dateApproved;
	}
}
