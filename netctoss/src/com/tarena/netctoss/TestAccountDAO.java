package com.tarena.netctoss;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.impl.AccountDAOImpl;

public class TestAccountDAO {
	@Test
	public void testFindById(){
		AccountDAOImpl accountImpl=new AccountDAOImpl();
		Account account=accountImpl.findById(1005);
		System.out.println(account);
	}
	@Test
	public void testFindAll(){
		AccountDAOImpl accountImpl=new AccountDAOImpl();
		List<Account>list=accountImpl.findAll();
		int len=list.size();
		for(int i=0;i<len;i++){
			Account account=list.get(i);
			System.out.println(account);
		}
	}
	@Test
	public void testSave() throws SQLException{
		Account account=new Account();
		account.setRecommenderId(2);
		account.setLoginName("��Ҫ���˷�ʱ����");
		account.setLoginPasswd("666666");
		account.setStatus("0");
		account.setRealName("�󱿵�");
		account.setIdcardNo("4503112");
		account.setGender("M");
		account.setOccupation("Java����Ա");
		account.setTelephone("1235679979");
		account.setEmail("45032689@qq.com");
		account.setZipcode("537413");
		account.setQq("450982323");
		account.setLast_login_ip("66666");
		AccountDAO dao=new AccountDAOImpl();
		dao.save(account);
	}
	
	@Test
	public void testModify() throws SQLException{
		/*private static final String MODIFY="update account set login_name=?,login_passwd=?,status=?,"
				+ "create_date=?,real_name=?,idcard_no=?,birthdate=?,telephone=? where account_id=?";*/
		Date util=new Date();//util���µ�������
		//java.util.Dateת��Ϊjava.sql.Date
		java.sql.Date sql=new java.sql.Date(util.getTime());
		Account account=new Account();
		account.setLoginName("Ŭ������");
		account.setLoginPasswd("555555");
		account.setStatus("1");
		account.setCreateDate(sql);
		account.setRealName("�Դ�");
		account.setIdcardNo("007");
		account.setBirthdate(sql);
		account.setTelephone("18688695628");
		account.setAccountId(2055);
		AccountDAO dao=new AccountDAOImpl();
		account=dao.modify(account);
		System.out.println(account);
	}
	@Test
	public void testModifyStatus() throws SQLException{
		Account account=new Account();
		account.setStatus("0");
		account.setAccountId(2055);
		AccountDAO dao=new AccountDAOImpl();
		dao.modifyStatus(account);
		System.out.println(account);
	}
}
