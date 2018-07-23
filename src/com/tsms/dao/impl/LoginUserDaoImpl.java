package com.tsms.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.tsms.dao.LoginUserDao;
import com.tsms.entity.User;
import com.tsms.util.DBUtil;

public class LoginUserDaoImpl implements LoginUserDao{

	private DBUtil db = DBUtil.getInstance();
	@Override
	public User getLoginUserByName(String username) {
		List<Map<String, String>> list = db.query("select * from tb_user u join tb_taxer t on u.taxerId=t.id where u.username=?",username);
		User u = new User();
		if(list.size()>0){
			try {
				BeanUtils.populate(u, list.get(0));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	
	/**
	 * 修改
	 */
	@Override
	public boolean updateUser(String username,String newPassword) {
		Object[] params={newPassword,username};
		boolean b = db.update("update tb_user set password=? where username=?", params);
		return b;
	}

}
