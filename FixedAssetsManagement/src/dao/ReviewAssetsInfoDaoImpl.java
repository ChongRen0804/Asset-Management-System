package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import entity.Asset;
import entity.bigClass;
import entity.smallClass;
/**
 * 资产信息浏览与查询的数据库实现
 * @author 刘鹏鑫
 * 2016-7-15
 */
public class ReviewAssetsInfoDaoImpl extends BaseDao implements ReviewAssetsInfoDao{
	public List<bigClass> showbigClass() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		bigClass bigclass=null;
		List<bigClass> bigclasses=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from bigClass";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				bigclass=new bigClass();
				bigclass.setId(rs.getInt("id"));
				bigclass.setBigclassname(rs.getString("bigClassName"));
				bigclasses.add(bigclass);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return bigclasses;
	}
	public List<smallClass> showsmallClass(int bigClassID) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		smallClass smallclass=null;
		List<smallClass> smallclasses=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from smallClass where bigClassID=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,bigClassID);
			rs=psmt.executeQuery();
			while(rs.next()){
				smallclass=new smallClass();
				smallclass.setId(rs.getInt("id"));
				smallclass.setSmallclassname(rs.getString("smallClassName"));
				smallclasses.add(smallclass);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return smallclasses;
	}
	public List<Asset> showAssets(String smallClassName) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Asset asset=null;
		List<Asset> assets=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from AssetsInfo where type=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,smallClassName);
			rs=psmt.executeQuery();
			while(rs.next()){
				asset=new Asset();
				asset.setId(rs.getInt("id"));
				asset.setName(rs.getString("name"));
				asset.setType(rs.getString("type"));
				asset.setModel(rs.getString("model"));
				asset.setValue(rs.getFloat("value"));
				asset.setPurchaseDate(rs.getString("purchaseDate"));
				asset.setState(rs.getString("state"));
				asset.setUserName(rs.getString("userName"));
				asset.setRemark(rs.getString("remark"));
				assets.add(asset);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return assets;
	}
	public Asset searchID(int id) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Asset asset=null;
		try{
			conn=this.getConnection();
			String sql="select * from AssetsInfo where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,id);
			rs=psmt.executeQuery();
			while(rs.next()){
				asset=new Asset();
				asset.setId(rs.getInt("id"));
				asset.setName(rs.getString("name"));
				asset.setType(rs.getString("type"));
				asset.setModel(rs.getString("model"));
				asset.setValue(rs.getFloat("value"));
				asset.setPurchaseDate(rs.getString("purchaseDate"));
				asset.setState(rs.getString("state"));
				asset.setUserName(rs.getString("userName"));
				asset.setRemark(rs.getString("remark"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return asset;
	}
	public List<Asset> searchType(String type) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Asset asset=null;
		List<Asset> assets=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from AssetsInfo where type=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,type);
			rs=psmt.executeQuery();
			while(rs.next()){
				asset=new Asset();
				asset.setId(rs.getInt("id"));
				asset.setName(rs.getString("name"));
				asset.setType(rs.getString("type"));
				asset.setModel(rs.getString("model"));
				asset.setValue(rs.getFloat("value"));
				asset.setPurchaseDate(rs.getString("purchaseDate"));
				asset.setState(rs.getString("state"));
				asset.setUserName(rs.getString("userName"));
				asset.setRemark(rs.getString("remark"));
				assets.add(asset);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return assets;
	}
	public List<Asset> searchUser(String userName) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Asset asset=null;
		List<Asset> assets=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from AssetsInfo where userName=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,userName);
			rs=psmt.executeQuery();
			while(rs.next()){
				asset=new Asset();
				asset.setId(rs.getInt("id"));
				asset.setName(rs.getString("name"));
				asset.setType(rs.getString("type"));
				asset.setModel(rs.getString("model"));
				asset.setValue(rs.getFloat("value"));
				asset.setPurchaseDate(rs.getString("purchaseDate"));
				asset.setState(rs.getString("state"));
				asset.setUserName(rs.getString("userName"));
				asset.setRemark(rs.getString("remark"));
				assets.add(asset);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(conn, psmt, rs);
		}
		return assets;
	}
}
