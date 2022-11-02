package org.group4.revalida.onlineFarmingAssistant.resource.admin;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Course;
import org.group4.revalida.onlineFarmingAssistant.service.admin.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/course")
public class CourseResource {
	private final CourseService courseService;
	
	@Autowired
	public CourseResource(CourseService courseservice) {
		this.courseService = courseservice;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCourse() {
		List<Course> courseList = courseService.getCourse();
		return Response.ok(courseList).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addCourse(Course course) {
		courseService.createCourse(course);
		return Response.ok("Successfully Created").build();
	}
}
