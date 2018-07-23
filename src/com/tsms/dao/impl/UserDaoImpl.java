package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.UserVODao;
import com.tsms.util.DBUtil;

public class UserDaoImpl implements UserVODao{

	private DBUtil db = DBUtil.getInstance();
	private String sql = "";
	/**
	 * 根据name查询
	 */
	@Override
	public Map<String, String> getUserVOByName(String username) {
		sql="select taxerId,permissionId,(u.state)s1,taxerCode,taxerName,mobile,address,sex,birthday,(u.email) em,organId,(t.state)s2,mgr,admin,recordDate from tb_user u join tb_taxer t on u.taxerId=t.id where u.username=?";
		List<Map<String, String>> list = db.query(sql, username);
		return list.get(0);
	}



}
