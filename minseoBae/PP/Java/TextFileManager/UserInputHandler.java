package com.example.day14.실습;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
    public List<String> getUserInput() {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("문장을 입력하세요(종료=0): ");
        while (!scanner.hasNext("0")) {
            list.add(scanner.nextLine());
        }

        return list;
    }
}
