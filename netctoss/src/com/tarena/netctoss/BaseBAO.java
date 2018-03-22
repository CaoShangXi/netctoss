package com.tarena.netctoss;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * ��װ�˴������ݿ����ӷ����Լ�����
 * @author cao
 *
 */
public class BaseBAO {
	private static BasicDataSource dataSource=null;
	public static Properties properties=new Properties();
	//��ʼ�����ݿ�����
	public static void init(){
		Properties dbProps=new Properties();
		//����db.properties�ļ�
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
		//��ʼ������
		if(initialSize!=null){
			dataSource.setInitialSize(Integer.parseInt(initialSize));
		}
		//����������
		if(maxIdle!=null){
			dataSource.setMaxIdle(Integer.parseInt(maxIdle));
		}
		//��С��������
		if(minIdle!=null){
			dataSource.setMinIdle(Integer.parseInt(minIdle));
		}
		//���������
		if(maxActive!=null){
			dataSource.setMaxActive(Integer.parseInt(maxActive));
		}
		//��ʱ����ʱ��(�Ժ���Ϊ��λ)
		if(maxWait!=null){
			if(!maxWait.equals("0")){
				dataSource.setMaxWait(Integer.parseInt(maxWait));
			}
		}
		} catch (IOException e) {
			System.out.println("�������ӳ�ʧ�ܣ��������ã�");
			throw new RuntimeException(e);
		}
	}
	//�����ݿ�����
	public static synchronized Connection getConnection(){
		Connection conn=null;
			init();
		try {
				conn=dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
			throw new RuntimeException(e);
		}
		return conn;
	}
	//��������
	public static void begin(){
		//��ȡ����
		Connection conn=BaseBAO.getConnection();
		try {
			if(conn!=null){
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			System.out.println("��������ʧ��!");
			e.printStackTrace();
		}
		
	}
	//�ύ����
	public static void commit(){
		//��ȡ����
		Connection conn=BaseBAO.getConnection();
		try {
			if(conn!=null){
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("�ύ����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	//�ع�����
	public static void rollBack(){
		//��ȡ����
		Connection conn=BaseBAO.getConnection();
		try {
			if(conn!=null){
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("�ع�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
