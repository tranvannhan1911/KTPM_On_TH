package ktpm.thith.user_service.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private String proId;
	private String name;
	private float price;
    

    public Product() {
    	
    }
}