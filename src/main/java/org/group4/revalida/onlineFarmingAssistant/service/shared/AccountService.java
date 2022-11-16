package org.group4.revalida.onlineFarmingAssistant.service.shared;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;


import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.group4.revalida.onlineFarmingAssistant.model.shared.ChangePassword;
import org.group4.revalida.onlineFarmingAssistant.model.shared.LoginCredentials;
import org.group4.revalida.onlineFarmingAssistant.model.shared.ProfileImage;
import org.group4.revalida.onlineFarmingAssistant.repo.shared.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

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
		account.setActive(false);
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

	
	public Map<String, String> login(LoginCredentials credentials) {
		Account currentAccount = accountRepo.findByUsername(credentials.getUsername());
		Map<String, String> tokens = new HashMap<>();
		if(currentAccount != null && passwordEncoder.matches(credentials.getPassword(), currentAccount.getPassword())) {
			Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
			String access_token = JWT.create()
					//.withSubject(currentAccount.getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis()+ 10*60*1000))
					.withClaim("id", currentAccount.getAccountId())
					.withClaim("username", currentAccount.getUsername())
					.withClaim("role", currentAccount.getRole())
					.sign(algorithm);
			
			tokens.put("access_token", access_token);
			return tokens;
		}
		tokens.put("access_token", "");
		return tokens;
	}
	
	public Account changeProfileImage(Long id, ProfileImage image) {
		Account accountInDb = accountRepo.findById(id).orElseThrow(NotFoundException::new);
		accountInDb.setProfileImg(image.getProfileImage());
		return accountRepo.save(accountInDb);
	}
	
	
	public String changePassword(Long id, ChangePassword password) {
		Account accountInDb = accountRepo.findById(id).orElseThrow(NotFoundException:: new);
		if(passwordEncoder.matches(password.getOldPassword(), accountInDb.getPassword())) {
			accountInDb.setPassword(passwordEncoder.encode(password.getNewPassword()));
			accountRepo.save(accountInDb);
			
			return "success";
		}
		
		return "failed";
	}
	
	public List<Account> getAllFarmers() {
		List<Account> allAccount = accountRepo.findAll();
		List<Account> getAllFarmers = allAccount.stream().filter(user-> user.getRole().equals("farmer")).collect(Collectors.toList());
		return getAllFarmers;
		
	}
}
