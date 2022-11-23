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
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomChangePaymentMode;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomCropPayment;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomProofOfPayment;
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
		System.out.println("Testing " + cropPayment);
		return Response.ok(cropPayment).build();
	}
	
	@GET
	@Path("/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCropPaymentById(@PathParam("cropPaymentId") Long id) {
		Optional<CropPayment> cropPayment = service.getCropPaymentById(id);
		return Response.ok(cropPayment).build();
	}
	
//	//Post
//	@POST
//	@Produces({MediaType.APPLICATION_JSON})
//	@Consumes({MediaType.APPLICATION_JSON})
//	public Response addCropPayment(CropPayment cropPayment) {
//		service.createCropPayment(cropPayment);
//		return Response.ok("Crop Payment was successfully created").build();
//	}
	
	//Post
		@POST
		@Produces({MediaType.APPLICATION_JSON})
		@Consumes({MediaType.APPLICATION_JSON})
		public Response addCropPayment(CustomCropPayment customCropPayment) {
			service.createCropPayment(customCropPayment);
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
	
	@PUT
	@Path("/mark-as-paid/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response markAsPaid(@PathParam("cropPaymentId") Long id) {
		service.markAsPaid(id);
		return Response.ok("You marked your transaction as paid").build();
	}
	//Change Payment Mode                 
	@PUT
	@Path("/change-payment-mode/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response changePaymentMode(CustomChangePaymentMode changePaymentMode, @PathParam("cropPaymentId") Long id) {
		service.changePaymentMode(changePaymentMode, id);
		return Response.ok("Successfully changed the payment mode").build();
	}
	//---Send Proof of Payment
	@PUT
	@Path("/send-proof-of-payment/{cropPaymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response sendProofOfPayment(CustomProofOfPayment proof, @PathParam("cropPaymentId") Long id) {
		service.sendProofOfPayment(proof, id);
		return Response.ok().build();
	}
	
}
