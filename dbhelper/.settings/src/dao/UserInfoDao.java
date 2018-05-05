package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mapper.UserInfoMapper;
import models.UserInfoModel;

public class UserInfoDao {
	private DBHelper helper =new DBHelper();
	
	public List<UserInfoModel> findAll() throws Exception{
		List<UserInfoModel> list =new ArrayList<UserInfoModel>();
		try {
			String sql ="select * from userinfo";
			list = helper.executeQuery1(sql, new UserInfoMapper(), null);
		} catch (Exception e) {
			throw e;
		}
		finally {
			helper.close();
		}
		return list;
	}
}
