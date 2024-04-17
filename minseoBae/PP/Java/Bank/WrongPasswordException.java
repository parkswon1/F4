package com.example.day10.실습;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        System.out.println("비밀번호가 다릅니다.");;
    }
}
