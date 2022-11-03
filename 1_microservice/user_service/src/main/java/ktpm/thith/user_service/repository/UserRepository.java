package ktpm.thith.user_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ktpm.thith.user_service.entity.User;


@Repository
public interface UserRepository  extends CrudRepository<User, Integer> {
	
}
