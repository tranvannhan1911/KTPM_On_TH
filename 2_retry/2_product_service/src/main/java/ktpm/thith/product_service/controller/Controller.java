package ktpm.thith.product_service.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import ktpm.thith.product_service.entity.Product;
import ktpm.thith.product_service.service.ProductService;


@RestController
public class Controller {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public List<Product> listProduct() {
		RetryConfig config = RetryConfig.custom()
				  .maxAttempts(3)
				  .waitDuration(Duration.ofSeconds(2))
				  .build();
		RetryRegistry registry = RetryRegistry.of(config);
		Retry retry = registry.retry("productService", config);
		
		List<Product> products = retry.executeSupplier(
				  () -> productService.listProduct());
		return products;
	}
	
	@GetMapping("/product/{id}")
	public Product getProduc(@PathVariable String id) {
		RetryConfig config = RetryConfig.custom()
				  .maxAttempts(3)
				  .waitDuration(Duration.ofSeconds(2))
				  .build();
		RetryRegistry registry = RetryRegistry.of(config);
		Retry retry = registry.retry("productService", config);
		
		Product product = retry.executeSupplier(
				  () -> productService.getProduct(id));
		
		return product;
	}
	

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		product = productService.createProduct(product);
		return product;
	}
}
