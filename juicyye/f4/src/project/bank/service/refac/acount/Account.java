package project.bank.service.refac.acount;

public interface Account {
    Account createAccount(long money, String name, String accountNumber);
    void deposit(long amount);

    void withdraw(long amount);

    String getName();
    long getBalance();
    String getAccountNumber();

}
