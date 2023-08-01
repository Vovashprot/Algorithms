package think.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;
    DepartmentService departmentService;
    List<Employee> DATASET = List.of(
    new Employee("baa","dude",1,1002),
    new Employee("dee", "ase", 2, 1034),
    new Employee("deese", "asees", 2, 1035),
    new Employee("deewe", "ase", 3, 1024));
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        departmentService = new DepartmentService(employeeService);

        when(employeeService.findAll()).thenReturn(DATASET);
    }
    @Test
    void testMax(){
        var actual = departmentService.maxSalary(1);
        var expected = new Employee("baa","dude",1,1002);
        assertEquals(expected,actual);
    }
    private static Collection<Arguments> parameters(){
        return List.of(
                Arguments.of(1,1002),
                Arguments.of(2,1034),
                Arguments.of(3,1024));

    }
    private static Collection<Arguments> parameters2(){
        return List.of(
                Arguments.of(2,2069),
                Arguments.of(1,1002),
                Arguments.of(3,1024));
    }

    private static Collection<Arguments> parameters3(){
        return List.of(
                Arguments.of(1,1),
                Arguments.of(2,2),
                Arguments.of(3,1));

    }

    @ParameterizedTest()
    @MethodSource("parameters")
    void testMin(int dept, int min){
        var actual = departmentService.minSalary(dept);
        assertNotNull(actual);
        assertEquals(min, actual.getSalary());
    }
    @ParameterizedTest()
    @MethodSource("parameters2")
    void testSum(int dept, int sum){
        var actual = departmentService.sumSalary(dept);
        assertNotNull(actual);
        assertEquals(sum, actual);
    }

    @ParameterizedTest()
    @MethodSource("parameters3")
    void testAllByDepartment(int dept,int expectedSize){
        var depAll = departmentService.allByDepartment(dept);
        assertEquals(depAll.size(),expectedSize);
    }
    @Test
    void testDeps(){
        var depAll = departmentService.allEmployees();
        assertEquals(depAll.size(),3);
    }

}
