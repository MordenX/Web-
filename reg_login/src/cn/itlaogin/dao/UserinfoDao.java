package cn.itlaogin.dao;

import java.sql.ResultSet;

import cn.itlaogin.models.UserinfoModel;

public class UserinfoDao {
	private DBHelper helper =new DBHelper();
	/**
	 * 保存用户
	 * @param model
	 * @return
	 */
	public int save(UserinfoModel model) throws Exception {
		int i=0;
		try {
			String sql ="INSERT INTO userinfo(userName,userPass)VALUES(?,?)";
			Object []values = new Object[] {model.getUserName(),model.getUserPass()};
			i = helper.executeUpdate(sql, values);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			helper.close();
		}
		return i;
	}
	/**
	 * 登录
	 * @param userName
	 * @param userPass
	 * @return 返回null表示错误的用户名或密码，否则用户名和密码正确
	 */
	public UserinfoModel findByUserNameAndUserPass(String userName,String userPass) throws Exception{
		UserinfoModel model = null;
		try {
			String sql ="SELECT * FROM userinfo WHERE userName=? AND userPass=?";
			Object []values = new Object[] {userName,userPass};
			ResultSet rs = helper.executeQuery(sql, values);
			if(rs.next()) {
				model = new UserinfoModel();//注意在if内部new UserinfoModel()
				model.setId(rs.getInt("id"));
				model.setUserName(rs.getString("userName"));
				model.setUserPass(rs.getString("userPass"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			helper.close();
		}
		return model;
	}
	/**
	 * 查询用户名是否存在
	 * @param userName
	 * @return
	 */
	public boolean existsByUsername(String userName) throws Exception{
		boolean exists = false;
		try {
			String sql ="SELECT * FROM userinfo WHERE userName=?";
			Object []values = new Object[] {userName};
			ResultSet rs = helper.executeQuery(sql, values);
			if(rs.next()) {
				exists=true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			helper.close();
		}
		return exists;
	}
	
}
