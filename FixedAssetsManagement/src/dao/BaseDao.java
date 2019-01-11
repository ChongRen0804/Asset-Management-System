package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库连接和关闭工具类
 * @author 任翀
 * 2016-7-13
 */
public class BaseDao {

	/**
	 * 获得数据库连接 返回一个Connection对象
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		// 声明一个Connection对象
		Connection conn = null;
		try {
			// 加载驱动
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
	 * 关闭数据库连接
	 * 
	 * @param conn
	 *            Connection
	 * @param stmt
	 *            Statement
	 * @param rs
	 *            ResultSet
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行增删改
	 * 
	 * @return 受影响的行数
	 */
	public int executeUpdate(String sql, Object[] param) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			// 设置参数
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject((i + 1), param[i]);
			}
			// 执行
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, pstmt, null);
		}
		return result;
	}
}
