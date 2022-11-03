package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Crop;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name = "advertisement_table")
public class Advertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	@OneToOne
	private Account account;
	@OneToOne
	private Crop crop;
	
	
	@OneToMany(targetEntity = Bid.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ads_fk", referencedColumnName = "postId")
	private List<Bid> bid;
	private String adsDescription;
	private double cropQuantity;
	private double initialPrice;
	private String cropImg;
	private LocalDateTime postDate;
	private boolean isActive;
	
	
	
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	public List<Bid> getBid() {
		return bid;
	}
	public void setBid(List<Bid> bid) {
		this.bid = bid;
	}
	
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
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime localDateTime) {
		this.postDate = localDateTime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
