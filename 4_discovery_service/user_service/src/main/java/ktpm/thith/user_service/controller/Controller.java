package ktpm.thith.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ktpm.thith.user_service.entity.Product;
import ktpm.thith.user_service.entity.User;
import ktpm.thith.user_service.feign.ProductClient;
import ktpm.thith.user_service.service.UserService;


@RestController
public class Controller {
	@Autowired
	private UserService userService;

    @Autowired 
    private ProductClient productClient;
    
	@GetMapping("/user")
	public List<User> listUser() {
		List<User> users = userService.listUser();
		return users;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.getUser(id);
		return user;
	}
	

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return user;
	}
	
	@GetMapping("/product")
	public List<Product> listProduct() {
		List<Product> products = productClient.listProduct();
		return products;
	}
}
