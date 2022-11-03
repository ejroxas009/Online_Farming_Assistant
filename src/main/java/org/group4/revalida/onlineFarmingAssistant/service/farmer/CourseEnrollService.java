package org.group4.revalida.onlineFarmingAssistant.service.farmer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Course;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CourseEnroll;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CustomCourseEnroll;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.repo.admin.CourseRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.CourseEnrollRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseEnrollService {

	@Autowired
	CourseEnrollRepo courseEnrollRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	CourseRepo courseRepo;
	
	public List<CourseEnroll> getCourseEnroll(){
		return courseEnrollRepo.findAll();
	}
	
	public Optional<CourseEnroll> getCourseEnrollById(Long id){
		return courseEnrollRepo.findById(id);
	}
	
	public CourseEnroll createCourseEnroll(CustomCourseEnroll customEnroll) {
		Account account = accountRepo.findById(customEnroll.getAccountId()).orElseThrow(NotFoundException::new);
		Course course = courseRepo.findById(customEnroll.getCourseId()).orElseThrow(NotFoundException::new);
		CourseEnroll enroll = new CourseEnroll();
		enroll.setaccount(account);
		enroll.setcourse(course);
		enroll.setEnrollDate(LocalDate.now());
		return courseEnrollRepo.save(enroll);
	}
	
} 
