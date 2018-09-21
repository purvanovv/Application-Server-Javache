package main.database;

import java.util.List;

public interface UserRepository {
	public void save(User user);
	
	public List<User> findAll();
	
	public Long count();
	
	public  void delete(String id);
	
	public boolean exists(String id);
	
	public boolean existsByUsername(String username);
	
	public User findOne(String id);
	
	public User findOneByUsername(String username);
	
}
