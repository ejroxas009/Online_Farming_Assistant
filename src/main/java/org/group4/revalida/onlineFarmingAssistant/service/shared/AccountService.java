package org.group4.revalida.onlineFarmingAssistant.service.shared;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.repo.wholesaler.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	public AccountService() {
		
	}

	@Autowired
	 private AccountRepo accountRepo;
	
	public List<Account> getAllAccount(){
		return accountRepo.findAll();
	}
	
	public Optional<Account> getAccountById(Long Id) {
		return accountRepo.findById(Id);
	}
	
	public Account createAccount(Account account) {
		return accountRepo.save(account);
	}
	
	public Account editAccount(Account account, Long Id) {
		
		Account accountInDb = accountRepo.findById(Id).orElseThrow(NotFoundException::new);
		accountInDb.setFirstName(account.getFirstName());
		accountInDb.setMiddleName(account.getMiddleName());
		accountInDb.setLastName(account.getLastName());
		accountInDb.setGender(account.getGender());
		accountInDb.setAddressLine1(account.getAddressLine1());
		accountInDb.setAddressLine2(account.getAddressLine2());
		accountInDb.setCity(account.getCity());
		accountInDb.setProvince(account.getZipCode());
		accountInDb.setPhoneNumber(account.getPhoneNumber());
		accountInDb.setProfileImg(account.getProfileImg());
		
		return accountRepo.save(accountInDb);
	}
}
