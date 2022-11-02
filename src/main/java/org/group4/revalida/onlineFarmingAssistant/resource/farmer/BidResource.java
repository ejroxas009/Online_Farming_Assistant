package org.group4.revalida.onlineFarmingAssistant.resource.farmer;

import javax.ws.rs.Path;

import org.group4.revalida.onlineFarmingAssistant.service.farmer.BidService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/bid")
public class BidResource {

	private final BidService bidService;
	
	@Autowired
	public BidResource(BidService bidService) {
		this.bidService = bidService;
	}
	
	
}
