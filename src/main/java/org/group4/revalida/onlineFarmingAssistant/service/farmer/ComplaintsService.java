package org.group4.revalida.onlineFarmingAssistant.service.farmer;

import java.util.List;
import java.util.Optional;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Complaints;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.ComplaintsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintsService {
	
	@Autowired
	ComplaintsRepo complaintsRepo;
	
	public List<Complaints> getComplaints(){
		return complaintsRepo.findAll();
	}
	
	public Optional<Complaints> getComplaintsById(Long Id){
		return complaintsRepo.findById(Id);
	}
	
	public Complaints postComplaints(Complaints complaints) {
		return complaintsRepo.save(complaints);
	}
}
