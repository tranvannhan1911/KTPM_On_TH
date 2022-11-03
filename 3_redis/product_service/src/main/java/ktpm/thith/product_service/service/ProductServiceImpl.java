package ktpm.thith.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import ktpm.thith.product_service.entity.Product;
import ktpm.thith.product_service.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
    private final String HASH_KEY_NAME = "product";
	
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private RedisTemplate template;
    
	@Override 
	public Product createProduct(Product product) {
		product = productRepository.save(product);
		template.opsForHash().put(HASH_KEY_NAME, product.getProId(), product);
		return product;
	}

	@Override
	public List<Product> listProduct() {
//		List<Product> products = (List<Product>) productRepository.findAll();
		List<Product> products = (List<Product>) template.opsForHash().values(HASH_KEY_NAME);
		return products;
	}

	@Override
	public Product getProduct(String id) {
//		Product product = productRepository.findById(id).orElse(null);
		Product product = (Product) template.opsForHash().get(HASH_KEY_NAME, id);
		return product;
	}

	@Override
	public boolean deleteProduct(String id) { 
		productRepository.deleteById(id);
		template.opsForHash().delete(HASH_KEY_NAME, id);
		return true;
	}

}
