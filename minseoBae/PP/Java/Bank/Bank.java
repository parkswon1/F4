package com.example.day10.실습;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    private String BankName;
    private final List<Account> accounts = new ArrayList<>();
    private int srt = 0;

    public void createAccount(String owner, int balance, int password) {
        accounts.add(new Account(owner, ++srt, balance, password));
    }

    public Account findAccount(int ano) throws NotAccountException{
        try {
            for(Account account : accounts) {
                if (account.getAno() == ano) {
                    return account;
                }
            }
            throw new NotAccountException("일치하는 계좌가 없습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Account> findAccount(String owner) throws NotAccountException {
        try {
            List<Account> ownAccounts = new ArrayList<>();
            for (Account account : accounts) {
                if (account.getOwner().equals(owner)) {
                    ownAccounts.add(account);
                }
            }
            if(ownAccounts.isEmpty()) {
                throw new NotAccountException("일치하는 계좌가 없습니다.\n 메뉴로 돌아갑니다.");
            } // 예외 발생
            else { return ownAccounts; }
        } catch (NotAccountException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    public void deleteAccount(int ano) {
        accounts.removeIf(account -> account.getAno() == ano);
    }

    public void deposit(int ano, int amount) throws NotAccountException {
        try {
            Account account = findAccount(ano);
            if (account == null) {
                throw new NotAccountException("일치하는 계좌가 없습니다.");
            }
            account.deposit(amount);
        } catch (NotAccountException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(int ano, int amount) throws NotAccountException, NotEnoughMoneyException, WrongPasswordException {
        try {
            Account account = findAccount(ano);
            if (account == null) {
                throw new NotAccountException("일치하는 계좌가 없습니다.");
            }
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
