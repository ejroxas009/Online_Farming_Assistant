package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropPayment;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomChangePaymentMode;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomCropPayment;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CustomProofOfPayment;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.BidRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AdvertisementRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.CropPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CropPaymentService {

	@Autowired
	private CropPaymentRepo cropPaymentRepo;
	
	
	@Autowired 
	private AccountRepo accountRepo;
	@Autowired
	private AdvertisementRepo adsRepo;
	
	@Autowired
	private BidRepo bidRepo;
	
	public List<CropPayment> getCropPayment() {
		return cropPaymentRepo.findAll();
	}
	
	
	public Optional<CropPayment> getCropPaymentById(Long id) {
		
		return cropPaymentRepo.findById(id);
		}
	
	public CropPayment createCropPayment(CustomCropPayment customCropPayment) {
		Account account = accountRepo.findById(customCropPayment.getAccountId()).orElseThrow(NotFoundException::new);
		Advertisement ads = adsRepo.findById(customCropPayment.getAdvertisementId()).orElseThrow(NotFoundException::new);
		Bid bid = bidRepo.findById(customCropPayment.getBidId()).orElseThrow(NotFoundException::new);
		CropPayment cropPayment = new CropPayment();
		cropPayment.setAccount(account);
		cropPayment.setBid(bid);
		cropPayment.setAdvertisement(ads);
		cropPayment.setPaymentDate(null);
		cropPayment.setPaymentMode(customCropPayment.getPaymentMode());
		cropPayment.setOrderIdRef(customCropPayment.getOrderIdRef());
		cropPayment.setPaid(false);
		cropPayment.setOrderIdRef(customCropPayment.getOrderIdRef());
		return cropPaymentRepo.save(cropPayment);
	}
	
	public CropPayment receivePayment(Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		
		cropInDb.setPaid(true);
		
		return cropPaymentRepo.save(cropInDb);
	}
	
	public CropPayment changePaymentMode(CustomChangePaymentMode changePaymentMode, Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setPaymentMode(changePaymentMode.getChangePaymentMethod());
		
		return cropPaymentRepo.save(cropInDb);
	}
	
	public CropPayment markAsPaid(Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setPaymentDate(LocalDateTime.now());
		cropInDb.setMarkAsPaid(true);
		
		return cropPaymentRepo.save(cropInDb);
	}
	
	public CropPayment markAsCOD(Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		
		cropInDb.setMarkAsCOD(true);;
		
		return cropPaymentRepo.save(cropInDb);
	}
	
	
	
	public CropPayment sendProofOfPayment(CustomProofOfPayment proof, Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setProofOfPayment(proof.getProofOfPayment());
		return cropPaymentRepo.save(cropInDb);
	}
	

	}
