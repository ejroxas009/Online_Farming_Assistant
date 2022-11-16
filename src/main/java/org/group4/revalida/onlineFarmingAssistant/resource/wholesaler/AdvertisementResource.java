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

import org.group4.revalida.onlineFarmingAssistant.model.twilio.SmsRequest;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomAdvertisement;
import org.group4.revalida.onlineFarmingAssistant.service.twilio.TwilioSmsSender;
import org.group4.revalida.onlineFarmingAssistant.service.wholesaler.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/ads")
public class AdvertisementResource {

	private final AdvertisementService adsService;
	private final TwilioSmsSender twilioSmsSender;
	
	@Autowired
	public AdvertisementResource(AdvertisementService adsService, TwilioSmsSender twilioSmsSender) {
		super();
		this.adsService = adsService;
		this.twilioSmsSender = twilioSmsSender;
	}

//	@Autowired
//	public AdvertisementResource(AdvertisementService adsService) {
//		this.adsService = adsService;
//	}
//	
//	
//	
//	
//	public AdvertisementResource() {
//		super();
//	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAds() {
		List<Advertisement> adsList = adsService.getAdvertisement();
		return Response.ok(adsList).build();
	}
	
	@GET
	@Path("/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAdsById(@PathParam("postId") Long id) {
		Optional<Advertisement> ads = adsService.getAdvertisementById(id);
		return Response.ok(ads).build();
	}
	
//	@POST
//	@Produces({MediaType.APPLICATION_JSON})
//	@Consumes({MediaType.APPLICATION_JSON})
//	public Response addAds(Advertisement ads) {
//		
//		Advertisement advertisement = adsService.createAdvertisement(ads);
//		return Response.ok("Successfully added an ads").build();
//	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addAds(CustomAdvertisement customAds) {
		
		Advertisement advertisement = adsService.createAdvertisement(customAds);
		return Response.ok("Successfully added an ads").build();
	}
	//-----Edit ---------
	@PUT
	@Path("/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response editAds(Advertisement ads, @PathParam("postId") Long id) {
		adsService.editAdvertisement(ads, id);
		return Response.ok("Sucessfully edited an ads").build();
	}
	
	@PUT
	@Path("/set-active/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response toggleActive(@PathParam("postId") Long id) {
		adsService.toggleActive(id);
		return Response.ok("Successfully toggled active").build();
	}
	
	@POST
	@Path("/twilio")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response sendSms(String phoneNumber) {
		twilioSmsSender.sendSms(phoneNumber);
		return Response.ok("successfully sent a message").build();
	}
	
	
}
