package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;


import com.tsms.dao.TaxpayerDao;
import com.tsms.entity.Taxpayer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaxpayerDaoImpl implements TaxpayerDao{

	private DBUtil db = DBUtil.getInstance();
	private String sql = "";
	/**
	 * 查询所有
	 */
	@Override
	public List<Map<String, String>> getAllTaxpayers(String payerCode,String payerName,int pageNo,int pageSize) {
		List<Map<String, String>> list;
		if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			sql="select * from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer tx on p.taxOrganId=o.id and p.industryId=i.id and p.userId=tx.id and p.payerCode=? and p.payerName=? and p.removeState=0 limit ?,?";
			list = db.query(sql,payerCode,payerName,(pageNo-1)*pageSize,pageSize);
		} else if (StringUtil.isNotBlank(payerCode)){
			sql="select * from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer tx on p.taxOrganId=o.id and p.industryId=i.id and p.userId=tx.id and p.payerCode=? and p.removeState=0 limit ?,?";
			list = db.query(sql,payerCode,(pageNo-1)*pageSize,pageSize);
		} else if (StringUtil.isNotBlank(payerName)){
			sql="select * from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer tx on p.taxOrganId=o.id and p.industryId=i.id and p.userId=tx.id and p.payerName=? and p.removeState=0 limit ?,?";
			list = db.query(sql,payerName,(pageNo-1)*pageSize,pageSize);
		} else {
			sql="select * from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer tx on p.taxOrganId=o.id and p.industryId=i.id and p.userId=tx.id and p.removeState=0 limit ?,?";
			list = db.query(sql,(pageNo-1)*pageSize,pageSize);
		}
		return list;
	}
	
	/**
	 * 查询共有多少条数据
	 */
	@Override
	public int listAllTaxpayersByPageCount() {
		List<Map<String, String>> list = db.query("select count(id) cou from tb_tax_payer where removeState=0");
		return Integer.parseInt(list.get(0).get("cou"));
	}
	
	/**
	 * 根据id删除
	 */
	@Override
	public boolean deleteTaxpayerById(int id) {
		Object[] obj = {id};
		boolean b = db.update("update tb_tax_payer set removeState=1 where id =?", obj);
		return b;
	}
	
	/**
	 * 根据id查询
	 */
	@Override
	public Map<String, String> getTaxpayerById(int id) {
		Map<String, String> map = db.queryOneRow("select p.id,payerCode,payerName,bizAddress,bizAddressPhone,organName,industryName,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,legalIdCardImageURL,finaceIdCardImageURL,(tx.taxerName)ta,(p.recordDate)rd from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_user u join tb_taxer tx on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and u.taxerId=tx.id where p.id=?", id);
		return map;
	}
	
	/**
	 * 添加
	 */
	@Override
	public boolean addTaxpayer(Taxpayer payer) {
		sql="insert into tb_tax_payer values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={payer.getPayerCode(),payer.getPayerName(),payer.getBizAddress(),payer.getTaxOrganId(),payer.getIndustryId(),payer.getBizScope(),payer.getInvoiceType(),payer.getLegalPerson(),payer.getLegalIdCard(),payer.getLegalMobile(),payer.getLegalIdCardImageURL(),payer.getFinaceName(),payer.getFinaceIdCard(),payer.getFinaceMobile(),payer.getFinaceIdCardImageURL(),payer.getTaxerName(),payer.getTaxerIdCard(),payer.getTaxerMobile(),payer.getTaxerIdCardImageURL(),payer.getBizAddressPhone(),payer.getRecordDate(),payer.getUserId(),payer.getRemoveState()};
		boolean b = db.update(sql, params);
		return b;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateTaxpayer(Taxpayer payer) {
		sql="update tb_tax_payer set payerName=?,bizAddress=?,bizAddressPhone=?,taxOrganId=?,industryId=?,bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,finaceName=?,finaceIdCard=? where id=?";
		Object[] params={payer.getPayerName(),payer.getBizAddress(),payer.getBizAddressPhone(),payer.getTaxOrganId(),payer.getIndustryId(),payer.getBizScope(),payer.getInvoiceType(),payer.getLegalPerson(),payer.getLegalIdCard(),payer.getFinaceName(),payer.getFinaceIdCard(),payer.getId()};
		boolean b = db.update(sql, params);
		return b;
	}
}
