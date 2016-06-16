package com.app.npr.service.users;

import java.util.List;

import com.app.npr.model.users.UserProfile;



public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
