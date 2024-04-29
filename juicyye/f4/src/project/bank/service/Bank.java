package project.bank.service;



import project.bank.exception.BlankWrongAnswer;
import project.bank.exception.DuplicateAccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    //은행 객체는 통장 객체를 리스트로 관리하며, 통장 개설 및 통장 정보 조회 기능을 제공해야 합니다.
    private String bankName;
    private Map<String, NormalAccount> bankBook = new HashMap<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }



    protected void printAccount(String accountNumber){
        System.out.println();
        System.out.println("=========================================");
        System.out.println(accountNumber+" 통장내역을 출력합니다.");
        NormalAccount normalAccount = bankBook.get(accountNumber);
        System.out.println("이름: " + normalAccount.getName() + " | 계좌번호: " + normalAccount.getAccountNumber() + " | 잔액: "+ normalAccount.getBalance()+"원");
        System.out.println("=========================================");

    }

    protected NormalAccount openAccount(String name, int money, String accountNumber) {
        if(accountNumber==null) throw new BlankWrongAnswer("계좌번호를 입력해주세요");
        if(DuplicateValid(accountNumber)){
            System.out.println(name + "님 통장이 개설되었습니다.  ㅡ  잔액: " + money+"원");
            NormalAccount normalAccount = new NormalAccount(money, name, accountNumber);
            bankBook.put(accountNumber, normalAccount);
            return normalAccount;
        }else{
            throw new DuplicateAccount("이미 존재하는 계좌번호입니다.");
        }


    }

    private boolean DuplicateValid(String accountNumber) {
        if(bankBook.containsKey(accountNumber)){
            return false;
        } else{
            return true;
        }
    }


    public NormalAccount getAccount(String createId) {
        return bankBook.get(createId);
    }
    /*

    private String createId(String accountNumber) {
        String tempId = UUID.randomUUID().toString();
        id.put(tempId, accountNumber);
        return tempId;
    }

    private String findId(String tempId){
        return id.get(tempId);
    }*/
}
