package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name = "advertisement_table")
public class Advertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	@ManyToOne
	private Account account;
//	@OneToOne
//	private Crop crop;
	private String adsDescription;
	private double cropQuantity;
	private double initialPrice;
	private String cropImg;
	private LocalDate postDate;
	private boolean isActive;
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
