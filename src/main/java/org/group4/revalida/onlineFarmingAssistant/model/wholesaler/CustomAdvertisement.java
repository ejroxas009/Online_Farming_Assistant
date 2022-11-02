package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.ManyToOne;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

public class CustomAdvertisement {
	

	private Long accountId;
//	@OneToOne
//	private Crop crop;
	private String adsDescription;
	private double cropQuantity;
	private double initialPrice;
	private String cropImg;
	private LocalDateTime postDate;
	private boolean isActive;
	
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAdsDescription() {
		return adsDescription;
	}
	public void setAdsDescription(String adsDescription) {
		this.adsDescription = adsDescription;
	}
	public double getCropQuantity() {
		return cropQuantity;
	}
	public void setCropQuantity(double cropQuantity) {
		this.cropQuantity = cropQuantity;
	}
	public double getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}
	public String getCropImg() {
		return cropImg;
	}
	public void setCropImg(String cropImg) {
		this.cropImg = cropImg;
	}
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
