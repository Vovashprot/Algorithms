package think.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee maxSalary(int department){
        return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    public Employee minSalary(int department){
        return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    public Integer sumSalary(int department){
        return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();

    }
    public Collection<Employee> allByDepartment(int department){
        return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> allEmployees (){
        return employeeService.findAll()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
