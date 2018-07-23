package com.tsms.entity;

public class UserVO {

	private int id;				//id
	private String username;	//用户名
	private String password;	//用户密码
	private int taxerId;		//员工编号
	private String salt;		//用户盐值
	private int permissionId;	//用户权限
	private int state;			//用户状态
	private String email;		//用户工作邮箱
	private String taxerCode;	//税务人员工号
	private String taxerName;	//税务人员名称
	private String mobile;		//税务人员电话
	private String address;		//税务人员地址
	private String sex;			//税务人员性别
	private String birthday;	//出生日期
	private int organId;		//所属税务机关
//	private int state;			//有效标志
	private int mgr;			//上级领导
	private int admin;			//系统管理员标志
	private String recordDate;	//录入日期
	private int recordUserId;	//录入人员
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	public UserVO(int id, String username, String password, int taxerId, String salt, int permissionId, int state,
			String email, String taxerCode, String taxerName, String mobile, String address, String sex,
			String birthday, int organId, int mgr, int admin, String recordDate, int recordUserId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.taxerId = taxerId;
		this.salt = salt;
		this.permissionId = permissionId;
		this.state = state;
		this.email = email;
		this.taxerCode = taxerCode;
		this.taxerName = taxerName;
		this.mobile = mobile;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.organId = organId;
		this.mgr = mgr;
		this.admin = admin;
		this.recordDate = recordDate;
		this.recordUserId = recordUserId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTaxerId() {
		return taxerId;
	}
	public void setTaxerId(int taxerId) {
		this.taxerId = taxerId;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTaxerCode() {
		return taxerCode;
	}
	public void setTaxerCode(String taxerCode) {
		this.taxerCode = taxerCode;
	}
	public String getTaxerName() {
		return taxerName;
	}
	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getOrganId() {
		return organId;
	}
	public void setOrganId(int organId) {
		this.organId = organId;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public int getRecordUserId() {
		return recordUserId;
	}
	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}
	
}
