package org.group4.revalida.onlineFarmingAssistant.model.farmer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Course;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;

@Entity
@Table(name="course_enroll_table")
public class CourseEnroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long enrollId;
	@OneToOne
	private Account account;
	
//	private Long accountId;
	
	@OneToOne
	private Course course;
	
	private LocalDate enrollDate;

	public CourseEnroll() {
		
	}
	
	public CourseEnroll(Long courseEnrollId, Account account, Course course, LocalDate enrollDate) {
		super();
		this.enrollId = courseEnrollId;
		this.account = account;
		this.course = course;
		this.enrollDate = enrollDate;
	}
	
	public Long getCourseEnrollId() {
		return enrollId;
	}

	public void setCourseEnrollId(Long courseEnrollId) {
		this.enrollId = courseEnrollId;
	}

	public Account getaccount() {
		return account;
	}

	public void setaccount(Account account) {
		this.account = account;
	}
	
	public Course getcourse() {
		return course;
	}

	public void setcourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnrollDate() {
		return enrollDate;
	}
	
	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}

//	public Long getAccountId() {
//		return accountId;
//	}
//
//	public void setAccountId(Long accountId) {
//		this.accountId = accountId;
//	}
	
	
}
