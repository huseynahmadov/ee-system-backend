package az.company.employeesystem.model;

import lombok.Data;

@Data
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
