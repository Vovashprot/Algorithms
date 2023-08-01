package think.example.demo;

import java.util.Collection;

public interface EmployeeService {
    public Employee add(String firstName, String lastname,int department, int salary);
    public Employee remove(String firstName, String lastname);
    public Employee find(String firstName, String lastname);

    public  Employee setDepartment(String firstname, String lastname, int department);
    public  Employee setSalary(String firstname, String lastname, int salary);

    Collection<Employee> findAll();
}
