package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="bid_table")
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bidId;
	
	@OneToOne
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "adsId")
	private Advertisement advertisement;
	private double bidPrice;
	private String bidMsg;
	private LocalDateTime bidDate;
	private boolean isActive;
	private boolean isPaid;
	private boolean isApproved;
	private boolean isAccept;
	private LocalDateTime dateApproved;
	
	public Bid() {
		
	}

	
	public boolean isAccept() {
		return isAccept;
	}


	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}


	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
