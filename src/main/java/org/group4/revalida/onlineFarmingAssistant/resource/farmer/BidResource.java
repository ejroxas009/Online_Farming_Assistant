package org.group4.revalida.onlineFarmingAssistant.resource.farmer;

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

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CustomBid;
import org.group4.revalida.onlineFarmingAssistant.service.farmer.BidService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/bid")
public class BidResource {

	private final BidService bidService;
	
	@Autowired
	public BidResource(BidService bidService) {
		this.bidService = bidService;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getBid() {
		List<Bid> bidsList = bidService.getBid();
		return Response.ok(bidsList).build();
	}
	
	@GET
	@Path("/{bidId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getBidById(@PathParam("bidId") Long id) {
		Optional<Bid> bid = bidService.getBidById(id);
		return Response.ok(bid).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addBid(CustomBid bid) {
		bidService.createBid(bid);
		return Response.ok("Successfully create your bid.").build();
	}
	
	//Toggle isApproved
	
	@PUT
	@Path("/accept-bid/{bidId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response acceptBid(@PathParam("bidId") Long id) {
		bidService.acceptBid(id);
		return Response.ok("Bid accepted successfully").build();
		
	}
	
	
	@PUT
	@Path("/accept-bid2/{adsId}/{bidId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response acceptBid2(@PathParam("adsId") Long adsId, @PathParam("bidId") Long bidId) {
		bidService.acceptBid2(adsId, bidId);
		return Response.ok().build();
	}
	
}
