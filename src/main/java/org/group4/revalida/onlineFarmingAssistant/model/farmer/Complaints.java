package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name="complaints_table")
public class Complaints {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long complaintId;
	private Account account;
	private String complaintPost;
	private String complaintImg;
	private boolean isRead;
	
	public Complaints() {
		
	}
	
	public Complaints(Long complaintId, Account account, String complaintPost, String complaintImg, boolean isRead) {
		super();
		this.complaintId = complaintId;
		this.account = account;
		this.complaintPost = complaintPost;
		this.complaintImg = complaintImg;
		this.isRead = isRead;
	}

	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getComplaintPost() {
		return complaintPost;
	}

	public void setComplaintPost(String complaintPost) {
		this.complaintPost = complaintPost;
	}

	public String getComplaintImg() {
		return complaintImg;
	}

	public void setComplaintImg(String complaintImg) {
		this.complaintImg = complaintImg;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	
	
}
