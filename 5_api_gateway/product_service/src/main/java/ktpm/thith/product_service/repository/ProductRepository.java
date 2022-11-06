package ktpm.thith.product_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ktpm.thith.product_service.entity.Product;


@Repository
public interface ProductRepository  extends CrudRepository<Product, String> {
	
}
