package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;

@Entity
@Table(name="bid_table")
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bidId;
	@OneToOne
	private Advertisement postId;
//	private Long postId;
	
	private double bidPrice;
	private String bidMsg;
	private LocalDateTime bidDate;
	private boolean isActive;
	private boolean isPaid;
	private boolean isApproved;
	private LocalDateTime dateApproved;
	
	public Bid() {
		
	}
	
	public Bid(Long bidId, Advertisement postId, double bidPrice, String bidMsg, LocalDateTime bidDate, boolean isActive,
			boolean isPaid, boolean isApproved, LocalDateTime dateApproved) {
		super();
		this.bidId = bidId;
		this.postId = postId;
		this.bidPrice = bidPrice;
		this.bidMsg = bidMsg;
		this.bidDate = bidDate;
		this.isActive = isActive;
		this.isPaid = isPaid;
		this.isApproved = isApproved;
		this.dateApproved = dateApproved;
	}
	
	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public Advertisement getPostId() {
		return postId;
	}

	public void setPostId(Advertisement postId) {
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
