package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxpayer;

public interface TaxpayerDao {
	
	/**
	 * 查询所有纳税人信息
	 * @return
	 */
	List<Map<String, String>> getAllTaxpayers(String payerCode,String payerName,int pageNo,int pageSize);
	/**
	 * 查询共有多少行
	 * @return
	 */
	int listAllTaxpayersByPageCount();
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteTaxpayerById(int id);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Map<String, String> getTaxpayerById(int id);
	
	/**
	 * 添加
	 * @param wechat
	 * @return
	 */
	boolean addTaxpayer(Taxpayer payer);
	
	/**
	 * 修改
	 * @param payer
	 * @return
	 */
	boolean updateTaxpayer(Taxpayer payer);
}
