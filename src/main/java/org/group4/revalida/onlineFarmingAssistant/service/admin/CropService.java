package org.group4.revalida.onlineFarmingAssistant.service.admin;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.admin.Crop;
import org.group4.revalida.onlineFarmingAssistant.repo.admin.CropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropService {
	public CropService() {
		
	}
	@Autowired
	private CropRepo cropRepo;
	
	public List<Crop> getCrop(){
		return cropRepo.findAll();
	}
	
	public Optional<Crop> getCropById(Long id){
		return cropRepo.findById(id);
	}
	
	public Crop createCrop (Crop crop) {
		return cropRepo.save(crop);
	}
	
	public Crop editCrop(Crop crop,Long Id) {
		Crop cropsInDb = cropRepo.findById(Id).orElseThrow(NotFoundException::new);
		cropsInDb.setCropName(crop.getCropName());
		
		return cropRepo.save(cropsInDb);
	}
}
