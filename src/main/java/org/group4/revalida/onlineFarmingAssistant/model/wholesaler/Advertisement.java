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
//	@ManyToOne
//	private Crop crop;
	private String adsDescription;
	private double cropQuantity;
	private double initialPrice;
	private String cropImg;
	private LocalDate postDate;
	private boolean isActive;
	
}
