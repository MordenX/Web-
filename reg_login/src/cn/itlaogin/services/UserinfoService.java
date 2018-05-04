package cn.itlaogin.services;

import java.sql.ResultSet;

import cn.itlaogin.dao.UserinfoDao;
import cn.itlaogin.models.UserinfoModel;

public class UserinfoService {
	private UserinfoDao userinfoDao =new UserinfoDao();
	/**
	 * 保存用户
	 * @param model
	 * @return -1表示用户名已经存在
	 */
	public int save(UserinfoModel model) throws Exception {
		/*
		 * 注册的业务流程
		 * 1：验证用户名是否存在
		 * 2:注册
		 * */
		boolean exists = userinfoDao.existsByUsername(model.getUserName());
		if(exists==false) {
			return userinfoDao.save(model);
		}else {
			return -1;
		}
	}
	/**
	 * 登录
	 * @param userName
	 * @param userPass
	 * @return 返回null表示错误的用户名或密码，否则用户名和密码正确
	 */
	public UserinfoModel findByUserNameAndUserPass(String userName,String userPass) throws Exception{
		return userinfoDao.findByUserNameAndUserPass(userName, userPass);
	}
}
