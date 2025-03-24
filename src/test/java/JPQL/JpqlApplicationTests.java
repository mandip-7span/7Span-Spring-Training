package JPQL;

import JPQL.entities.Student;
import JPQL.repos.StudentRepositry;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpqlApplicationTests {

	@Autowired
	StudentRepositry repositry;

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstname("mandeep");
		student.setLastname("Patel");
		student.setScore(84);

		Student student2 = new Student();
		student2.setFirstname("deep");
		student2.setLastname("Patel");
		student2.setScore(98);

		Student student3 = new Student();
		student3.setFirstname("hil");
		student3.setLastname("Patel");
		student3.setScore(94);

		Student student4 = new Student();
		student4.setFirstname("het");
		student4.setLastname("Patel");
		student4.setScore(88);

		repositry.save(student);
		repositry.save(student2);
		repositry.save(student3);
		repositry.save(student4);
	}

	@Test
	public void testFindAllStudents() {
		System.out.println(repositry.findAllStudents(PageRequest.of(0,4, Sort.Direction.DESC,"firstname","id")));
	}

	@Test
	public void testFindStudentPartialData() {
		List<Object[]> partialData = repositry.findStudentPartialData();
		for (Object[] object : partialData) {
			System.out.print(object[0]+" ");
			System.out.println(object[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(repositry.findAllStudentsByFirstName("deep"));
	}

	@Test
	public void testFindAllStudentsByScore() {
		System.out.println(repositry.findAllStudentsByScore(88,98));
	}

	@Test
	public void testFindAllStudentsBetweenScore() {
		System.out.println(repositry.findAllStudentsBetweenScore(88,98));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentByFirstName() {
		repositry.deleteStudentByFirstName("het");
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateStudentsScoreByFirstName() {
		repositry.updateStudentsScoreByFirstName(95,"Mandeep");
	}

	@Test
	public void testFindAllStudentNq() {
		System.out.println(repositry.findAllStudentNQ());
	}

	@Test
	public void testFindStudentsFirstNameNq() {
		System.out.println(repositry.findStudentFirstNameNQ("MandeeP"));// Case insensitive
	}

	@Test
	public void testFindStudentByFirstNameNq() {
		List<Object[]> students = repositry.findStudentByFirstNameNQ();
		for(Object[] object : students) {
			System.out.println(object[0]);
		}
	}
}
