package com.Example.BankManagement.Repository;

import com.Example.BankManagement.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Account getAccountDetailsBycustomerid(int customerid);
}
