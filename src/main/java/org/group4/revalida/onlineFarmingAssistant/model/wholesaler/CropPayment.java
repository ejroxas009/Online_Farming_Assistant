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
	
}
