package org.group4.revalida.onlineFarmingAssistant.service.farmer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.farmer.CustomBid;
import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.BidRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AdvertisementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {
	
	@Autowired
	private BidRepo bidRepo;
	
	@Autowired 
	private AccountRepo accountRepo;
	
	public List<Bid> getBid(){
		return bidRepo.findAll(); 
	}
	
	public Optional<Bid> getBidById(Long id){
		return bidRepo.findById(id);
	}
	
	public Bid createBid(CustomBid bid) {
		Account account = accountRepo.findById(bid.getAccountId()).orElseThrow(NotFoundException::new);
		Bid addBid = new Bid();
		addBid.setAccount(account);
		addBid.setBidPrice(bid.getBidPrice());
		addBid.setBidMsg(bid.getBidMsg());
		addBid.setBidDate(LocalDateTime.now());
		return bidRepo.save(addBid);
	}
	
	//Toggle isApproved
	
}
