package project.bank.service.refac;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        Banker banker = config.banker("정주연");
        banker.OpenBank("111", 3000, "123");
        banker.OpenBank("123", 3000, "456");

        banker.depositService("123", 3000);
        banker.depositService("456", 7000);



    }
}
