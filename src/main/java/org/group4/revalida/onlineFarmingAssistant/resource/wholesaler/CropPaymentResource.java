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

import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropPayment;
import org.group4.revalida.onlineFarmingAssistant.service.wholesaler.CropPaymentService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/crop-payment")
public class CropPaymentResource {

	@Autowired
	private CropPaymentService service;
	//Get
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCropPayment() {
		List<CropPayment> cropPayment = service.getCropPayment();
		return Response.ok(cropPayment).build();
	}
	
	@GET
	@Path("/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCropPaymentById(@PathParam("cropPaymentId") Long id) {
		Optional<CropPayment> cropPayment = service.getCropPaymentById(id);
		return Response.ok(cropPayment).build();
	}
	
	//Post
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addCropPayment(CropPayment cropPayment) {
		service.createCropPayment(cropPayment);
		return Response.ok("Crop Payment was successfully created").build();
	}
	
	//Toggle isPaid 
	
	@PUT
	@Path("/receive-payment/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response receivePayment(@PathParam("cropPaymentId") Long id) {
		service.receivePayment(id);
		return Response.ok("Payment was received successfully").build();
	}
	//Change Payment Mode                 
	@PUT
	@Path("/change-payment-mode/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response changePaymentMode(CropPayment cropPayment, @PathParam("cropPaymentId") Long id) {
		service.changePaymentMode(cropPayment, id);
		return Response.ok("Successfully changed the payment mode").build();
	}
}