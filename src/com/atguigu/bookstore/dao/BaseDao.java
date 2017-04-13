package com.atguigu.bookstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.bookstore.utils.JDBCUtils;

/**
 * ����һ���������̳еĶ����ݿ���л���������Dao
 * 
 * @author HanYanBing
 *
 * @param <T>
 */
public class BaseDao<T> {
	private QueryRunner queryRunner = new QueryRunner();
	//����һ�����������շ��͵�����
	private Class<T> type;
	// ��ȡT��Class���󣬻�ȡ���͵����ͣ��������ڱ�����̳�ʱ��ȷ��
	public BaseDao() {
		//��ȡ���������
		Class clazz = this.getClass();
		//��ȡ���������
		//getGenericSuperclass()������ȡ��ǰ��ĸ��������
		//ParameterizedType��ʾ���Ǵ����͵�����
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		//��ȡ����ķ������� getActualTypeArguments��ȡ����ķ��͵�����
		//��������᷵��һ��Type������
		Type[] types = parameterizedType.getActualTypeArguments();
		//��ȡ����ķ��͵����͡�
		this.type = (Class<T>) types[0];
	}
	
	/**
	 * ͨ�õ���ɾ�Ĳ���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		// ��ȡ����
		Connection connection = JDBCUtils.getConnection();
		int count = 0;
		try {
			count = queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		return count;
	}

	/**
	 * ��ȡһ������
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql, Object... params) {
		// ��ȡ����
		Connection connection = JDBCUtils.getConnection();
		T t = null;
		try {
			t = queryRunner.query(connection, sql, new BeanHandler<T>(type),params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		return t;
	}

	/**
	 * ��ȡ���ж���
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql, Object... params) {
		// ��ȡ����
		Connection connection = JDBCUtils.getConnection();
		List<T> list = null;
		try {
			list = queryRunner.query(connection, sql, new BeanListHandler<T>(
					type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		return list;
	}
	public Object getSingleValue(String sql,Object...params){
		Connection connection = JDBCUtils.getConnection();
		Object count=null;
		try {
			count = queryRunner.query(connection,sql,new ScalarHandler(),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
