package org.liferayasif.backend.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.liferayasif.backend.constants.PathConstants;
import org.liferayasif.backend.model.User;
import org.liferayasif.backend.model.UserAddress;
import org.liferayasif.backend.service.UserAddressService;
import org.liferayasif.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PathConstants.USER)
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAddressService userAddressService;
	
	@RequestMapping(value=PathConstants.FIND_BY_ID)
	public User findById(@RequestParam("id") int id){
		
		User user = userService.getUserById(id);
		
		 List<UserAddress> userAddressList = new ArrayList<UserAddress>();
		 
		
		if(user != null){
			userAddressList = userAddressService.getUserAddressesByUserId(id);
			
			
			if(userAddressList != null && userAddressList.size()>0){
				user.setUserAddressList(userAddressList);
			}
		} 
		
		System.out.println(user);
		return user;
	}
	
	@RequestMapping(value=PathConstants.ADD_USER)
	public void add(@RequestBody User user){
		
		userService.addUser(user);
		
		List<UserAddress> userAddressList = user.getUserAddressList();
		
		userAddressService.addUserAddressList(userAddressList);
		
		return;
	}
	
	
}
