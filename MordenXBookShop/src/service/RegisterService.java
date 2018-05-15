package service;

import java.util.ArrayList;
import java.util.List;

import dao.RegisterDao;
import dao.UserInfoDao;
import models.UserInfoModel;

public class RegisterService {
	UserInfoDao userInfoDao=new UserInfoDao();
	RegisterDao registerDao=new RegisterDao();
	public boolean judgeExist(String name) {
		List<UserInfoModel> list=new ArrayList<>();
		try {
			list=userInfoDao.findByUserName(name);
			if(list.size()>0) return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean judgeScusse(Object...objs) {
		return registerDao.judgeScusse(objs);
		
	}
}
