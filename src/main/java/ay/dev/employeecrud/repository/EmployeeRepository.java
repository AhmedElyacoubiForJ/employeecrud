package ay.dev.employeecrud.repository;

import ay.dev.employeecrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
