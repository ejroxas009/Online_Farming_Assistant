package org.group4.revalida.onlineFarmingAssistant.service.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;


import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{
	
	
	@Autowired
	 private AccountRepo accountRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
//	public AccountService(AccountRepo accountRepo, PasswordEncoder passwordEncoder) {
//		this.accountRepo = accountRepo;
//		this.passwordEncoder = passwordEncoder;
//		
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = accountRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found in the database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
	
	
	//-----------------Methods ------------------------
	public List<Account> getAllAccount(){
		return accountRepo.findAll();
	}
	
	public Optional<Account> getAccountById(Long Id) {
		return accountRepo.findById(Id);
	}
	
	public Account createAccount(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
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
		accountInDb.setCountry(account.getCountry());
		accountInDb.setPhoneNumber(account.getPhoneNumber());
		accountInDb.setProfileImg(account.getProfileImg());
		
		return accountRepo.save(accountInDb);
	}
	
	public Account toggleActive(Long id) {
		Account accountInDb = accountRepo.findById(id).orElseThrow(NotFoundException :: new);
		accountInDb.setActive(!accountInDb.isActive());
		return accountRepo.save(accountInDb);
	}

	
	
}
