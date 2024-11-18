package com.spyrosdran.spring_boot_bank;

import com.spyrosdran.spring_boot_bank.dao.ClientDao;
import com.spyrosdran.spring_boot_bank.entity.Client;
import com.spyrosdran.spring_boot_bank.service.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BankService bankService) {
		return runner -> {
			//balances(bankService);
			//transaction(bankService);
			//deposit(bankService);
			withdraw(bankService);
			System.out.println("Done!");
		};
	}

	private void withdraw(BankService bankService) {
		int id = 2;
		int amount = 100;

		System.out.println("Attempting to withdraw " + amount + " from client with id of " + id);
		bankService.withdraw(amount, id);
		System.out.println("Withdraw successful!");
	}

	private void deposit(BankService bankService) {
		int id = 1;
		int amount = 100;

		System.out.println("Attempting to deposit " + amount + " from client with id of " + id);
		bankService.deposit(amount, id);
		System.out.println("Deposit successful!");
	}

	private void balances(BankService bankService) {
		System.out.println("Balance of client with id of 1: " + bankService.getBalance(1));
		System.out.println("Balance of client with id of 2: " + bankService.getBalance(2));
	}

	private void transaction(BankService bankService) {
		Client payer = bankService.findClientById(1);
		Client receiver = bankService.findClientById(2);

		System.out.println("Attempting to transfer 100 money for Client 1 to Client 2...");

		bankService.transferMoney(100, 1 , 2);

		System.out.println("Transaction successful!");
	}

}
