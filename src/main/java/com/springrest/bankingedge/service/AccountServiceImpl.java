package com.springrest.bankingedge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.bankingedge.entity.Account;
import com.springrest.bankingedge.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Account account_saved = repo.save(account);

		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		Optional<Account> account = repo.findById(accountNumber);
		if (account.isPresent()) {
			// throw new RuntimeException("Account does not exist");
			// }
			// Account account_found = account.get();
			return account.get();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		// TODO Auto-generated method stub
		List<Account> listOfAccounts = repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		Optional<Account> account = repo.findById(accountNumber);
		// if(account.isEmpty()) {
		// throw new RuntimeException("Account is not Present");
		// }
		if (account.isPresent()) {
			Account accountPresent = account.get();
			Double totalBalance = accountPresent.getAccount_balance() + amount;
			accountPresent.setAccount_balance(totalBalance);
			repo.save(accountPresent);
			return accountPresent;
		}
		return null;

	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		Optional<Account> account = repo.findById(accountNumber);
		// if(account.isEmpty()) {
		// throw new RuntimeException("Account is not Present");
		// }
		if (account.isPresent()) {
			Account accountPresent = account.get();
			Double accountBalance = accountPresent.getAccount_balance() - amount;
			accountPresent.setAccount_balance(accountBalance);
			repo.save(accountPresent);
			return accountPresent;
		}
		return null;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
	}

}
