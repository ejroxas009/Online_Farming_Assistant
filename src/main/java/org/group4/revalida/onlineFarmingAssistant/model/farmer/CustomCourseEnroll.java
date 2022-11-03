package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDate;

public class CustomCourseEnroll {

	private Long accountId;
	private Long courseId;
	private LocalDate enrollDate;
	
	public Long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public Long getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	public LocalDate getEnrollDate() {
		return enrollDate;
	}
	
	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}
}
