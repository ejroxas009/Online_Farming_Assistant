package org.group4.revalida.onlineFarmingAssistant.resource.admin;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.group4.revalida.onlineFarmingAssistant.model.admin.FarmingTips;
import org.group4.revalida.onlineFarmingAssistant.service.admin.FarmingTipsService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/farmingtips")
public class FarmingTipsResource {
	private final FarmingTipsService fTipsService;
	
	@Autowired
	public FarmingTipsResource(FarmingTipsService fTipsService) {
		this.fTipsService = fTipsService;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getFarmingTips() {
		List<FarmingTips> fTipsList = fTipsService.getFarmingTips();
		return Response.ok(fTipsList).build();
	}
	
	@GET
	@Path("/{farmingTipsId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getFarmingTipsById(@PathParam("farmingTipsId") Long id) {
		Optional<FarmingTips> fTips = fTipsService.getFarmingTipsById(id);
		return Response.ok(fTips).build();
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON}) 
	public Response addTips (FarmingTips fTips) {
		fTipsService.createFarmingTips(fTips);
		return Response.ok("Successfully Created").build();
	}
	
	@PUT
	@Path("/{farmingTipsId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response editFarmingTips(FarmingTips fTips, @PathParam("farmingTipsId")Long id) {
		fTipsService.editFarmingTips(fTips, id);
		return Response.ok("Successfully Edited").build();
	}
	
	@DELETE
	@Path("/{farmingTipsId}")
	@Produces
	@Consumes
	public Response deleteFarmingTips(FarmingTips fTips, @PathParam("farmingTipsId")Long id) {
		fTipsService.deleteFarmingTips(id);
		return Response.ok("Successfully Deleted").build();
	}
	
}
