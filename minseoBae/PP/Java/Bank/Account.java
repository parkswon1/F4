package com.example.day10.실습;

public class Account {
    private final String owner;
    private final int ano;
    private int balance;
    private int password;

    public String getOwner() {
        return owner;
    }

    public int getAno() {
        return ano;
    }

    public int getBalance() {
        return balance;
    }

    public int getPassword() {  return password; }

    public Account(String owner, int ano, int balance, int password) {
        this.owner = owner;
        this.ano = ano;
        this.balance = balance;
        this.password = password;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) throws NotEnoughMoneyException {
        if (this.balance<amount) {
            throw new NotEnoughMoneyException("잔액이 모자랍니다. 남은 잔액 : " + this.balance);
        } else
            this.balance-=amount;
    }
}
