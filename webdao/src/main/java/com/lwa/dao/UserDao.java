package com.lwa.dao;


import com.lwa.model.User;

public interface UserDao {

	/**
	 * 添加新用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	
	
}