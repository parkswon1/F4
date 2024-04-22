package com.example.day13.실습;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    private final Set<Employee> employees = new HashSet<>();
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("이름 : " + employee.getName() + " id: " + employee.getId() + " 부서: " + employee.getDepartment() + " 신규 사원 정보가 등록되었습니다.");
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println(employee.getName() + " 사원 정보가 삭제되었습니다.");
    }

    public void findEmployee(String id) {
        for (Employee employee : employees) {
            if(employee.getId().equals(id)) {
                System.out.println(employee);;
            }
        }
    }
}
