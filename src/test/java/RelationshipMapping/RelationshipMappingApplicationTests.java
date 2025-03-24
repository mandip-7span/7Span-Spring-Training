package RelationshipMapping;

import RelationshipMapping.entities.*;
import RelationshipMapping.repos.CustomerRepository;
import RelationshipMapping.repos.LicenseRepository;
import RelationshipMapping.repos.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class RelationshipMappingApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
	LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createCustomers() {
		Customer customer = new Customer();
		customer.setName("mandeep");

		HashSet<PhoneNumber> numbers = new HashSet<>();

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("9023277872");
		ph1.setType("home");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("9173661706");
		ph2.setType("Personal");

		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}

	@Test
	@Transactional
	public void loadCustomerData() {
		Optional<Customer> customer = repository.findById(2L);
		System.out.println(customer.get().getName());

		Set<PhoneNumber> numbers = customer.get().getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));
	}

	@Test
	@Transactional
	public void updateCustomerData() {
		Optional<Customer> customer = repository.findById(2L);
		Customer cmr = customer.get();
		cmr.setName("Deep");

		Set<PhoneNumber> numbers = cmr.getNumbers();
		numbers.forEach(number -> number.setType("cellphone"));

		repository.save(cmr);
	}

	@Test
	public void deleteCustomer() {
		repository.deleteById(2L);
	}

	@Test
	public void createProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("mandeep");
		programmer.setSal(10000);

		Project project = new Project();
		HashSet<Project> projects = new HashSet<>();
		project.setName("Hibernate Project");
		projects.add(project);
		programmer.setProjects(projects);

		programmerRepository.save(programmer);
	}

	@Test
	public void findProgrammer() {
		Optional<Programmer> programmer = programmerRepository.findById(1);

		if (programmer.isPresent()) {
			System.out.println(programmer.get().getName());
		} else {
			System.out.println("Programmer not found.");
		}
	}

	@Test
	public void createLicense() {
		License license = new License();
		license.setType("Bike");
		LocalDate startdate = LocalDate.now();
		license.setValidFrom(startdate);
		LocalDate enddate = LocalDate.of(2026,12,16);
		license.setValidTo(enddate);

		Person person = new Person();
		person.setFirstName("mandeep");
		person.setLastName("Patel");
		person.setAge(21);

		license.setPerson(person);

		licenseRepository.save(license);
	}
}
