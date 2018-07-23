package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.TaxsourceDao;
import com.tsms.entity.Taxsource;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaxsourceDaoImpl implements TaxsourceDao{

	private DBUtil db = DBUtil.getInstance();
	private String sql = "";
	/**
	 * 查询所有
	 */
	@Override
	public List<Map<String, String>> getAllTaxsources(String payerCode, String payerName, String subOrganId, String industryId, int pageNo, int pageSize) {
		List<Map<String, String>> list;
		if(StringUtil.isNotBlank(payerCode)){
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and p.payerCode like '%" + payerCode + "%' and s.removeState=0 limit ?,?";
			list = db.query(sql, (pageNo-1)*pageSize,pageSize);
		} else if (StringUtil.isNotBlank(payerName)){
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and p.payerName like '%" + payerName + "%' and s.removeState=0 limit ?,?";
			list = db.query(sql, (pageNo-1)*pageSize,pageSize);
		} else if (StringUtil.isNotBlank(subOrganId)){
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and s.subOrganId=? and s.removeState=0 limit ?,?";
			list = db.query(sql, subOrganId,(pageNo-1)*pageSize,pageSize);
		} else if (StringUtil.isNotBlank(industryId)){
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and p.industryId=? and s.removeState=0 limit ?,?";
			list = db.query(sql, industryId,(pageNo-1)*pageSize,pageSize);
		} else {
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and s.removeState=0 limit ?,?";
			list = db.query(sql, (pageNo-1)*pageSize,pageSize);
		}
		return list;
	}

	/**
	 * 查询共有多少条数据
	 */
	@Override
	public int listAllTaxsourceByPageCount() {
		List<Map<String, String>> list = db.query("select count(id) cou from tb_tax_source where removeState=0");
		return Integer.parseInt(list.get(0).get("cou"));
	}

	/**
	 * 根据id删除
	 */
	@Override
	public boolean deleteTaxsourceById(int id) {
		Object[] obj = {id};
		boolean b = db.update("update tb_tax_source set removeState=1 where id =?", obj);
		return b;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public Map<String, String> getTaxsourceById(int id) {
		Map<String, String> map = db.queryOneRow("select payerId,payerCode,payerName,bizAddress,organName,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,t.recordDate td,t.taxerName tn,taskName,organName,t.taxerName tr,t.taxerName tf,executeTime,taskState from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_taxer t join tb_user u on s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and s.recordUserId=u.id and s.removeState=0 where s.id=?", id);
		return map;
	}

	/**
	 * 添加
	 */
	@Override
	public boolean addTaxsource(Taxsource source) {
		sql="insert into tb_tax_source set payerId=?,taskName=?,subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=?";
		Object[]params={source.getPayerId(),source.getTaskName(),source.getSubOrganId(),source.getApproverId(),source.getExecuteId(),source.getExecuteTime(),source.getTaskState()};
		boolean b = db.update(sql, params);
		return b;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateTaxsource(Taxsource source) {
		sql="update tb_tax_source set subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=? where id=?";
		Object[]params={source.getSubOrganId(),source.getApproverId(),source.getExecuteId(),source.getExecuteTime(),source.getTaskState(),source.getId()};
		boolean b = db.update(sql, params);
		return b;
	}

	/**
	 * 根据name查询
	 */
	@Override
	public Map<String, String> getTaxsourceByName(String payerCode) {
		sql="select p.id,payerCode,payerName,bizAddress,organName,industryName,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,p.recordDate rd,tx.taxerName ta from tb_tax_payer p join  tb_tax_organ o join tb_industry i join tb_user u join tb_taxer tx on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and u.taxerId=tx.id where p.payerCode=?";
		Map<String, String> map = db.queryOneRow(sql, Integer.parseInt(payerCode));
		return map;
	}

	/**
	 * 查询所有未调查纳税人信息
	 */
	@Override
	public List<Map<String, String>> getAllTaxsourcess(String payerCode, String payerName, int pageNo, int pageSize) {
		List<Map<String, String>> list;
		if(StringUtil.isNotBlank(payerCode)){
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and p.payerCode=? and s.removeState=1 limit ?,?";
			list = db.query(sql, payerCode,(pageNo-1)*pageSize,pageSize);
		} else if (StringUtil.isNotBlank(payerName)){
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and p.payerName=? and s.removeState=1 limit ?,?";
			list = db.query(sql, payerName,(pageNo-1)*pageSize,pageSize);
		} else {
			sql="select * from tb_tax_source s,tb_tax_payer p ,tb_tax_organ o,tb_taxer t,tb_industry i where s.payerId=p.id and s.subOrganId=o.id and s.approverId=t.id and p.industryId=i.id and s.removeState=1 limit ?,?";
			list = db.query(sql, (pageNo-1)*pageSize,pageSize);
		}
		return list;
	}

	@Override
	public int listAllTaxsourcesByPageCount() {
		List<Map<String, String>> list = db.query("select count(id) cou from tb_tax_source where removeState=1");
		return Integer.parseInt(list.get(0).get("cou"));
	}

}
