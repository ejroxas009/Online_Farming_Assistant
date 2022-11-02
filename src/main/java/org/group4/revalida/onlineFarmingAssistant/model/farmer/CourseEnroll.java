package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name="course_enroll_table")
public class CourseEnroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseEnrollId;
//	@OneToMany
//	private Account account;
	
	private Long accountId;
//	private Course courseId;
	private LocalDate enrollDate;
	
	public CourseEnroll() {
		
	}
	
	public CourseEnroll(Long courseEnrollId, Long accountId, LocalDate enrollDate) {
	super();
	this.courseEnrollId = courseEnrollId;
	this.accountId = accountId;
	this.enrollDate = enrollDate;
	}
	
	public Long getCourseEnrollId() {
		return courseEnrollId;
	}

	public void setCourseEnrollId(Long courseEnrollId) {
		this.courseEnrollId = courseEnrollId;
	}

//	public Account getaccount() {
//		return account;
//	}
//
//	public void setaccount(Account account) {
//		this.account = account;
//	}

	public LocalDate getEnrollDate() {
		return enrollDate;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
}
