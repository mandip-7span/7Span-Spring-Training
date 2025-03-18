package idGenerators.Generators;

import idGenerators.Generators.entities.Employee;
import idGenerators.Generators.repos.EmployeeRepositry;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GeneratorsApplicationTests {


	@Autowired
	EmployeeRepositry er;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("man");

		er.save(employee);
	}
}
