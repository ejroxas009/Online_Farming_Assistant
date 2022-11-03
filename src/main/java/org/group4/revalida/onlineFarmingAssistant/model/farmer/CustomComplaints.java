package org.group4.revalida.onlineFarmingAssistant.model.farmer;

public class CustomComplaints {

	private Long accountId;
	private String complaintPost;
	private String complaintImg;
	private boolean isRead;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
