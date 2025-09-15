package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.User;
import in.sp.main.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MyController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) 
	{
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUserDetails()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable int id) 
	{
		User user = userService.getUserDetails(id).orElse(null);
		if (user != null) 
		{
			return ResponseEntity.ok().body(user);
		} 
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user)
	{
		User updateUser = userService.updateUserdetails(id, user);
		if (updateUser != null) 
		{
			return ResponseEntity.ok(updateUser);
		} 
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUserDetails(@PathVariable int id)
	{
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
}
