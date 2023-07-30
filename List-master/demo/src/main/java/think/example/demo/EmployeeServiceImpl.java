package think.example.demo;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import exceptions.NotValidCharacterException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int mapLimit = 200;
    private final Map<String, Employee> employeeList = new HashMap<>(mapLimit);

    @Override
    public Employee add(String firstName, String lastname) {
        check(firstName, lastname);
        Employee employee = new Employee(firstName,lastname);
        if (employeeList.size()>mapLimit){
            throw new EmployeeStorageIsFullException();
        }
        String key = (firstName +"_"+ lastname).toLowerCase();
        if (employeeList.containsKey(key)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.put(key,employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastname) {
        check(firstName, lastname);
        StringUtils.capitalize(firstName);
        StringUtils.capitalize(lastname);
        String key = (firstName+"_"+lastname).toLowerCase();
        Employee employee = employeeList.remove(key);
        if (employee == null){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastname) {
        check(firstName, lastname);
        String key = (firstName+"_"+lastname).toLowerCase();
        Employee employee = employeeList.get(key);
        if (employee == null){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @Override
    public Employee setDepartment(String firstName, String lastname,int department) {
        check(firstName, lastname);
        String key = (firstName+"_"+lastname).toLowerCase();
        Employee employee = employeeList.get(key);
        if (employee == null){
            throw new EmployeeNotFoundException();
        }
        employee.setDepartment(department);
        return employee;
    }
    @Override
    public Employee setSalary(String firstName, String lastname,int salary) {
        check(firstName, lastname);
        String key = (firstName+"_"+lastname).toLowerCase();
        Employee employee = employeeList.get(key);
        if (employee == null){
            throw new EmployeeNotFoundException();
        }
        employee.setSalary(salary);
        return employee;
    }

    private void check(String... args){
        for (String arg : args){
            if (StringUtils.isAlpha(arg)){
                throw new NotValidCharacterException();
            }
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeList.values();
    }

}
