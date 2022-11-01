package org.group4.revalida.onlineFarmingAssistant.resource.wholesaler;

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

import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropReceived;
import org.group4.revalida.onlineFarmingAssistant.service.wholesaler.CropReceivedService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/crop-received")
public class CropReceivedResource {
	
	@Autowired
	private CropReceivedService service;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCropReceived() {
		List<CropReceived> cropReceived = service.getCropReceived();
		return Response.ok(cropReceived).build();
	}
	
	@GET
	@Path("/{cropReceivedId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCropReceivedById(@PathParam("cropReceivedId") Long id) {
		Optional<CropReceived> cropReceived = service.getCropReceivedById(id);
		return Response.ok(cropReceived).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addCropReceived(CropReceived cropReceived) {
		service.createCropReceived(cropReceived);
		return Response.ok("CropReceived was successfully created").build();
	}
	
	@PUT
	@Path("/receive-crop/{cropReceivedId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response receiveCrop(@PathParam("cropReceivedId") Long id) {
		service.receiveCrop(id);
		return Response.ok("Crop Received Successfully").build();
	}

}
