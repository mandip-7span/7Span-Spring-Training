package idGenerators.Generators.repos;

import idGenerators.Generators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositry extends CrudRepository<Employee, Long> {
}
