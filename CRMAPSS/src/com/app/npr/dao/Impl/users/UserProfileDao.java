package com.app.npr.dao.Impl.users;

import java.util.List;

import com.app.npr.model.users.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
