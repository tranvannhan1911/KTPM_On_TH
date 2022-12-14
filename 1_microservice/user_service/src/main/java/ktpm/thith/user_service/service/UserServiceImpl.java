package ktpm.thith.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktpm.thith.user_service.entity.User;
import ktpm.thith.user_service.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> listUser() {
		List<User> products = (List<User>) userRepository.findAll(); 
		return products;
	}

	@Override
	public User getUser(int id) {
		User user = userRepository.findById(id).orElse(null); 
		return user;
	}

}
