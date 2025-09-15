package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.User;
import in.sp.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User createUser(User user) 
	{
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUser() 
	{
		return userRepository.findAll();
	}


	@Override
	public Optional<User> getUserDetails(int id) 
	{
		return userRepository.findById(id);
	}


	@Override
	public User updateUserdetails(int id, User newUser) 
	{
		User userData = userRepository.findById(id).orElse(null);
		
		if (userData != null) 
		{
			return userRepository.save(newUser);
		} 
		else 
		{
			throw new RuntimeException("User not found with id : "+id);
		}
	}


	@Override
	public void deleteUser(int id) 
	{
		userRepository.deleteById(id);
	}
	
	

	
	
}
