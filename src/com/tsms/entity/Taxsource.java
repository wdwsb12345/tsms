package com.tsms.entity;

public class Taxsource {

	private int id;					//任务编号
	private int payerId;			//纳税人id
	private String taskName;		//任务名称
	private int subOrganId;			//下达部门
	private int approverId;			//批准人
	private int executeId;			//执行人员
	private String executeTime;		//执行时间
	private String taskFrom;		//任务来源
	private String taskState;		//任务执行情况
	private String idea;			//调查结论或意见
	private int riskLevel;			//风险等级
	private String recordTaskDate;	//录入日期
	private int recordUserId;		//录入人员
	private int removeState;		//状态
	public Taxsource() {
		// TODO Auto-generated constructor stub
	}

	public Taxsource(int id, int payerId, String taskName, int subOrganId, int approverId, int executeId,
			String executeTime, String taskState) {
		super();
		this.id = id;
		this.payerId = payerId;
		this.taskName = taskName;
		this.subOrganId = subOrganId;
		this.approverId = approverId;
		this.executeId = executeId;
		this.executeTime = executeTime;
		this.taskState = taskState;
	}
	
	public Taxsource(int payerId, String taskName, int subOrganId, int approverId, int executeId,
			String executeTime, String taskState) {
		super();
		this.payerId = payerId;
		this.taskName = taskName;
		this.subOrganId = subOrganId;
		this.approverId = approverId;
		this.executeId = executeId;
		this.executeTime = executeTime;
		this.taskState = taskState;
	}
	
	public Taxsource(int id, int payerId, String taskName, int subOrganId, int approverId, int executeId,
			String executeTime, String taskFrom, String taskState, String idea, int riskLevel, String recordTaskDate,
			int recordUserId, int removeState) {
		super();
		this.id = id;
		this.payerId = payerId;
		this.taskName = taskName;
		this.subOrganId = subOrganId;
		this.approverId = approverId;
		this.executeId = executeId;
		this.executeTime = executeTime;
		this.taskFrom = taskFrom;
		this.taskState = taskState;
		this.idea = idea;
		this.riskLevel = riskLevel;
		this.recordTaskDate = recordTaskDate;
		this.recordUserId = recordUserId;
		this.removeState = removeState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPayerId() {
		return payerId;
	}
	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getSubOrganId() {
		return subOrganId;
	}
	public void setSubOrganId(int subOrganId) {
		this.subOrganId = subOrganId;
	}
	public int getApproverId() {
		return approverId;
	}
	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}
	public int getExecuteId() {
		return executeId;
	}
	public void setExecuteId(int executeId) {
		this.executeId = executeId;
	}
	public String getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}
	public String getTaskFrom() {
		return taskFrom;
	}
	public void setTaskFrom(String taskFrom) {
		this.taskFrom = taskFrom;
	}
	public String getTaskState() {
		return taskState;
	}
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	public String getIdea() {
		return idea;
	}
	public void setIdea(String idea) {
		this.idea = idea;
	}
	public int getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getRecordTaskDate() {
		return recordTaskDate;
	}
	public void setRecordTaskDate(String recordTaskDate) {
		this.recordTaskDate = recordTaskDate;
	}
	public int getRecordUserId() {
		return recordUserId;
	}
	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}
	public int getRemoveState() {
		return removeState;
	}
	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}
}
