package service;

import java.util.ArrayList;
import java.util.List;

import dao.UserInfoDao;
import mapper.UserInfoMapper;
import models.UserInfoModel;
public class LoginSrevice {
	public List<UserInfoModel> findByUserNameAndPassword(Object...objs) throws Exception{
		UserInfoDao userInfoDao=new UserInfoDao();
		return userInfoDao.findByUserNameAndPassword(objs);
	}
}
