package SpringData.springdata;

import SpringData.springdata.entities.Product;
import SpringData.springdata.repos.ProductRepositry;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdataApplicationTests {

	@Autowired
	ProductRepositry repositry;

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
		List<Product> products = repositry.findByIdIn(Arrays.asList(2,4));
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
		repositry.findAll(new Sort(null,"name")).forEach(p-> System.out.println(p.getName()));
	}
}
