package com.app.npr.dao.Impl.users;

import java.util.List;

import com.app.npr.model.users.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();

}

