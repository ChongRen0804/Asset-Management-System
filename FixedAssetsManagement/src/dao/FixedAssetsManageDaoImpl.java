package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Asset;
import entity.bigClass;
import entity.smallClass;
/**
 * 固定资产管理DaoImpl类
 * @author 任翀
 * 2016-7-15
 */
public class FixedAssetsManageDaoImpl extends BaseDao implements FixedAssetsManageDao{
	private Connection conn=null;
	private PreparedStatement psmt=null;
	private ResultSet rs=null;
	public List<bigClass> getBigclass() {
		bigClass bc=null;
		List<bigClass> lb=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from BigClass";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				bc=new bigClass();
				bc.setId(rs.getInt("id"));
				bc.setBigclassname(rs.getString("bigClassName"));
				lb.add(bc);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return lb;
	}

	public List<smallClass> getSmallclass() {
		smallClass sc=null;
		List<smallClass> lb=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from SmallClass";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				sc=new smallClass();
				sc.setId(rs.getInt("id"));
				sc.setSmallclassname(rs.getString("smallClassName"));
				sc.setBigclassID(rs.getInt("bigClassID"));
				lb.add(sc);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return lb;
	}

	public List<Asset> getAsset()
	{
		Asset as=null;
		List<Asset> la=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from AssetsInfo";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				as=new Asset();
				as.setId(rs.getInt("id"));
				as.setName(rs.getString("name"));
				as.setType(rs.getString("type"));
				as.setModel(rs.getString("model"));
				as.setValue(rs.getFloat("value"));
				as.setPurchaseDate(rs.getString("purchaseDate"));
				as.setState(rs.getString("state"));
				as.setUserName(rs.getString("userName"));
				as.setRemark(rs.getString("remark"));
				la.add(as);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return la;
	}

	public int addBigClass(bigClass bc)
	{
		String sql="insert into BigClass(bigClassName) values(?)";
		Object[] param={bc.getBigclassname()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public int addSmallClass(smallClass sc)
	{
		String sql="insert into SmallClass(smallClassName,bigClassID) values(?,?)";
		Object[] param={sc.getSmallclassname(),sc.getBigclassID()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public int addAsset(Asset as)
	{
		String sql="insert into AssetsInfo(name,type,model,value,purchaseDate,state,userName,remark) values(?,?,?,?,?,?,?,?)";
		Object[] param={as.getName(),as.getType(),as.getModel(),as.getValue(),as.getPurchaseDate(),as.getState(),as.getUserName(),as.getRemark()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public smallClass findBySmallName(String name)
	{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		smallClass sc=null;
		try{
			conn=this.getConnection();
			String sql="select * from SmallClass where smallClassName=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			while(rs.next()){
				sc=new smallClass();
				sc.setId(rs.getInt("id"));
				sc.setSmallclassname(rs.getString("smallClassName"));
				sc.setBigclassID(rs.getInt("bigClassID"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return sc;
	}

	public bigClass findByBigName(String name)
	{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		bigClass bc=null;
		try{
			conn=this.getConnection();
			String sql="select * from BigClass where bigClassName=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			while(rs.next()){
				bc=new bigClass();
				bc.setId(rs.getInt("id"));
				bc.setBigclassname(rs.getString("smallClassName"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return bc;
	}

	public Asset findByAssetName(String name)
	{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Asset as=null;
		try{
			conn=this.getConnection();
			String sql="select * from AssetsInfo where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			while(rs.next()){
				as=new Asset();
				as.setId(rs.getInt("id"));
				as.setName(rs.getString("name"));
				as.setType(rs.getString("type"));
				as.setModel(rs.getString("model"));
				as.setValue(rs.getFloat("value"));
				as.setPurchaseDate(rs.getString("purchaseDate"));
				as.setState(rs.getString("state"));
				as.setUserName(rs.getString("userName"));
				as.setRemark(rs.getString("remark"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return as;
	}

	public int delBigClass(bigClass bc)
	{
		String sql="delete from BigClass where bigClassName=?";
		Object[] param={bc.getBigclassname()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public int delSmallClass(smallClass sc)
	{
		String sql="delete from SmallClass where smallClassName=?";
		Object[] param={sc.getSmallclassname()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public int editAsset(Asset as)
	{
		String sql="update AssetsInfo set type=?,model=?,value=?,purchaseDate=?,state=?,userName=?,remark=? where name=?";
		Object[] param={as.getType(),as.getModel(),as.getValue(),as.getPurchaseDate(),as.getState(),as.getUserName(),as.getRemark(),as.getName()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public int delAs(Asset as)
	{
		String sql="delete from AssetsInfo where name=?";
		Object[] param={as.getName()};
		int result=this.executeUpdate(sql, param);
		return result;
	}
}
