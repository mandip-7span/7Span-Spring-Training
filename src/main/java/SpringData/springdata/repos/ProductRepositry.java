package SpringData.springdata.repos;

import SpringData.springdata.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepositry extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String Desc);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByDescContains(String Desc);
    List<Product> findByPriceBetween(double price1, double price2);
    List<Product> findByDescLike(String Desc);
    List<Product> findByIdIn(List<Integer> ids);
}
