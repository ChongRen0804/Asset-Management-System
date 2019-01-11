package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Person;
/**
 * 人员管理的数据库操作
 * @author 刘鹏鑫
 * 2016-7-13
 */
public class PersonInfoManageDaoImpl extends BaseDao implements PersonInfoManageDao{
	public int add(Person per) {
		String sql="insert into PersonInfo(name,position,remark) values(?,?,?)";
		Object[] param={per.getName(),per.getPosition(),per.getRemark()};
		int result=this.executeUpdate(sql, param);
		return result;
	}
	public int del(Person per) {
		String sql="delete from PersonInfo where name=?";
		Object[] param={per.getName()};
		int result=this.executeUpdate(sql, param);
		return result;
	}
	public int edit(Person per) {
		String sql="update PersonInfo set position=?,remark=? where name=?";
		Object[] param={per.getPosition(),per.getRemark(),per.getName()};
		int result=this.executeUpdate(sql, param);
		return result;
	}
	public Person findByName(String name) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Person per=null;
		try{
			conn=this.getConnection();
			String sql="select * from PersonInfo where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			while(rs.next()){
				per=new Person();
				per.setId(rs.getInt("id"));
				per.setName(rs.getString("name"));
				per.setPosition(rs.getString("position"));
				per.setRemark(rs.getString("remark"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return per;
	}
	public List<Person> showAll() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Person per=null;
		List<Person> person=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from PersonInfo";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				per=new Person();
				per.setId(rs.getInt("id"));
				per.setName(rs.getString("name"));
				per.setPosition(rs.getString("position"));
				per.setRemark(rs.getString("remark"));
				person.add(per);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return person;
	}
}
