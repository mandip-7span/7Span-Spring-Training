package SpringData.springdata;

import SpringData.springdata.entities.Product;
import SpringData.springdata.repos.ProductRepositry;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdataApplicationTests {

	@Autowired
	ProductRepositry repositry;

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
	}

	@Test
	public void testRead() {
		Product product = repositry.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Test
	public void testUpdate() {
		Product product = repositry.findById(1).get();
		product.setPrice(12000d);
		repositry.save(product);
	}

	@Test
	public void testDelete() {
		if(repositry.existsById(1)) {
			repositry.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total records ======>>>>> " + repositry.count());
	}

	@Test
	public void testFindByName() {
		List<Product> products = repositry.findByName("v21");
		products.forEach(p-> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repositry.findByNameAndDesc("iphone", "from apple");
		products.forEach(p-> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repositry.findByPriceGreaterThan(7000d);
		products.forEach(p-> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByDescContains() {
		List<Product> products = repositry.findByDescContains("from realme");
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repositry.findByPriceBetween(5000,9000);
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<Product> products = repositry.findByDescLike("from realme");
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIdIn() {
		Pageable pageable = PageRequest.of(0,2, Sort.Direction.DESC,"name");
		List<Product> products = repositry.findByIdIn(Arrays.asList(1,2,3,4),pageable);
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(1,2);
		Page<Product> result = repositry.findAll(pageable);
		result.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting() {
		repositry.findAll(Sort.by(
				Sort.Order.desc("name"),
				Sort.Order.asc("price")
		)).forEach(p-> System.out.println(p.getName()));

		//repositry.findAll(Sort.by(Sort.Direction.ASC, "name","price")).forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(1,2, Sort.Direction.DESC,"name");
		repositry.findAll(pageable).forEach(p-> System.out.println(p.getName()));
	}

	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Optional<Product> optionalproduct = repositry.findById(1);
		Product product = optionalproduct.get();

		repositry.findById(1);

		//session.evict(product);

		repositry.findById(1);
	}
}
