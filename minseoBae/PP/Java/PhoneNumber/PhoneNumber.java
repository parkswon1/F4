package com.example.day14.실습;

import java.io.*;

public class PhoneNumber {
    public static void main(String[] args) {
        String phoneList = null;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outTxt = new PrintWriter("c:\\temp\\phoneList.txt");) {
            for(int i = 0; i < 3; i++) {
                System.out.print("이름 : ");
                String name = br.readLine();
                System.out.print("전화번호 : ");
                String phoneNumber = br.readLine();
                outTxt.println(name + " " + phoneNumber);
            }
            outTxt.close();
            System.out.println("... 전화번호가 phoneNumbers.txt에 저장되었습니다.");

            BufferedReader kb = new BufferedReader(new FileReader("c:\\temp\\phoneList.txt"));
            System.out.println();
            System.out.println("phoneNumber.txt의 내용은 다음과 같습니다...");
            while((phoneList = kb.readLine()) != null) {
                System.out.println(phoneList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file." + e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
