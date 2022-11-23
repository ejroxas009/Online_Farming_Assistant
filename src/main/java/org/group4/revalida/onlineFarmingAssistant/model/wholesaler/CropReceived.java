package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name = "crop_received_table")
public class CropReceived {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cropReceivedId;
	@OneToOne
	private Advertisement advertisement;
	@OneToOne
	private Account account;
	private LocalDateTime receivedTime;
	private boolean isReceived;
	@OneToOne
	private Bid bid;
	private String orderIdRef;
	
	
	
	
	public String getOrderIdRef() {
		return orderIdRef;
	}
	public void setOrderIdRef(String orderIdRef) {
		this.orderIdRef = orderIdRef;
	}
	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public Long getCropReceivedId() {
		return cropReceivedId;
	}
	public void setCropReceivedId(Long cropReceivedId) {
		this.cropReceivedId = cropReceivedId;
	}
	public Advertisement getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	public LocalDateTime getReceivedTime() {
		return receivedTime;
	}
	public void setReceivedTime(LocalDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
