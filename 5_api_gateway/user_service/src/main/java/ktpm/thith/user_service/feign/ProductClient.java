package ktpm.thith.user_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ktpm.thith.user_service.entity.Product;

import java.util.List;

@FeignClient("product")
public interface ProductClient {
    @GetMapping("/product")
    public List<Product> listProduct();
}