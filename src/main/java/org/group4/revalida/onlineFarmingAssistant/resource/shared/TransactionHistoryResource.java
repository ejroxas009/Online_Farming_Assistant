package org.group4.revalida.onlineFarmingAssistant.resource.shared;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.service.shared.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/mytransaction")

public class TransactionHistoryResource {
	
	TransactionHistoryService myTransService;
	@Autowired
	public TransactionHistoryResource(TransactionHistoryService myTransService) {
		this.myTransService = myTransService;
	}
	
	
	@GET
	@Path("/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getMyTransaction(@PathParam("accountId") Long id){
		//List<MyTransaction> transactionList = accountService.getAllAccount();
		List<Advertisement> myAds = myTransService.getMyTransactionHistory(id);
		return Response.ok(myAds).build();
	}

}
