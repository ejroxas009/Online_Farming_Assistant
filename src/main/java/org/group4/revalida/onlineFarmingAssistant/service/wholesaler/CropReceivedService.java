package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropPayment;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropReceived;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomCropReceived;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.BidRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AdvertisementRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.CropReceivedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropReceivedService {

	@Autowired
	private CropReceivedRepo cropReceivedRepo;
	
	@Autowired
	private AdvertisementRepo adsRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	public List<CropReceived> getCropReceived(){
		return cropReceivedRepo.findAll();
	}
	
	public Optional<CropReceived> getCropReceivedById(Long id) {
		return cropReceivedRepo.findById(id);
	}
	
	public CropReceived createCropReceived(CustomCropReceived customCropReceived) {
		
		
		Advertisement ads = adsRepo.findById(customCropReceived.getAdvertisementId()).orElseThrow(NotFoundException ::new);
		Account account = accountRepo.findById(customCropReceived.getAccountId()).orElseThrow(NotFoundException ::new);
		CropReceived cropReceived = new CropReceived();
		cropReceived.setAccount(account);
		cropReceived.setAdvertisement(ads);
		cropReceived.setReceivedTime(null);
		cropReceived.setReceived(false);
		return cropReceivedRepo.save(cropReceived);
	}
	
	
	//To toggle isReceived
	public CropReceived receiveCrop( Long id) {
		CropReceived cropInDb = cropReceivedRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setReceivedTime(LocalDateTime.now());
		cropInDb.setReceived(true);
		return cropReceivedRepo.save(cropInDb);
	}
	
	public CropReceived sendProofOfPayment(CustomProofOfPayment proof, Long id) {
		CropReceived cropInDb = cropReceivedRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setProofOfPayment(proof.getProofOfPayment());
		return cropReceivedRepo.save(cropInDb);
	}
	
}
