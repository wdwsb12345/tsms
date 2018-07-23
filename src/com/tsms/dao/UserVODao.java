package com.tsms.dao;

import java.util.Map;

public interface UserVODao {

	/**
	 * 根据name查询
	 * @param username
	 * @return
	 */
//	UserVO getUserVOByName(String username);
	
	Map<String, String> getUserVOByName(String username);
}
