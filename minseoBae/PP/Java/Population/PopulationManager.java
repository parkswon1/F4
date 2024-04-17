package com.example.day13.실습;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationManager {
    Map<String, Integer> cities = new HashMap<>();
    //알맞게 구현해 주세요.
    public void addOrUpdateCity(String city, int population) {
        cities.put(city, population);
    }

    public void removeCity(String city) {
        cities.remove(city);
    }

    public void displayPopulation(String city) {
        if(cities.containsKey(city)) {
            System.out.println(city + "는 " + cities.get(city) + "명의 인구가 살고 있습니다.");
        } else System.out.println("해당 도시는 없습니다.");
    }

    public void displayAll() {
        for(String city : cities.keySet()) {
            System.out.println(city + " : " + cities.get(city));
        }
    }

    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (추가/수정(1), 삭제(2), 조회(3), 전체 조회(4), 종료(0)): ");
            String command = scanner.next();
            if (command.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case "1":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case "2":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.removeCity(city);
                    break;
                case "3":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.displayPopulation(city);
                    break;
                case "4":
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();
    }
}