package com.example.day10.실습;

import java.util.List;
import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) throws NotAccountException, NotEnoughMoneyException, WrongPasswordException {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while(true) {
            System.out.println("메뉴를 선택하세요(1. 통장 개설, 2. 통장 조회, 3. 입금, 4. 출금, 0. 종료");
            Account account;
            String a = scanner.next();

            switch (a) {
                case "1":
                    // 사용자로부터 예금주 이름과 초기 입금액을 입력받습니다.
                    System.out.print("예금주 이름을 입력하세요: ");
                    String owner = scanner.next();
                    System.out.print("개인 비밀번호를 정해주세요: ");
                    int password = scanner.nextInt();
                    System.out.print("초기 입금액을 입력하세요: ");
                    int balance = scanner.nextInt();

                    // Bank 클래스의 createAccount 메서드를 사용하여 새로운 통장을 개설합니다.
                    bank.createAccount(owner, balance, password);
                    break;
                case "2":
                    System.out.print("이름을 입력하세요: ");
                    String findAccountOwner = scanner.next();
                    List<Account> ownAccounts = bank.findAccount(findAccountOwner);
                    for (Account value : ownAccounts) {
                        System.out.println("계좌 번호 : " + value.getAno() + " 잔액 : " + value.getBalance());
                    }
                    break;
                case "3":
                    System.out.println("입금할 계좌 번호를 입력하세요.");
                    int DepositAccountNumber = scanner.nextInt();
                    System.out.println("입금할 금액을 입력하세요.");
                    int amount = scanner.nextInt();
                    bank.deposit(DepositAccountNumber, amount);
                    System.out.println("현재 계좌에 남은 잔액 : " + bank.findAccount(DepositAccountNumber).getBalance());
                    break;
                case "4":
                    System.out.println("출금할 계좌 번호를 입력하세요.");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.println("비밀번호를 입력하세요.");
                    int withdrawPassword = scanner.nextInt();
                    if(withdrawPassword != bank.findAccount(withdrawAccountNumber).getPassword()) {
                        System.out.println("비밀번호가 다릅니다.");
                        break;
                    } else {
                        System.out.println("출금할 금액을 입력하세요.");
                        int money = scanner.nextInt();
                        bank.withdraw(withdrawAccountNumber, money);
                        System.out.println("현재 계좌에 남은 잔액 : " + bank.findAccount(withdrawAccountNumber).getBalance());
                        break;
                    }
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("해당 선택지는 없습니다.");
                    break;
            }
        }
    }
}
