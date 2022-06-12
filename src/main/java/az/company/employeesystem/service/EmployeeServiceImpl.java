package az.company.employeesystem.service;

import az.company.employeesystem.entity.EmployeeEntity;
import az.company.employeesystem.model.Employee;
import az.company.employeesystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

      List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

      List<Employee> employees = employeeEntities.stream().map(emp -> new Employee(
              emp.getId(),
              emp.getFirstName(),
              emp.getLastName(),
              emp.getEmailId()
      )).collect(Collectors.toList());

      return employees;
    }
}
