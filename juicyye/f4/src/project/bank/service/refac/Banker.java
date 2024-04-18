package project.bank.service.refac;


import project.bank.exception.AccountNotFoundException;
import project.bank.service.refac.acount.Account;

public class Banker {
    // 은행원 객체는 통장 개설 및 출금 승인 프로세스를 관리합니다.

    private String name;
    private Account account;
    private Bank bank;

    public Banker(String name,Account account) {
        this.name = name;
        bank = new Bank("테킷은행", account);
    }

    public void OpenBank(String name, int money,String AccountNumber) {
        account = bank.openAccount(name, money, AccountNumber);
    }

    public void print(String AccountNumber){
        if (accountExists(AccountNumber)) bank.printAccount(AccountNumber);
        else throw new AccountNotFoundException("요청한 통장이 존재하지 않습니다.");


    }

    public void depositService(String AccountNumber, int money){
        Account curAccount = bank.getAccount(AccountNumber);
        if(curAccount == null){
            throw new AccountNotFoundException("요청한 계좌번호 통장이 존재하지 않습니다.");
        }
        curAccount.deposit(money);
        System.out.println(AccountNumber+" 계좌에 " + money +"원 입금했습니다  |  잔액: "+curAccount.getBalance());

    }

    public void withdrawService(String AccountNumber, int money){
        Account curAccount = bank.getAccount(AccountNumber);
        if(curAccount == null){
            throw new AccountNotFoundException("요청한 계좌번호 통장이 존재하지 않습니다.");
        }
        curAccount.withdraw(money);
        System.out.println(AccountNumber+" 계좌번호에 " + money +"원 출금합니다  |  잔액: "+curAccount.getBalance());
    }

    private boolean accountExists(String AccountNumber){
        if(bank.getAccount(AccountNumber)!= null)
            return true;
        return false;
    }

}
