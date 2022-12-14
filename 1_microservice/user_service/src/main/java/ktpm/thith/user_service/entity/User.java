package ktpm.thith.user_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="User")
@Getter
@Setter
public class User {
    @Id
    @Column(name="userId")
	private int userId;
    
    @Column(name="name")
	private String name;
    
    @Column(name="phone")
	private float phone;
    

    public User() {
    	
    }
}
