package com.mrkj.ygl.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The beauty of the code
 * 
 * @author yuguoliang
 *
 *         ����ģʽ����ʼ�������ݵ�����.
 */
public class DaoConnection {

	private static DaoConnection dc;

	private Connection JDBC����;

	private static final String ���ݿ�����·�� = "jdbc:mysql://127.0.0.1:3306/mrks";
	private static final String ���ݿ��û��� = "root";
	private static final String ���ݿ����� = "root";
	private static final String ���ݿ������� = "com.mysql.jdbc.Driver";

	// ˽�й��캯��
	private DaoConnection() {
	}

	// �����ڲ������������
	{
		try {
			Class.forName(���ݿ�������);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ʼ��
	public static DaoConnection initDaoConnection() {
		if (dc == null) {
			dc = new DaoConnection();
		}
		return dc;
	}

	/**
	 * @return the jDBC����
	 * @throws SQLException
	 */
	public Connection getJDBC����() throws SQLException {
		JDBC���� = DriverManager.getConnection(���ݿ�����·��, ���ݿ��û���, ���ݿ�����);
		return JDBC����;
	}

	public PreparedStatement getԤ����ִ��(String sql, Object... ��������) throws SQLException {

		DaoConnection dc = initDaoConnection();

		PreparedStatement ps = dc.getJDBC����().prepareStatement(sql);
		int i = 1;
		if (�������� != null & ��������.length > 0) {
			for (Object ���� : ��������) {
				ps.setObject(i, ����);
				i++;
			}
		}
		return ps;
	}

}