package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropPayment;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.CropPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CropPaymentService {

	@Autowired
	private CropPaymentRepo cropPaymentRepo;
	
	public List<CropPayment> getCropPayment() {
		return  cropPaymentRepo.findAll();
	}
	
	public Optional<CropPayment> getCropPaymentById(Long id) {
		
		return cropPaymentRepo.findById(id);
		}
	
	public CropPayment createCropPayment(CropPayment cropPayment) {
		return cropPaymentRepo.save(cropPayment);
	}
	
	public CropPayment receivePayment(Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setPaid(true);
		
		return cropPaymentRepo.save(cropInDb);
	}
	
	public CropPayment changePaymentMode(CropPayment cropPayment, Long id) {
		CropPayment cropInDb = cropPaymentRepo.findById(id).orElseThrow(NotFoundException::new);
		cropInDb.setPaymentMode(cropPayment.getPaymentMode());
		
		return cropPaymentRepo.save(cropInDb);
	}
	
	}
