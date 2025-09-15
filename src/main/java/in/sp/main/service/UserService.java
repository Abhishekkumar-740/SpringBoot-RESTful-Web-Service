package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import in.sp.main.entity.User;

public interface UserService 
{
	public User createUser(User user);
	
	public List<User> getAllUser();
	
	public Optional<User> getUserDetails(int id);
	
	public User updateUserdetails(int id,User user);
	
	public void deleteUser(int id);
	
}