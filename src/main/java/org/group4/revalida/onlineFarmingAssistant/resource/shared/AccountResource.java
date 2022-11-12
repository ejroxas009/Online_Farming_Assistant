package org.group4.revalida.onlineFarmingAssistant.resource.shared;

import java.util.List;
import java.util.Map;
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
import org.group4.revalida.onlineFarmingAssistant.model.shared.ChangePassword;
import org.group4.revalida.onlineFarmingAssistant.model.shared.LoginCredentials;
import org.group4.revalida.onlineFarmingAssistant.model.shared.ProfileImage;
import org.group4.revalida.onlineFarmingAssistant.service.shared.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

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
		return Response.ok(accountList)
						.header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
						.allow("OPTIONS")
						.build();
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
		return Response
				.ok("Successfully created an account")
				.entity(account)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	@POST
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response login(LoginCredentials credentials) {
		 Map<String, String> tokens = accountService.login(credentials);
		if(tokens.get("access_token") != "") {
			return Response.ok(tokens).build();
		}
		
		return Response.status(403, "Incorrect username or password").build();
		
	}
	
	@PUT
	@Path("/edit/{accountId}")
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
	
	@PUT
	@Path("/change-profileImg/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response changeProfileImage(@PathParam("accountId") Long id , ProfileImage image) {
		accountService.changeProfileImage(id, image);
		return Response.ok().build();
	}
		
	@PUT
	@Path("/change-password/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response changePassword(@PathParam("accountId") Long id , ChangePassword password) {
		String result = accountService.changePassword(id, password);
		if(result == "success") {
			return Response.ok("Password is successfully changed").build();
		}
		return Response.status(403, "Incorrect old password").build();
		
	}
	
}
