package org.group4.revalida.onlineFarmingAssistant.service.wholesaler;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.CropReceived;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.CropReceivedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropReceivedService {

	@Autowired
	private CropReceivedRepo cropReceivedRepo;
	
	public List<CropReceived> getCropReceived(){
		return cropReceivedRepo.findAll();
	}
	
	public Optional<CropReceived> getCropReceivedById(Long id) {
		return cropReceivedRepo.findById(id);
	}
	
	public CropReceived createCropReceived(CropReceived cropReceived) {
		return cropReceivedRepo.save(cropReceived);
	}
	
	
	//To toggle isReceived
	public CropReceived receiveCrop( Long id) {
		CropReceived cropInDb = cropReceivedRepo.findById(id).orElseThrow(NotFoundException::new);
		
		cropInDb.setReceived(true);
		return cropReceivedRepo.save(cropInDb);
	}
	
}
