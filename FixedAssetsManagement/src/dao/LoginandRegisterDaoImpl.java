package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Manager;
/**
 * 登录界面功能DaoImpl类
 * @author 任翀
 * 2016-7-14
 */
public class LoginandRegisterDaoImpl extends BaseDao implements LoginandRegisterDao{
	public int search(Manager manager)
	{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String name=manager.getName();
		String password=manager.getPassword();
		try{
			conn=this.getConnection();
			String sql="select * from Manager where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			if(rs.next()){
				return 1;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return 0;
	}

	public int find(Manager manager)
	{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String name=manager.getName();
		String password=manager.getPassword();
		try{
			conn=this.getConnection();
			String sql="select * from Manager where name=? and password=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			if(rs.next()){
				return 1;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return 0;
	}

	public int add(Manager manager)
	{
		String sql="insert into Manager(name,password) values(?,?)";
		Object[] param={manager.getName(),manager.getPassword()};
		int result=this.executeUpdate(sql, param);
		return result;
	}
}
