package ktpm.thith.user_service.service;

import java.util.List;

import ktpm.thith.user_service.entity.User;

public interface UserService {
	User createUser(User user);
	public List<User> listUser();
	public User getUser(int id);
}
