package ComponentMapping;

import ComponentMapping.entities.Address;
import ComponentMapping.entities.Employee;
import ComponentMapping.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComponentMappingApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void crateEmployee() {
		Employee employee = new Employee();
		Address address = new Address();

		employee.setId(1);
		employee.setName("mandeep");
		address.setStreetaddress("Vadechi Society");
		address.setCity("Unjha");
		address.setZipcode("384170");
		address.setCountry("India");
		address.setState("Gujarat");
		employee.setAddress(address);

		repository.save(employee);
	}

}
