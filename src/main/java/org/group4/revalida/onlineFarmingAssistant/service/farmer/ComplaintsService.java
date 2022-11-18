package org.group4.revalida.onlineFarmingAssistant.service.farmer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Complaints;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CustomComplaints;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.ComplaintsRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintsService {
	
	@Autowired
	ComplaintsRepo complaintsRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	public List<Complaints> getComplaints(){
		return complaintsRepo.findAll();
	}
	
	public Optional<Complaints> getComplaintsById(Long id){
		return complaintsRepo.findById(id);
	}
	
	public Complaints postComplaints(CustomComplaints complaints) {
		Account account = accountRepo.findById(complaints.getAccountId()).orElseThrow(NotFoundException::new);
		Complaints complt = new Complaints();
		complt.setAccount(account);
		complt.setComplaintPost(complaints.getComplaintPost());
		complt.setComplaintImg(complaints.getComplaintImg());
		complt.setRead(false);
		complt.setResolved(false);
		return complaintsRepo.save(complt);
	}
	
	//To toggle isRead
	public Complaints complaintStatus(Long id) {
		Complaints isRead = complaintsRepo.findById(id).orElseThrow(NotFoundException::new);
		isRead.setRead(true);
		return complaintsRepo.save(isRead);
	}
}
