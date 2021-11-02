package pro.sly.EmployeeWorkList;

import org.springframework.stereotype.Service;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] EmployeeList = new Employee[10];

    public String addEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        for (int i = 0; i < EmployeeList.length; i++) {
            if (EmployeeList[i] == null) {
                EmployeeList[i] = worker;
                return worker.getFirstName() + " " + worker.getLastName();
            }
        }
        throw new ArrayIsFullException();
    }

    public String removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < EmployeeList.length; i++) {
            if (EmployeeList[i] == null) {
                continue;
            }
            if (EmployeeList[i].getFirstName().equals(firstName) && EmployeeList[i].getLastName().equals(lastName)) {
                EmployeeList[i] = null;
                return firstName + " " + lastName;
            }
        }
        throw new NotFindEmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < EmployeeList.length; i++) {
            if (EmployeeList[i] == null) {
                continue;
            }
            if (EmployeeList[i].getFirstName().equals(firstName) && EmployeeList[i].getLastName().equals(lastName)) {
                return EmployeeList[i];
            }
        }
        throw new NotFindEmployeeException();
    }
}
