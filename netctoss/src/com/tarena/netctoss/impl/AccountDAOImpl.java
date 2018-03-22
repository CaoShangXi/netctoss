package com.tarena.netctoss.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.netctoss.AccountDAO;
import com.tarena.netctoss.BaseBAO;
import com.tarena.netctoss.entity.Account;

public class AccountDAOImpl extends BaseBAO implements AccountDAO {
	// 根据id查询账号信息sql
	private static final String SELECT_BY_ID = "select account_id,login_name,login_passwd,"
			+ "status,create_date,real_name,idcard_no,birthdate,telephone from account where account_id=?";
	
	//查询所有账号信息sql
	private static final String SELECT_ALL="select * from account";
	
	//新增账号sql
	private static final String INSERT="insert into account(account_id,recommender_id,login_name,login_passwd,status,create_date,pause_date,close_date,real_name,idcard_no,birthdate,gender,occupation,telephone,email,mailaddress,zipcode,qq,last_login_time,last_login_ip) values (account_seq.nextval,?,?,?,?,sysdate,sysdate,to_date('2025-05-06','yyyy-mm-dd'),?,?,to_date('1994-05-06','yyyy-mm-dd'),?,?,?,?,'哈哈上当了',?,?,to_date('2016-04-02','yyyy-mm-dd'),?)"; 

	//修改账号信息sql
	private static final String MODIFY="update account set login_name=?,login_passwd=?,status=?,"
			+ "create_date=?,real_name=?,idcard_no=?,birthdate=?,telephone=? where account_id=?";
	
	//更新账号状态sql
	private static final String UPDATE_STATUS="update account set status=? where account_id=?";
	
	//根据账号id查询某一账号
	@Override
	public Account findById(Integer id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account account=null;
		
		try {
			conn=getConnection();
			String sql=SELECT_BY_ID;
			//发送sql语句给数据库预编译
			ps=conn.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1, id);
			//执行查询
			rs=ps.executeQuery();
			while(rs.next()){
				account=new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setLoginName(rs.getString("login_name"));
				account.setLoginPasswd(rs.getString("login_passwd"));
				account.setStatus(rs.getString("status"));
				account.setCreateDate(rs.getDate("create_date"));
				account.setRealName(rs.getString("real_name"));
				account.setIdcardNo(rs.getString("idcard_no"));
				account.setBirthdate(rs.getDate("birthdate"));
				account.setTelephone(rs.getString("telephone"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("释放资源失败！");
				e.printStackTrace();
			}
		}
		return account;
	}
	
	//查看所有账号信息
	@Override
	public List<Account> findAll(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account account=null;
		List<Account>list=new ArrayList<Account>();
		try {
		conn=BaseBAO.getConnection();
		String sql=	SELECT_ALL;
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			account=new Account();
			account.setAccountId(rs.getInt("account_id"));
			account.setRecommenderId(rs.getInt("recommender_id"));
			account.setLoginName(rs.getString("login_name"));
			account.setLoginPasswd(rs.getString("login_passwd"));
			account.setStatus(rs.getString("status"));
			account.setCreateDate(rs.getDate("create_date"));
			account.setPauseDate(rs.getDate("pause_date"));
			account.setCloseDate(rs.getDate("close_date"));
			account.setRealName(rs.getString("real_name"));
			account.setIdcardNo(rs.getString("idcard_no"));
			account.setBirthdate(rs.getDate("birthdate"));
			account.setGender(rs.getString("gender"));
			account.setOccupation(rs.getString("occupation"));
			account.setTelephone(rs.getString("telephone"));
			account.setEmail(rs.getString("email"));
			account.setMailaddress(rs.getString("mailaddress"));
			account.setZipcode(rs.getString("zipcode"));
			account.setQq(rs.getString("qq"));
			account.setLast_login_time(rs.getDate("last_login_time"));
			account.setLast_login_ip(rs.getString("last_login_ip"));
			list.add(account);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("释放资源失败！");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//增加账号
	@Override
	public Account save(Account account){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=INSERT;
		try {
			conn=getConnection();
			//设置手动提交
			conn.setAutoCommit(false);
			//发送sql给数据库预编译，第一参数为发送的sql；第二个参数为数据库表的字段数组可返回对应的字段的值。
			ps=conn.prepareStatement(sql,new String[]{"account_id","real_name"});
			ps.setInt(1,account.getRecommenderId());
			ps.setString(2, account.getLoginName());
			ps.setString(3,account.getLoginPasswd());
			ps.setString(4,account.getStatus());
			ps.setString(5, account.getRealName());
			ps.setString(6, account.getIdcardNo());
			ps.setString(7,account.getGender());
			ps.setString(8,account.getOccupation());
			ps.setString(9, account.getTelephone());
			ps.setString(10,account.getEmail());
			ps.setString(11,account.getZipcode());
			ps.setString(12,account.getQq());
			ps.setString(13, account.getLast_login_ip());
			
			//执行操作
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();//返回对应字段的值，包含多个字段的值
			if(rs.next()){
				int id=rs.getInt(1);
				account.setAccountId(id);
				
			}
			//提交事务
			conn.commit();//提交事务必须在DML(数据操作语言)操作后执行
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("释放资源失败！");
				e.printStackTrace();
			}
		}
		return account;
	}
	
	//根据账号id修改账号信息
	@Override
	public Account modify(Account account){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=MODIFY;
		int flag=0;
		try {
			conn=getConnection();
			//发送给数据库预编译
			ps=conn.prepareStatement(sql);
			//设置占位符的值
			ps.setString(1,account.getLoginName());
			ps.setString(2,account.getLoginPasswd());
			ps.setString(3,account.getStatus());
			ps.setDate(4,account.getCreateDate());
			ps.setString(5,account.getRealName());
			ps.setString(6,account.getIdcardNo());
			ps.setDate(7, account.getBirthdate());
			ps.setString(8,account.getTelephone());
			ps.setInt(9, account.getAccountId());
			//执行操作，返回被执行的记录数
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("释放资源失败！");
				e.printStackTrace();
			}
		}
		return (flag>0)?account:null;
	}
	//根据账号id修改账号状态
	@Override
	public Account modifyStatus(Account account) throws SQLException{
		Connection conn=getConnection();
		String sql=UPDATE_STATUS;
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, account.getStatus());
		ps.setInt(2, account.getAccountId());
		int flag=ps.executeUpdate();
		
		return (flag>0)?account:null;
	}
}
