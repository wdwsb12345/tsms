package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxer;

public interface TaxerDao {

	/**
	 * 查询所有纳税人信息
	 * @return
	 */
	List<Map<String, String>> getAllTaxers(String taxerName,int pageNo,int pageSize);
	
	/**
	 * 查询共有多少行
	 * @return
	 */
	int listAllTaxersByPageCount();
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Map<String, String> getTaxerById(int id);
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteTaxerById(int id);
	
	/**
	 * 添加
	 * @param wechat
	 * @return
	 */
	boolean addTaxer(Taxer taxer);
	
	/**
	 * 修改
	 * @param payer
	 * @return
	 */
	boolean updateTaxer(Taxer taxer);
}
