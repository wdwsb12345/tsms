package com.tsms.dao;

import com.tsms.entity.User;

public interface LoginUserDao {

	/**
	 * 根据name查询
	 * @param username
	 * @return
	 */
	User getLoginUserByName(String username);
	
	/**
	 * 修改
	 * @param payer
	 * @return
	 */
	boolean updateUser(String username,String newPassword);
}
