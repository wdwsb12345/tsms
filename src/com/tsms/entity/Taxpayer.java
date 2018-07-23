package com.tsms.entity;

public class Taxpayer {

	private int id;						//id
	private String payerCode;			//纳税人识别号
	private String payerName;			//纳税人名称
	private String bizAddress;			//生产经营地址
	private int taxOrganId;				//所属税务机关
	private int industryId;				//行业
	private String bizScope;			//经营范围
	private String invoiceType;			//票种核定
	private String legalPerson;			//法人代表
	private String legalIdCard;			//法人代表身份号码
	private String legalMobile;			//法人代表手机号码
	private String legalIdCardImageURL;	//法人代表身份证扫描图片
	private String finaceName;			//财务人员
	private String finaceIdCard;		//财务人员身份号码
	private String finaceMobile;		//财务人员手机号码
	private String finaceIdCardImageURL;//财务人员身份证扫描图片
	private String taxerName;			//办税人员
	private String taxerIdCard;			//办税人员身份号码
	private String taxerMobile;			//办税人员手机号码
	private String taxerIdCardImageURL;	//办税人员身份证扫描图片
	private String bizAddressPhone;		//生产经营地电话
	private String recordDate;			//录入日期
	private int userId;					//录入人员
	private int removeState;			//状态
	public Taxpayer() {
		super();
	}
	
	public Taxpayer(int id, String payerCode, String payerName, String bizAddress, int taxOrganId, int industryId, String bizScope,
			String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String bizAddressPhone) {
		super();
		this.id = id;
		this.payerCode = payerCode;
		this.payerName = payerName;
		this.bizAddress = bizAddress;
		this.taxOrganId = taxOrganId;
		this.industryId = industryId;
		this.bizScope = bizScope;
		this.invoiceType = invoiceType;
		this.legalPerson = legalPerson;
		this.legalIdCard = legalIdCard;
		this.finaceName = finaceName;
		this.finaceIdCard = finaceIdCard;
		this.bizAddressPhone = bizAddressPhone;
	}

	public Taxpayer(int id, String payerCode, String payerName, String bizAddress, int taxOrganId, int industryId,
			String bizScope, String invoiceType, String legalPerson, String legalIdCard, String legalMobile,
			String legalIdCardImageURL, String finaceName, String finaceIdCard, String finaceMobile,
			String finaceIdCardImageURL, String taxerName, String taxerIdCard, String taxerMobile,
			String taxerIdCardImageURL, String bizAddressPhone, String recordDate, int userId, int removeState) {
		super();
		this.id = id;
		this.payerCode = payerCode;
		this.payerName = payerName;
		this.bizAddress = bizAddress;
		this.taxOrganId = taxOrganId;
		this.industryId = industryId;
		this.bizScope = bizScope;
		this.invoiceType = invoiceType;
		this.legalPerson = legalPerson;
		this.legalIdCard = legalIdCard;
		this.legalMobile = legalMobile;
		this.legalIdCardImageURL = legalIdCardImageURL;
		this.finaceName = finaceName;
		this.finaceIdCard = finaceIdCard;
		this.finaceMobile = finaceMobile;
		this.finaceIdCardImageURL = finaceIdCardImageURL;
		this.taxerName = taxerName;
		this.taxerIdCard = taxerIdCard;
		this.taxerMobile = taxerMobile;
		this.taxerIdCardImageURL = taxerIdCardImageURL;
		this.bizAddressPhone = bizAddressPhone;
		this.recordDate = recordDate;
		this.userId = userId;
		this.removeState = removeState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getBizAddress() {
		return bizAddress;
	}
	public void setBizAddress(String bizAddress) {
		this.bizAddress = bizAddress;
	}
	public int getTaxOrganId() {
		return taxOrganId;
	}
	public void setTaxOrganId(int taxOrganId) {
		this.taxOrganId = taxOrganId;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public String getBizScope() {
		return bizScope;
	}
	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getLegalIdCard() {
		return legalIdCard;
	}
	public void setLegalIdCard(String legalIdCard) {
		this.legalIdCard = legalIdCard;
	}
	public String getLegalMobile() {
		return legalMobile;
	}
	public void setLegalMobile(String legalMobile) {
		this.legalMobile = legalMobile;
	}
	public String getLegalIdCardImageURL() {
		return legalIdCardImageURL;
	}
	public void setLegalIdCardImageURL(String legalIdCardImageURL) {
		this.legalIdCardImageURL = legalIdCardImageURL;
	}
	public String getFinaceName() {
		return finaceName;
	}
	public void setFinaceName(String finaceName) {
		this.finaceName = finaceName;
	}
	public String getFinaceIdCard() {
		return finaceIdCard;
	}
	public void setFinaceIdCard(String finaceIdCard) {
		this.finaceIdCard = finaceIdCard;
	}
	public String getFinaceMobile() {
		return finaceMobile;
	}
	public void setFinaceMobile(String finaceMobile) {
		this.finaceMobile = finaceMobile;
	}
	public String getFinaceIdCardImageURL() {
		return finaceIdCardImageURL;
	}
	public void setFinaceIdCardImageURL(String finaceIdCardImageURL) {
		this.finaceIdCardImageURL = finaceIdCardImageURL;
	}
	public String getTaxerName() {
		return taxerName;
	}
	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}
	public String getTaxerIdCard() {
		return taxerIdCard;
	}
	public void setTaxerIdCard(String taxerIdCard) {
		this.taxerIdCard = taxerIdCard;
	}
	public String getTaxerMobile() {
		return taxerMobile;
	}
	public void setTaxerMobile(String taxerMobile) {
		this.taxerMobile = taxerMobile;
	}
	public String getTaxerIdCardImageURL() {
		return taxerIdCardImageURL;
	}
	public void setTaxerIdCardImageURL(String taxerIdCardImageURL) {
		this.taxerIdCardImageURL = taxerIdCardImageURL;
	}
	public String getBizAddressPhone() {
		return bizAddressPhone;
	}
	public void setBizAddressPhone(String bizAddressPhone) {
		this.bizAddressPhone = bizAddressPhone;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRemoveState() {
		return removeState;
	}
	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}
	
}
