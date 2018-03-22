package com.tarena.netctoss;

import java.sql.SQLException;
import java.util.List;

import com.tarena.netctoss.entity.Account;

/**
 * 该接口定义了操作数据库的五种方法
 * @author cao
 *
 */
public interface AccountDAO {
/**
 * 根据某个账号id查询该账号全部信息
 * @param 账号id
 * @return 返回一个Account对象
 * @throws SQLException
 */
	Account findById(Integer id) throws SQLException;
	
	/**
	 * 查询全部账号信息
	 * @return List集合，泛型是一个Account对象
	 */
	List<Account> findAll() throws SQLException;
	
	/**
	 * 新增账号
	 * @param account 要添加的账号
	 * @return 要添加的账户账号
	 * @throws SQLException
	 */
	Account save(Account account) throws SQLException;
	
	/**
	 * 修改某个账号信息
	 * @param 要修改的账号account
	 * @return 修改后的账号
	 * @throws SQLException
	 */
	Account modify(Account account) throws SQLException;
	
	/**
	 * 修改某个账号的状态
	 * @param 要修改状态的账号
	 * @return 修改完状态后的账号
	 */
	Account modifyStatus(Account account) throws SQLException;
}
