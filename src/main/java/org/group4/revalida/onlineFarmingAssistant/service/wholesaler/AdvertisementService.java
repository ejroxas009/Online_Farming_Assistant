package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Crop;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomAdvertisement;
import org.group4.revalida.onlineFarmingAssistant.repo.admin.CropRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.BidRepo;
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
	
	@Autowired
	CropRepo cropRepo;
	
	
	
	public List<Advertisement> getAdvertisement() {
		
		return advertisementRepo.findAll();
	}
	
	public Optional<Advertisement> getAdvertisementById(Long id) {
		
		return advertisementRepo.findById(id);
	}
	
	public Advertisement createAdvertisement(CustomAdvertisement ads) {
		Account account = accountRepo.findById(ads.getAccountId()).orElseThrow(NotFoundException::new);
		Advertisement newAds = new Advertisement();
		Crop newCrop = cropRepo.findById(ads.getCropId()).orElseThrow(NotFoundException::new);
		newAds.setAccount(account);
		newAds.setAdsDescription(ads.getAdsDescription());
		newAds.setCropQuantity(ads.getCropQuantity());
		newAds.setInitialPrice(ads.getInitialPrice());
		newAds.setCrop(newCrop);
		newAds.setCropImg(ads.getCropImg());
		//newAds.setPostDate(LocalDateTime.now());
		newAds.setPostDate(LocalDateTime.now());
		newAds.setActive(true);
		return advertisementRepo.save(newAds);
	}
	
	public Advertisement editAdvertisement(Advertisement advertisement, Long Id) {
		Advertisement adsInDb = advertisementRepo.findById(Id).orElseThrow(NotFoundException::new);
		adsInDb.setAdsDescription(advertisement.getAdsDescription());
		adsInDb.setCropQuantity(advertisement.getCropQuantity());
		adsInDb.setInitialPrice(advertisement.getInitialPrice());
		adsInDb.setCropImg(advertisement.getCropImg());
		adsInDb.setPostDate(LocalDateTime.now());
		
		return advertisementRepo.save(adsInDb);
		
	}
	
	public Advertisement toggleActive(Long id) {
		Advertisement adsInDb = advertisementRepo.findById(id).orElseThrow(NotFoundException::new);
		adsInDb.setActive(!adsInDb.isActive());
		return advertisementRepo.save(adsInDb);
	}
	
	
}
