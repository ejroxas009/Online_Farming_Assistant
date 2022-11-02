package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomAdvertisement;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AdvertisementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvertisementService {

	@Autowired
	AdvertisementRepo advertisementRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	public List<Advertisement> getAdvertisement() {
		
		return advertisementRepo.findAll();
	}
	
	public Optional<Advertisement> getAdvertisementById(Long id) {
		
		return advertisementRepo.findById(id);
	}
	
	public Advertisement createAdvertisement(CustomAdvertisement ads) {
		Account account = accountRepo.findById(ads.getAccountId()).orElseThrow(NotFoundException::new);
		Advertisement newAds = new Advertisement();
		newAds.setAccount(account);
		newAds.setAdsDescription(ads.getAdsDescription());
		newAds.setCropQuantity(ads.getCropQuantity());
		newAds.setInitialPrice(ads.getInitialPrice());
		newAds.setCropImg(ads.getCropImg());
		newAds.setPostDate(LocalDateTime.now());
		newAds.setActive(true);
		return advertisementRepo.save(newAds);
	}
	
	public Advertisement editAdvertisement(Advertisement advertisement, Long Id) {
		Advertisement adsInDb = advertisementRepo.findById(Id).orElseThrow(NotFoundException::new);
		
		adsInDb.setAdsDescription(advertisement.getAdsDescription());
		adsInDb.setCropQuantity(advertisement.getCropQuantity());
		adsInDb.setInitialPrice(advertisement.getInitialPrice());
		adsInDb.setPostDate(LocalDateTime.now());
		
		return advertisementRepo.save(adsInDb);
		
	}
	
	
}
