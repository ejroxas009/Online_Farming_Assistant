package org.group4.revalida.onlineFarmingAssistant.model.shared;

import java.time.LocalDateTime;

public class TransactionHistory {
//-------Ads details
	private String postId;
	private String adsDescription;
	private String cropImg;
	private String cropQuantity;
	private String initialPrice;
	private LocalDateTime postDate;
	private Long cropId;
	private Long cropName;
	private Long accountId;
	private Long accountName;
	//-----Bid----
	private Long bidId;
	private LocalDateTime bidDate;
	private String bidMessage;
	private double bidPrice;
	private LocalDateTime dateApproved;
	private Long bidderId;
	private String BidderName;
	//--------Payment-----------
	private Long paymentId;
	private String orderIdRef;
	private String paymentDate;
	private String paymentMode;
	//-------Receive -----------
	private Long cropReceivedId;
	private LocalDateTime receivedTime;
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getAdsDescription() {
		return adsDescription;
	}
	public void setAdsDescription(String adsDescription) {
		this.adsDescription = adsDescription;
	}
	public String getCropImg() {
		return cropImg;
	}
	public void setCropImg(String cropImg) {
		this.cropImg = cropImg;
	}
	public String getCropQuantity() {
		return cropQuantity;
	}
	public void setCropQuantity(String cropQuantity) {
		this.cropQuantity = cropQuantity;
	}
	public String getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(String initialPrice) {
		this.initialPrice = initialPrice;
	}
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
	public Long getCropId() {
		return cropId;
	}
	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}
	public Long getCropName() {
		return cropName;
	}
	public void setCropName(Long cropName) {
		this.cropName = cropName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getAccountName() {
		return accountName;
	}
	public void setAccountName(Long accountName) {
		this.accountName = accountName;
	}
	public Long getBidId() {
		return bidId;
	}
	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}
	public LocalDateTime getBidDate() {
		return bidDate;
	}
	public void setBidDate(LocalDateTime bidDate) {
		this.bidDate = bidDate;
	}
	public String getBidMessage() {
		return bidMessage;
	}
	public void setBidMessage(String bidMessage) {
		this.bidMessage = bidMessage;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public LocalDateTime getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(LocalDateTime dateApproved) {
		this.dateApproved = dateApproved;
	}
	public Long getBidderId() {
		return bidderId;
	}
	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}
	public String getBidderName() {
		return BidderName;
	}
	public void setBidderName(String bidderName) {
		BidderName = bidderName;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderIdRef() {
		return orderIdRef;
	}
	public void setOrderIdRef(String orderIdRef) {
		this.orderIdRef = orderIdRef;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Long getCropReceivedId() {
		return cropReceivedId;
	}
	public void setCropReceivedId(Long cropReceivedId) {
		this.cropReceivedId = cropReceivedId;
	}
	public LocalDateTime getReceivedTime() {
		return receivedTime;
	}
	public void setReceivedTime(LocalDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}
	
	
	
	
	
}
