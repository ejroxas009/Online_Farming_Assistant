package org.group4.revalida.onlineFarmingAssistant.resource.admin;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addTips (FarmingTips fTips) {
		fTipsService.createFarmingTips(fTips);
		return Response.ok("Successfully Created").build();
	}
	
	
	
}
