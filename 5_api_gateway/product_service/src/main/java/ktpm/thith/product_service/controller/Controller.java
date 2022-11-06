package ktpm.thith.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;

import ktpm.thith.product_service.entity.Product;
import ktpm.thith.product_service.service.ProductService;


@RestController
@RequestMapping("/product")
public class Controller {
	@Autowired
	private ProductService productService;
	
    @Autowired
    private DiscoveryClient discoveryClient; // just to list all services
	
	@GetMapping("")
	public List<Product> listProduct() {
		List<Product> products = productService.listProduct();
		return products;
	}
	
	@GetMapping("/{id}")
	public Product getProduc(@PathVariable String id) {
		Product product = productService.getProduct(id);
		return product;
	}
	

	@PostMapping("")
	public Product createProduct(@RequestBody Product product) {
		product = productService.createProduct(product);
		return product;
	}
	
//	list all service
	@GetMapping("/service")
	public void listServices() {
		System.out.println(discoveryClient.getServices());
		System.out.println(discoveryClient.getInstances("PRODUCT"));
//		List<Application> applications = discoveryClient.getApplications().getRegisteredApplications();
//
//	    for (Application application : applications) {
//	        List<InstanceInfo> applicationsInstances = application.getInstances();
//	        for (InstanceInfo applicationsInstance : applicationsInstances) {
//
//	            String name = applicationsInstance.getAppName();
//	            String url = applicationsInstance.getHomePageUrl();
//	            System.out.println(name + ": " + url);
//	        }
//	    }
//	    return applications;
	}
}
