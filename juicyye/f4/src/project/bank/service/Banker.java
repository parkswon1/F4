package project.bank.service;


import project.bank.exception.AccountNotFoundException;

public class Banker {
    // 은행원 객체는 통장 개설 및 출금 승인 프로세스를 관리합니다.
    private String name;
    private NormalAccount normalAccount;
    private Bank bank;

    public Banker(String name) {
        this.name = name;
        bank = new Bank("테킷은행");
    }
    public void OpenBank(String AccountNumber,int money) {
       normalAccount =  bank.openAccount(name, money,AccountNumber);
    }

    public void print(String AccountNumber){
        if (accountExists(AccountNumber)) bank.printAccount(AccountNumber);
        else throw new AccountNotFoundException("요청한 통장이 존재하지 않습니다.");

    }

    public void depositService(String AccountNumber, int money){
        NormalAccount cuaccount = bank.getAccount(AccountNumber);
        if(cuaccount == null){
            throw new AccountNotFoundException("요청한 계좌번호 통장이 존재하지 않습니다.");
        }
        cuaccount.deposit(money);
        System.out.print(bank.getAccount(AccountNumber).getAccountNumber() +" 통장에 " + money+"원 입금되었습니다." );
        System.out.println("  ㅡ  잔액: " + cuaccount.getBalance()+"원");
    }

    public void withdrawService(String AccountNumber, int money){
        NormalAccount cuaccount = bank.getAccount(AccountNumber);
        if(cuaccount == null){
            throw new AccountNotFoundException("요청한 계좌번호 통장이 존재하지 않습니다.");
        }
        cuaccount.withdraw(money);
        System.out.print(bank.getAccount(AccountNumber).getAccountNumber() +" 통장에 " + money+"원 출금합니다.");
        System.out.println("  ㅡ  잔액: " + cuaccount.getBalance()+"원");

    }

    private boolean accountExists(String AccountNumber){
        if(bank.getAccount(AccountNumber)!= null)
            return true;
        return false;
    }

}
