package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.AdoptandReturnInfo;
import entity.Person;
/**
 * 资产领用与归还的数据库操作
 * @author 刘鹏鑫
 * 2016-7-15
 */
public class AdoptandReturnDaoImpl extends BaseDao implements AdoptandReturnDao{
	public boolean isRegister(String adoptName) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Person per=null;
		try{
			conn=this.getConnection();
			String sql="select * from PersonInfo where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,adoptName);
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
		if(per!=null)
			return true;
		return false;
	}
	public int add(int id, String date, String name, String purpose, String remark) {
		String sql1="delete from AdoptandReturn where equipmentID=?";
		Object[] param1={id};
		int result=this.executeUpdate(sql1, param1);
		String sql2="insert into AdoptandReturn(equipmentID,adoptDate,adoptManager,purpose,remark) values(?,?,?,?,?)";
		Object[] param2={id,date,name,purpose,remark};
		result=this.executeUpdate(sql2, param2);
		return result;
	}
	public int update(int id, String adoptName) {
		String sql="update AssetsInfo set userName=? where id=?";
		Object[] param={adoptName,id};
		int result=this.executeUpdate(sql, param);
		return result;
	}
	public int updateadd(int id, String date, String name) {
		String sql="update AdoptandReturn set returnDate=?,returnManager=? where equipmentID=?";
		Object[] param={date,name,id};
		int result=this.executeUpdate(sql, param);
		return result;
	}
	public int updatedel(int id) {
		String sql="update AssetsInfo set userName=? where id=?";
		Object[] param={null,id};
		int result=this.executeUpdate(sql, param);
		return result;
	}
	public List<AdoptandReturnInfo> showAllAdoptReturn() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		AdoptandReturnInfo AaRI=null;
		List<AdoptandReturnInfo> AaRIs=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from AdoptandReturn";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				AaRI=new AdoptandReturnInfo();
				AaRI.setId(rs.getInt("id"));
				AaRI.setEquipmentID(rs.getInt("equipmentID"));
				AaRI.setAdoptDate(rs.getString("adoptDate"));
				AaRI.setAdoptManager(rs.getString("adoptManager"));
				AaRI.setPurpose(rs.getString("purpose"));
				AaRI.setRemark(rs.getString("remark"));
				AaRI.setReturnDate(rs.getString("returnDate"));
				AaRI.setReturnManager(rs.getString("returnManager"));
				AaRIs.add(AaRI);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return AaRIs;
	}
}
