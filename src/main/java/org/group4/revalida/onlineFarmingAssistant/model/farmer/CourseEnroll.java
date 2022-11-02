package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name="course_enroll_table")
public class CourseEnroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseEnrollId;
	private Account accountId;
//	private Course courseId;
	private LocalDate enrollDate;
	
	public CourseEnroll() {
		
	}
	
	public Long getCourseEnrollId() {
		return courseEnrollId;
	}

	public void setCourseEnrollId(Long courseEnrollId) {
		this.courseEnrollId = courseEnrollId;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public LocalDate getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}

	public CourseEnroll(Long courseEnrollId, Account accountId, LocalDate enrollDate) {
	super();
	this.courseEnrollId = courseEnrollId;
	this.accountId = accountId;
	this.enrollDate = enrollDate;
}
	
	
}
