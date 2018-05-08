package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mapper.UserInfoMapper;
import models.UserInfoModel;

@SuppressWarnings("unused")
public class UserInfoDao {
	private DBHelper dbhelper =new DBHelper();
	List<UserInfoModel> list =new ArrayList<>();
	@SuppressWarnings("unchecked")
	public List<UserInfoModel> findByUserNameAndPassword(Object...objs) throws Exception{
		try {
			String sql ="select * from userinfo where username=? and password=?";
			list = dbhelper.executeQuery(sql, new UserInfoMapper(), objs);
		} catch (Exception e) {
			throw e;
		}
		finally {
			dbhelper.close();
		}
		return list;
	}
	
	public List<UserInfoModel> findByUserName(Object...objs) throws Exception{
		try {
			String sql ="select * from user where username=?";
			list = dbhelper.executeQuery(sql, new UserInfoMapper(), objs);
		} catch (Exception e) {
			throw e;
		}
		finally {
			dbhelper.close();
		}
		return list;
	}
	
	public List<UserInfoModel> findAll(Object...objs) throws Exception{
		try {
			String sql ="select * from user";
			list = dbhelper.executeQuery(sql, new UserInfoMapper(), objs);
		} catch (Exception e) {
			throw e;
		}
		finally {
			dbhelper.close();
		}
		return list;
	}
}
