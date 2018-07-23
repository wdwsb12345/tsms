package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.TaxerDao;
import com.tsms.entity.Taxer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaxerDaoImpl implements TaxerDao{

	private DBUtil db = DBUtil.getInstance();
	private String sql = "";
	/**
	 * 查询所有
	 */
	@Override
	public List<Map<String, String>> getAllTaxers(String taxerName, int pageNo, int pageSize) {
		List<Map<String, String>>list;
		if(StringUtil.isNotBlank(taxerName)){
		sql="select * from tb_taxer tx join tb_tax_organ o on tx.organId=o.id and tx.taxerName=? and tx.state=0 limit ?,?";
		list = db.query(sql, taxerName,(pageNo-1)*pageSize,pageSize);	
		} else {
		sql="select * from tb_taxer tx join tb_tax_organ o on tx.organId=o.id and tx.state=0 limit ?,?";
		list = db.query(sql, (pageNo-1)*pageSize,pageSize);	
		}
		return list;
	}
	
	/**
	 * 查询共有多少条数据
	 */
	@Override
	public int listAllTaxersByPageCount() {
		List<Map<String, String>> list = db.query("select count(id) cou from tb_taxer where state=0");
		return Integer.parseInt(list.get(0).get("cou"));
	}

	/**
	 * 根据id查询一条数据
	 */
	@Override
	public Map<String, String> getTaxerById(int id) {
		Map<String, String> map = db.queryOneRow("select * from tb_taxer tx join tb_tax_organ o on tx.organId=o.id where tx.id=?", id);
		return map;
	}

	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteTaxerById(int id) {
		Object[] obj = {id};
		boolean b = db.update("update tb_taxer set state=1 where id =?", obj);
		return b;
	}

	/**
	 * 添加
	 */
	@Override
	public boolean addTaxer(Taxer taxer) {
		sql="insert into tb_taxer (taxerCode,taxerName,mobile,address,sex,birthday,email,organId) values(?,?,?,?,?,?,?,?)";
		Object[]params={taxer.getTaxerCode(),taxer.getTaxerName(),taxer.getMobile(),taxer.getAddress(),taxer.getSex(),taxer.getBirthday(),taxer.getEmail(),taxer.getOrganId()};
		boolean b = db.update(sql, params);
		return b;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateTaxer(Taxer taxer) {
		sql="update tb_taxer set taxerName=?,mobile=?,address=?,sex=?,birthday=?,email=?,organId=? where id=?";
		Object[] params={taxer.getTaxerName(),taxer.getMobile(),taxer.getAddress(),taxer.getSex(),taxer.getBirthday(),taxer.getEmail(),taxer.getOrganId(),taxer.getId()};
		boolean b = db.update(sql, params);
		return b;
	}
}
