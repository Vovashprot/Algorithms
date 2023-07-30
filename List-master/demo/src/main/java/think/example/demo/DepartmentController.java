package think.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{department}/salary/max")
    public Employee maxSalary(@PathVariable ("department")   int department){
        return service.maxSalary(department);
    }
    @GetMapping("/{department}/salary/min")
    public Employee minSalary(@PathVariable ("department") int department){
        return service.minSalary(department);
    }

    @GetMapping("/{department}/salary/sum")
    public Integer sumSalary(@PathVariable ("department")  int department){
        return service.sumSalary(department);
    }

    @GetMapping("/{department}/employees")
    public Collection<Employee> allByDepartment(@PathVariable ("department")  int department){
        return service.allByDepartment(department);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> allEmployees(){
        return service.allEmployees();
    }

}
