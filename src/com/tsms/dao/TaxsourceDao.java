package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxsource;

public interface TaxsourceDao {

	/**
	 * 查询所有纳税人信息
	 * @return
	 */
	List<Map<String, String>> getAllTaxsources(String payerCode,String payerName,String subOrganId,String industryId,int pageNo,int pageSize);
	
	/**
	 * 查询共有多少行
	 * @return
	 */
	int listAllTaxsourceByPageCount();
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteTaxsourceById(int id);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Map<String, String> getTaxsourceById(int id);
	
	/**
	 * 添加
	 * @param source
	 * @return
	 */
	boolean addTaxsource(Taxsource source);
	
	/**
	 * 修改
	 * @param payer
	 * @return
	 */
	boolean updateTaxsource(Taxsource source);
	
	/**
	 * 根据name查询
	 */
	Map<String, String> getTaxsourceByName(String payerCode);
	
	/**
	 * 查询所有未调查纳税人信息
	 * @return
	 */
	List<Map<String, String>> getAllTaxsourcess(String payerCode,String payerName,int pageNo,int pageSize);
	
	/**
	 * 查询共有多少行
	 * @return
	 */
	int listAllTaxsourcesByPageCount();
}
