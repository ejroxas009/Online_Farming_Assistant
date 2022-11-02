package org.group4.revalida.onlineFarmingAssistant.service.admin;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.admin.FarmingTips;
import org.group4.revalida.onlineFarmingAssistant.repo.admin.FarmingTipsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmingTipsService {
	public FarmingTipsService() {
		
	}
	
	@Autowired
	private FarmingTipsRepo farmingTipsRepo;
	
	public List<FarmingTips> getFarmingTips(){
		return farmingTipsRepo.findAll();
	}
	
	public Optional<FarmingTips> getFarmingTipsById(Long id){
		return farmingTipsRepo.findById(id);
	}
	
	public FarmingTips createFarmingTips (FarmingTips farmingtips) {
		return farmingTipsRepo.save(farmingtips);
	}
	
	public FarmingTips editFarmingTips(FarmingTips farmingtips, Long Id) {
		FarmingTips ftipsInDb = farmingTipsRepo.findById(Id).orElseThrow(NotFoundException::new);
		ftipsInDb.setFarmingTips(farmingtips.getFarmingTips());
		
		return farmingTipsRepo.save(ftipsInDb);
	}
}
