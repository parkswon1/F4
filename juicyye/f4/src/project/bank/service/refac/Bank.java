package project.bank.service.refac;



import project.bank.exception.BlankWrongAnswer;
import project.bank.exception.DuplicateAccount;
import project.bank.service.refac.acount.Account;
import project.bank.service.refac.acount.MinusAccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    //은행 객체는 통장 객체를 리스트로 관리하며, 통장 개설 및 통장 정보 조회 기능을 제공해야 합니다.
    private Account account;
    private String bankName;
    private Map<String, Account> bankBook = new HashMap<>();

    public Bank(String bankName,Account account) {
        this.bankName = bankName;
        this.account = account;
    }



    protected Account openAccount(String name, int money, String accountNumber) {
        if(DuplicateValid(accountNumber)){
            this.account = account.createAccount(money, name, accountNumber);
            if(account instanceof MinusAccount){
                System.out.println(name + "님 마이너스 통장이 개설되었습니다.  ㅡ  잔액: " + money+"원");
            } else{
                System.out.println(name + "님 일반 통장이 개설되었습니다.  ㅡ  잔액: " + money+"원");
            }
            bankBook.put(accountNumber, account);
            return account;
        }else{
            throw new DuplicateAccount("이미 존재하는 계좌번호입니다.");
        }


    }
    protected void printAccount(String AccountNumber){
        Account account = bankBook.get(AccountNumber);
        System.out.println();
        System.out.println("=========================================");
        System.out.println(AccountNumber+" 통장내역을 출력합니다.");
        System.out.println("이름: " + account.getName() + "  |  계좌번호: "+ account.getAccountNumber() + "  |  잔고: "+account.getBalance());
        System.out.println("=========================================");
    }

    private boolean DuplicateValid(String accountNumber) {
        if(accountNumber==null) throw new BlankWrongAnswer("계좌번호를 입력해주세요");
        if(bankBook.containsKey(accountNumber)){
            return false;
        } else{
            return true;
        }
    }


    public Account getAccount(String accountNumber) {
        return bankBook.get(accountNumber);
    }
}
