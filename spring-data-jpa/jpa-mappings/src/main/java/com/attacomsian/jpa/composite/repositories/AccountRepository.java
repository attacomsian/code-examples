package com.attacomsian.jpa.composite.repositories;

import com.attacomsian.jpa.composite.domains.Account;
import com.attacomsian.jpa.composite.domains.AccountId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, AccountId> {

    List<Account> findByAccountType(String accountType);
}
