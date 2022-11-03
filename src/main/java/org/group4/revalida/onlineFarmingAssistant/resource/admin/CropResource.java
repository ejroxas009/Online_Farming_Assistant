package org.group4.revalida.onlineFarmingAssistant.resource.admin;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Crop;
import org.group4.revalida.onlineFarmingAssistant.service.admin.CropService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/crop")
public class CropResource {
	private final CropService cropService;
	
	@Autowired
	public CropResource(CropService cropService) {
		this.cropService = cropService;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCrop() {
		List<Crop> cropList = cropService.getCrop();
		return Response.ok(cropList).build();
	}
	
	@GET
	@Path("/{cropId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCropById(@PathParam("cropId") Long id) {
		Optional<Crop> crop = cropService.getCropById(id);
		return Response.ok(crop).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addCrop(Crop crop) {
		cropService.createCrop(crop);
		return Response.ok("Successfully Created").build();
	}
	
	@PUT
	@Path("/{cropId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response editCrop(Crop crop, @PathParam("cropId") Long id) {
		cropService.editCrop(crop, id);
		return Response.ok("Successfully Edited").build();
	}
}
