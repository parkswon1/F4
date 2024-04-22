package project.collections.employee;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee("홍길동", "E01", "HR"));
        manager.addEmployee(new Employee("홍길동", "E02", "HR"));


        manager.findEmployee("E01");
        manager.findEmployee("E02");
        manager.removeEmployee(new Employee("홍길동", "E01", "HR"));
        manager.findEmployee("E01");




    }
}
