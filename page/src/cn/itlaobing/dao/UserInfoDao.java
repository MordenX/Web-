package cn.itlaobing.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itlaobing.mapper.impl.UserinfoMapper;
import cn.itlaobing.models.UserInfoModel;

public class UserInfoDao {
	DBHelper<UserInfoModel> dbhelper = new DBHelper<UserInfoModel>();

	/**
	 * 
	 * @param pageIndex ��ǰ��ѯ�ڼ�ҳ
	 * @param pageSize ÿҳ��¼����
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoModel> findByPage(int pageIndex,int pageSize) throws Exception {
		try {
			String sql = "select * from userinfo limit " + (pageIndex-1)*pageSize +"," + pageSize;
			return dbhelper.executeQuery(sql, new UserinfoMapper(), null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			dbhelper.close();
		}
	}

	public int findByPageCount() throws SQLException {
		try {
			String sql = "select count(*) from userinfo";
			Object obj = dbhelper.executeScalar(sql,null);
			if(obj!=null) {
				return Integer.parseInt(obj.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			dbhelper.close();
		}
		return 0;
	}

}
