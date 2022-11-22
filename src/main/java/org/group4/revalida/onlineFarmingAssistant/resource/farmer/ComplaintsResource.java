package org.group4.revalida.onlineFarmingAssistant.resource.farmer;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Complaints;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CustomComplaints;
import org.group4.revalida.onlineFarmingAssistant.service.farmer.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/complaints")
public class ComplaintsResource {

	private final ComplaintsService complaintsService;
	
	@Autowired
	public ComplaintsResource(ComplaintsService complaintsService) {
		this.complaintsService = complaintsService;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getComplaints() {
		List<Complaints> complaintsList = complaintsService.getComplaints();
		return Response.ok(complaintsList).build();
	}
	
	@GET
	@Path("/{complaintId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getComplaintsById(@PathParam("complaintId") Long id) {
		Optional<Complaints> complt = complaintsService.getComplaintsById(id);
		return Response.ok(complt).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response postComplaint(CustomComplaints customComplt) {
		complaintsService.postComplaints(customComplt);
		return Response.ok("Successfully post your complaint.").build();
	}
	
	//Toggle isRead
	@PUT
	@Path("/complaint-status/{complaintId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response complaintStatus(@PathParam("complaintId") Long id) {
		complaintsService.complaintStatus(id);
		return Response.ok("Complaint Status: Read").build();
	}
	
	//Toggle isResolved
	@PUT
	@Path("/complaint-solution/{complaintId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response complaintSolution(@PathParam("complaintId") Long id) {
		complaintsService.complaintSolution(id);
		return Response.ok("Complaint: Resolved").build();
	}
	
}
