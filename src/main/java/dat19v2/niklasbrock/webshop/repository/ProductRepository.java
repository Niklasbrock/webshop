package dat19v2.niklasbrock.webshop.repository;

import dat19v2.niklasbrock.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
