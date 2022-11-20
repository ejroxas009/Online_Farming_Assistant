package org.group4.revalida.onlineFarmingAssistant.service.admin;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Course;
import org.group4.revalida.onlineFarmingAssistant.repo.admin.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	public CourseService() {
		
	}
	@Autowired
	private CourseRepo courseRepo;
	
	public List<Course> getCourse(){
		return courseRepo.findAll();
	}
	
	public Optional<Course> getCourseById(Long id){
		return courseRepo.findById(id);
	}
	
	public Course createCourse (Course course) {
		return courseRepo.save(course);
	}
	
	public void deleteCourse (Long id) {
		courseRepo.deleteById(id);
		}
	
	public Course editCourse(Course course, Long Id) {
		Course courseInDb  = courseRepo.findById(Id).orElseThrow(NotFoundException::new);
		courseInDb.setCourseDescription(course.getCourseDescription());
		courseInDb.setStartDate(course.getStartDate());
		courseInDb.setEndDate(course.getEndDate());
		courseInDb.setStartTime(course.getStartTime());
		courseInDb.setEndTime(course.getEndTime());
		
		return courseRepo.save(courseInDb);
	}
}
