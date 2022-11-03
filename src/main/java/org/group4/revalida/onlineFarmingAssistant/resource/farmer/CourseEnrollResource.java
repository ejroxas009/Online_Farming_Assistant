package org.group4.revalida.onlineFarmingAssistant.resource.farmer;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.CourseEnroll;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CustomCourseEnroll;
import org.group4.revalida.onlineFarmingAssistant.service.farmer.CourseEnrollService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/enroll-course")
public class CourseEnrollResource {
	
	private final CourseEnrollService service;
	
	@Autowired
	public CourseEnrollResource(CourseEnrollService service) {
		this.service = service;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCourseEnroll() {
		List<CourseEnroll> courseEnrolledList = service.getCourseEnroll();
		return Response.ok(courseEnrolledList).build();
	}
	
	@GET
	@Path("/{enrollId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCourseEnrollById(@PathParam("enrollId") Long id) {
		Optional<CourseEnroll> courseEnrolled = service.getCourseEnrollById(id);
		return Response.ok(courseEnrolled).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response courseEnroll(CustomCourseEnroll customEnroll) {
		service.createCourseEnroll(customEnroll);
		return Response.ok("Successfully create & enrolled your course.").build();
	}
	
}