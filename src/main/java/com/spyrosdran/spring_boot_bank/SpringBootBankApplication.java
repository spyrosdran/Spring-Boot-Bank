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
			balances(bankService);
			System.out.println("Done!");
		};
	}

	private void balances(BankService bankService) {
		System.out.println("Balance of client with id of 1: " + bankService.getBalance(1));
		System.out.println("Balance of client with id of 2: " + bankService.getBalance(2));
	}

}
