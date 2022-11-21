package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

public class CustomCropPayment {
	
	
	
	private Long advertisementId;
	
	private String paymentMode;
	
	private Long accountId;
	//@OneToOne;
	//private Bid bidId;
	private String orderIdRef;
	private boolean isPaid;
	//private String paymentDetails;
	private Long bidId;
	
	
	public Long getBidId() {
		return bidId;
	}
	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}
	public Long getAdvertisementId() {
		return advertisementId;
	}
	public void setAdvertisementId(Long advertisementId) {
		this.advertisementId = advertisementId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getOrderIdRef() {
		return orderIdRef;
	}
	public void setOrderIdRef(String orderIdRef) {
		this.orderIdRef = orderIdRef;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	
}
