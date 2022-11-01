package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AdvertisementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvertisementService {

	@Autowired
	AdvertisementRepo advertisementRepo;
	
	public List<Advertisement> getAdvertisement() {
		
		return advertisementRepo.findAll();
	}
	
	public Optional<Advertisement> getAdvertisementById(Long id) {
		
		return advertisementRepo.findById(id);
	}
	
	public Advertisement createAdvertisement(Advertisement advertisement) {
		return advertisementRepo.save(advertisement);
	}
	
	public Advertisement editAdvertisement(Advertisement advertisement, Long Id) {
		Advertisement adsInDb = advertisementRepo.findById(Id).orElseThrow(NotFoundException::new);
		
		adsInDb.setAdsDescription(advertisement.getAdsDescription());
		adsInDb.setCropQuantity(advertisement.getCropQuantity());
		adsInDb.setInitialPrice(advertisement.getInitialPrice());
		adsInDb.setPostDate(LocalDate.now());
		
		return advertisementRepo.save(adsInDb);
		
	}
	
	
}
