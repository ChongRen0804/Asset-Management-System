package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * ���ݿ����Ӻ͹رչ�����
 * @author ����
 * 2016-7-13
 */
public class BaseDao {

	/**
	 * ������ݿ����� ����һ��Connection����
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		// ����һ��Connection����
		Connection conn = null;
		try {
			// ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DataBaseName = FixedAssetsManagement", "maintest",
					"maintest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @param conn
	 *            Connection
	 * @param stmt
	 *            Statement
	 * @param rs
	 *            ResultSet
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// �����������Ϊ�գ���ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// ��Statement����Ϊ�գ���ر�
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ִ����ɾ��
	 * 
	 * @return ��Ӱ�������
	 */
	public int executeUpdate(String sql, Object[] param) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			// ���ò���
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject((i + 1), param[i]);
			}
			// ִ��
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, null);
		}
		return result;
	}
}
