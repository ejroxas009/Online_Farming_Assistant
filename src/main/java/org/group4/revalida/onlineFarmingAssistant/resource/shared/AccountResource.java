package org.group4.revalida.onlineFarmingAssistant.resource.shared;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountResource {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<String> getAccount(){
		List<String> accounts = new ArrayList<>();
		accounts.add("EJ Roxas");
		accounts.add("Emman");
		return accounts;
	}
}
