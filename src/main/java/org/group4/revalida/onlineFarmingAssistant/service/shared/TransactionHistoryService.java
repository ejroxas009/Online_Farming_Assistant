package org.group4.revalida.onlineFarmingAssistant.service.shared;

import java.util.List;
import java.util.stream.Collectors;

import org.group4.revalida.onlineFarmingAssistant.model.farmer.Bid;
import org.group4.revalida.onlineFarmingAssistant.model.shared.TransactionHistory;
import org.group4.revalida.onlineFarmingAssistant.model.wholesaler.Advertisement;
import org.group4.revalida.onlineFarmingAssistant.repo.farmer.BidRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AdvertisementRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.CropPaymentRepo;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.CropReceivedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {
	
	@Autowired
	private AdvertisementRepo adsRepo;
	
	@Autowired
	private BidRepo bidRepo;
	
	@Autowired
	private CropPaymentRepo paymentRepo;
	
	@Autowired
	private CropReceivedRepo receiveRepo;
	
	public List<Advertisement> getMyTransactionHistory(Long id){
		List<Advertisement> adsList = adsRepo.findAll();
		List<Advertisement> myAds = adsList.stream()
				.filter(ads->ads.getAccount().getAccountId().equals(id))
				.collect(Collectors.toList());
		
//		for(Advertisement ads : myAds) {
//			List<Bid> bidList =bidRepo.findAll();
//			Bid bid = bidList.stream()
//					.filter(bid -> bid.get)
//		}
		return myAds;
	}
	
}
