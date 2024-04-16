package project.bank.service.refac.acount;


import project.bank.exception.WrongNumber;

public class MinusAccount implements Account {
    // 통장 객체는 입금과 출금 기능을 가지며, 출금 시 잔액 부족 예외를 발생시킬 수 있어야 합니다.
    private long balance;
    private String name;
    private String accountNumber;

    @Override
    public Account createAccount(long money, String name, String accountNumber) {
        MinusAccount account = new MinusAccount();
        account.setBalance(money);
        account.setName(name);
        account.setAccountNumber(accountNumber);
        return account;
    }

    @Override
    public void deposit(long amount) {
        if(amount < 0) throw new WrongNumber("양수를 입력해주세요");
        balance += amount;
    }

    @Override
    public void withdraw(long amount) {
        balance -= amount;
        if (balance < -30000000) {
            throw new WrongNumber("한도가 넘었습니다.");
        }

    }


    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    private void setBalance(long balance) {
        this.balance = balance;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public String getName() {
        return name;
    }
}
