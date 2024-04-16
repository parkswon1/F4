package project.collections.employee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmployeeManager {
    private Set<Employee> employees = new HashSet<>();

    public EmployeeManager(Set<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeManager() {
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println("아이디: " + employee.getId() + "  |  이름: " + employee.getName() + "  |  부서: " + employee.getDepartment());
        }
    }

    public void findEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.println("아이디: " + employee.getId() + "  |  이름: " + employee.getName() + "  |  부서: " + employee.getDepartment());
                return; // 찾았으면 바로 종료
            }
        }
        // 찾지 못한 경우
        System.out.println("해당 아이디를 가진 직원을 찾을 수 없습니다.");
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addEmployee(Employee employee) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee1 = iterator.next();
            if(employee1.equals(employee)) {
                throw new IllegalArgumentException("중복된 회원입니다.");
            }
        }
        employees.add(employee);
    }
}
