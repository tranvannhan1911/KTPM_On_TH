package ktpm.thith.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktpm.thith.product_service.entity.Product;
import ktpm.thith.product_service.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> listProduct() {
		List<Product> products = (List<Product>) productRepository.findAll(); 
		return products;
	}

	@Override
	public Product getProduct(String id) {
		System.out.println("get product ...");
		Product product = productRepository.findById(id).get(); 
		return product;
	}

}
