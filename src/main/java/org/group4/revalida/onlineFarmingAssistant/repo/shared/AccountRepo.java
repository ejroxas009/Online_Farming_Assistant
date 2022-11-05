package org.group4.revalida.onlineFarmingAssistant.repo.shared;

import org.group4.revalida.onlineFarmingAssistant.model.shared.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long>{
Account findByUsername(String username);
}
