package think.example.demo;

import exceptions.EmployeeAlreadyAddedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class EmployeeServiceTest {

     private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp(){
                employeeService = new EmployeeServiceImpl();
                employeeService.add("Baadsd","Dude",1,1002);
    }
    @Test
    public void addEmployeeTestSize(){
        employeeService.add("Baadsd","Dude",1,1002);
        var actualSize = employeeService.findAll();
        assertEquals(1,actualSize.size());
    }
    @Test
    public void addEmployeeTestAlreadyExistingEmployee(){
        try {
        employeeService.add("Baadsd","Dude",1,1002);
        } catch  (EmployeeAlreadyAddedException thrown) {
            return;
        }
        var actualSize = employeeService.findAll();
        assertEquals(1,actualSize.size());
    }


}
