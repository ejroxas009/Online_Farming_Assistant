package org.group4.revalida.onlineFarmingAssistant.resource.shared;

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

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.service.shared.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/account")
public class AccountResource {

	
private final AccountService accountService;

@Autowired
public AccountResource(AccountService accountService) {
	this.accountService = accountService;
}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAccount(){
		List<Account> accountList = accountService.getAllAccount();
		return Response.ok(accountList).build();
	}
	
	@GET
	@Path("/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAccountById(@PathParam("accountId") Long id) {
		Optional<Account> account = accountService.getAccountById(id);
		return Response.ok(account).build();
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addAccount(Account account) {
		accountService.createAccount(account);
		return Response.ok("Successfully created an account").build();
	}
	
	@PUT
	@Path("edit/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response editAccount(Account account, @PathParam("accountId") Long id) {
		accountService.editAccount(account, id);
		return Response.ok("Successfully edited an account").build();
	}
	

	@PUT
	@Path("/set-active/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response toggleActive( @PathParam("accountId") Long id) {
		accountService.toggleActive(id);
		return Response.ok("Successfully changed isActive").build();
	}
	
}
