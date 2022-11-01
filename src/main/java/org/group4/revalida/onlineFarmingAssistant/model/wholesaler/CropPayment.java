package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name = "crop__payment_table")
public class CropPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	@OneToOne
	private Advertisement advertisement;
	private LocalDate paymentDate;
	private String paymentMode;
	@OneToOne
	private Account account;
	//@OneToOne;
	//private Bid bidId;
	private String orderIdRef;
	private boolean isPaid;
	//private String paymentDetails;
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Advertisement getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
