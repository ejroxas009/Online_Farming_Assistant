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
	private Long courseEnrollId;
	@OneToOne
	private Account account;
	
//	private Long accountId;
	
	@OneToOne
	private Course courseId;
	private LocalDate enrollDate;

	public CourseEnroll() {
		
	}
	
	public CourseEnroll(Long courseEnrollId, Account account, Course courseId, LocalDate enrollDate) {
		super();
		this.courseEnrollId = courseEnrollId;
		this.account = account;
		this.courseId = courseId;
		this.enrollDate = enrollDate;
	}
	
	public Long getCourseEnrollId() {
		return courseEnrollId;
	}

	public void setCourseEnrollId(Long courseEnrollId) {
		this.courseEnrollId = courseEnrollId;
	}

	public Account getaccount() {
		return account;
	}

	public void setaccount(Account account) {
		this.account = account;
	}
	
	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
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
