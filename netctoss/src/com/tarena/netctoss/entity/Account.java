package com.tarena.netctoss.entity;

import java.sql.Date;

/**
 * 此类为数据库account表的映射
 * 
 * @author cao
 *
 */
public class Account {
	private int accountId;// 账号id
	private int recommenderId;// 推荐人id
	private String loginName;// 登录名
	private String loginPasswd;// 登陆密码
	private String status;// 消息状态
	private Date createDate;// 账号创建日期
	private Date pauseDate;// 账号暂停日期
	private Date closeDate;// 账号注销日期
	private String realName;// 真实姓名
	private String idcardNo;// 身份证号码
	private Date birthdate;// 生日
	private String gender;// 性别
	private String occupation;// 职业
	private String telephone;// 电话
	private String email;// 邮箱
	private String mailaddress;// 右键地址
	private String zipcode;// 邮政编码
	private String qq;// QQ
	private Date last_login_time;// 最后登陆时间
	private String last_login_ip;// 最后登陆ip
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getRecommenderId() {
		return recommenderId;
	}
	public void setRecommenderId(int recommenderId) {
		this.recommenderId = recommenderId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPasswd() {
		return loginPasswd;
	}
	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_loging_time) {
		this.last_login_time = last_loging_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", recommenderId=" + recommenderId + ", loginName=" + loginName
				+ ", loginPasswd=" + loginPasswd + ", status=" + status + ", createDate=" + createDate + ", pauseDate="
				+ pauseDate + ", closeDate=" + closeDate + ", realName=" + realName + ", idcardNo=" + idcardNo
				+ ", birthdate=" + birthdate + ", gender=" + gender + ", occupation=" + occupation + ", telephone="
				+ telephone + ", email=" + email + ", mailaddress=" + mailaddress + ", zipcode=" + zipcode + ", qq="
				+ qq + ", last_login_time=" + last_login_time + ", last_login_ip=" + last_login_ip + "]";
	}
	
}
