package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name = "crop_payment_table")
public class CropPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	@OneToOne
	private Advertisement advertisement;
	private LocalDateTime paymentDate;
	private Double amount;
	private String paymentMode;
	@OneToOne
	private Account account;
	//@OneToOne;
	//private Bid bidId;
	private String orderIdRef;
	private boolean isPaid;
	//private String paymentDetails;
	


	private String proofOfPayment;
	
	private boolean markAsPaid;
	private boolean markAsCOD;
	
	
	

	@OneToOne
	private Bid bid;


	
	@OneToOne
	private Bid bid;
	
		public boolean isMarkAsCOD() {
		return markAsCOD;
	}
	public void setMarkAsCOD(boolean markAsCOD) {
		this.markAsCOD = markAsCOD;
	}
	
	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public boolean isMarkAsPaid() {
		return markAsPaid;
	}
	public void setMarkAsPaid(boolean markAsPaid) {
		this.markAsPaid = markAsPaid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getProofOfPayment() {
		return proofOfPayment;
	}
	public void setProofOfPayment(String proofOfPayment) {
		this.proofOfPayment = proofOfPayment;
	}
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
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
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
