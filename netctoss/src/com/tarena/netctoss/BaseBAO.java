package com.tarena.netctoss;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 封装了创建数据库连接方法以及事务
 * @author cao
 *
 */
public class BaseBAO {
	private static BasicDataSource dataSource=null;
	public static Properties properties=new Properties();
	//初始化数据库连接
	public static void init(){
		Properties dbProps=new Properties();
		//加载db.properties文件
		try {
			dbProps.load(BaseBAO.class.getResourceAsStream("db.properties"));
		
		String driver=dbProps.getProperty("jdbc.driver");
		String url=dbProps.getProperty("jdbc.url");
		String user=dbProps.getProperty("jdbc.user");
		String password=dbProps.getProperty("jdbc.password");
		String initialSize=dbProps.getProperty("dataSource.initialSize");
		String maxIdle=dbProps.getProperty("dataSource.maxIdle");
		String minIdle=dbProps.getProperty("dataSource.minIdle");
		String maxActive=dbProps.getProperty("dataSource.maxActive");
		String maxWait=dbProps.getProperty("dataSource.maxWait");
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		//初始化连接
		if(initialSize!=null){
			dataSource.setInitialSize(Integer.parseInt(initialSize));
		}
		//最大空闲连接
		if(maxIdle!=null){
			dataSource.setMaxIdle(Integer.parseInt(maxIdle));
		}
		//最小空闲连接
		if(minIdle!=null){
			dataSource.setMinIdle(Integer.parseInt(minIdle));
		}
		//最大连接数
		if(maxActive!=null){
			dataSource.setMaxActive(Integer.parseInt(maxActive));
		}
		//超时回收时间(以毫秒为单位)
		if(maxWait!=null){
			if(!maxWait.equals("0")){
				dataSource.setMaxWait(Integer.parseInt(maxWait));
			}
		}
		} catch (IOException e) {
			System.out.println("创建连接池失败，请检查设置！");
			throw new RuntimeException(e);
		}
	}
	//与数据库连接
	public static synchronized Connection getConnection(){
		Connection conn=null;
			init();
		try {
				conn=dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("连接数据库失败！");
			throw new RuntimeException(e);
		}
		return conn;
	}
	//开启事务
	public static void begin(){
		//获取连接
		Connection conn=BaseBAO.getConnection();
		try {
			if(conn!=null){
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			System.out.println("开启事务失败!");
			e.printStackTrace();
		}
		
	}
	//提交事务
	public static void commit(){
		//获取连接
		Connection conn=BaseBAO.getConnection();
		try {
			if(conn!=null){
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("提交事务失败！");
			e.printStackTrace();
		}
	}
	//回滚事务
	public static void rollBack(){
		//获取连接
		Connection conn=BaseBAO.getConnection();
		try {
			if(conn!=null){
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("回滚事务失败！");
			e.printStackTrace();
		}
	}
}
