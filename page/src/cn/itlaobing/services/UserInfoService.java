package cn.itlaobing.services;

import java.sql.SQLException;
import java.util.List;

import cn.itlaobing.dao.UserInfoDao;
import cn.itlaobing.models.UserInfoModel;

public class UserInfoService {
	private UserInfoDao dao = new UserInfoDao();
	public List<UserInfoModel> findByPage(int pageIndex,int pageSize) throws Exception {
		return dao.findByPage(pageIndex,pageSize);
	}
	public int findByPageCount() throws SQLException {
		return dao.findByPageCount();
	}

}
