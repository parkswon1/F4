package project.bank.service.refac;



import project.bank.service.refac.acount.Account;
import project.bank.service.refac.acount.NormalAccount;

public class Config {

    private Account account(){
        return new NormalAccount();
    }
    public Banker banker(String name){
        return new Banker(name,account());
    }
}
