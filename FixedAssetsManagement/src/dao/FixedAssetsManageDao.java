package dao;
import java.util.List;

import entity.Asset;
import entity.bigClass;
import entity.smallClass;
/**
 * 固定资产管理Dao类
 * @author 任翀
 * 2016-7-15
 */
public interface FixedAssetsManageDao {
	List<bigClass> getBigclass();
	List<smallClass> getSmallclass();
	List<Asset> getAsset();
	public int addBigClass(bigClass bc);
	public int addSmallClass(smallClass sc);
	public int addAsset(Asset as);
	public smallClass findBySmallName(String name);
	public bigClass findByBigName(String name);
	public Asset findByAssetName(String name);
	public int delBigClass(bigClass bc);
	public int delSmallClass(smallClass sc);
	public int delAs(Asset as);
	public int editAsset(Asset as);
}
