package pro.sly.EmployeeWorkList;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employeeList = new Employee[10];

    public Employee addEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                employeeList[i] = worker;
                return worker;
            }
        }
        throw new ArrayIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                continue;
            }
            if (employeeList[i].equals(worker)) {
                employeeList[i] = null;
                return worker;
            }
        }
        throw new NotFoundEmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                continue;
            }
            if (employeeList[i].equals(worker)) {
                return employeeList[i];
            }
        }
        throw new NotFoundEmployeeException();
    }
}
