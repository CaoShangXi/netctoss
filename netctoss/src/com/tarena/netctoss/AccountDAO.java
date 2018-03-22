package com.tarena.netctoss;

import java.sql.SQLException;
import java.util.List;

import com.tarena.netctoss.entity.Account;

/**
 * �ýӿڶ����˲������ݿ�����ַ���
 * @author cao
 *
 */
public interface AccountDAO {
/**
 * ����ĳ���˺�id��ѯ���˺�ȫ����Ϣ
 * @param �˺�id
 * @return ����һ��Account����
 * @throws SQLException
 */
	Account findById(Integer id) throws SQLException;
	
	/**
	 * ��ѯȫ���˺���Ϣ
	 * @return List���ϣ�������һ��Account����
	 */
	List<Account> findAll() throws SQLException;
	
	/**
	 * �����˺�
	 * @param account Ҫ��ӵ��˺�
	 * @return Ҫ��ӵ��˻��˺�
	 * @throws SQLException
	 */
	Account save(Account account) throws SQLException;
	
	/**
	 * �޸�ĳ���˺���Ϣ
	 * @param Ҫ�޸ĵ��˺�account
	 * @return �޸ĺ���˺�
	 * @throws SQLException
	 */
	Account modify(Account account) throws SQLException;
	
	/**
	 * �޸�ĳ���˺ŵ�״̬
	 * @param Ҫ�޸�״̬���˺�
	 * @return �޸���״̬����˺�
	 */
	Account modifyStatus(Account account) throws SQLException;
}
