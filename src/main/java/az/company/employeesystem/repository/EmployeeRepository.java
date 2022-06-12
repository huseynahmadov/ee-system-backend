package az.company.employeesystem.repository;

import az.company.employeesystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
