package think.example.demo;

import org.junit.jupiter.api.BeforeEach;

public class EmployeeServiceTest {
    EmployeeService employeeService;
    @BeforeEach
    public void setUp(){
        employeeService.add("baa","dude",1,1002);
    }

}
