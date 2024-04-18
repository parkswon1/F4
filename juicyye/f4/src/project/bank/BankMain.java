package project.bank;




import project.bank.service.Banker;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        //은행 객체는 통장 객체를 리스트로 관리하며, 통장 개설 및 통장 정보 조회 기능을 제공해야 합니다.
        // 은행원 객체는 통장 개설 및 출금 승인 프로세스를 관리합니다.
        Scanner scanner = new Scanner(System.in);
        Banker banker = new Banker("정주연");
        while(true) {
            try {
                System.out.println();
                System.out.println("=========은행 서비스============");
                System.out.println("1. 계좌 개설");
                System.out.println("2. 입금");
                System.out.println("3. 출금");
                System.out.println("4. 계좌정보 출력");
                System.out.println("5. 나가기");
                System.out.println("=============================");
                System.out.println("원하시는 서비스의 숫자를 입력해주세요");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("계좌 번호를 입력하세요: ");
                        String accNumber = scanner.next();
                        System.out.print("초기 입금 금액을 입력하세요: ");
                        int price = scanner.nextInt();
                        banker.OpenBank(accNumber, price);
                        break;
                    case 2:
                        System.out.print("입금할 계좌 번호를 입력하세요: ");
                        String accNumDeposit = scanner.next();
                        System.out.print("입금할 금액을 입력하세요: ");
                        int depositAmount = scanner.nextInt();
                        banker.depositService(accNumDeposit, depositAmount);
                        break;
                    case 3:
                        System.out.print("출금할 계좌 번호를 입력하세요: ");
                        String accNumWithdraw = scanner.next();
                        System.out.print("출금할 금액을 입력하세요: ");
                        int withdrawAmount = scanner.nextInt();
                        banker.withdrawService(accNumWithdraw, withdrawAmount);
                        break;
                    case 4:
                        System.out.println("조회하고 싶은 계좌번호를 입력해주세요");
                        String accountNumber = scanner.next();
                        banker.print(accountNumber);
                        break;
                    case 5:
                        System.out.println("프로그램을 종료합니다...");
                        System.exit(0);
                    default:
                        System.out.println("잘못된 선택입니다!");
                }
            } catch (RuntimeException e) {
                System.out.println();
                System.out.println("[" + e.getMessage() +"]");
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("알수없는 오류입니다.");
                throw new RuntimeException(e);
            }
        }



    }
}
