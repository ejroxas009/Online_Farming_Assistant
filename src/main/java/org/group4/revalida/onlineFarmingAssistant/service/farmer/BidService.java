package org.group4.revalida.onlineFarmingAssistant.service.farmer;

import java.util.List;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {
	
	@Autowired
	BidRepo bidRepo;
	
	public List<Bid> getBid(){
		return bidRepo.findAll(); 
	}
	
	
}
