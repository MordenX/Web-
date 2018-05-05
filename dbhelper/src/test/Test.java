package test;

import java.util.List;

import dao.TeacherDao;
import dao.UserInfoDao;
import models.TeacherModel;
import models.UserInfoModel;

public class Test {
	
	public static void main(String[] args) throws Exception {
		//≤‚ ‘≤È—Øuserinfo
		UserInfoDao userInfoDao =new UserInfoDao();
		List<UserInfoModel> list = userInfoDao.findAll();
		System.out.println(list.size());
		
		
		TeacherDao teacherDao =new TeacherDao();
		List<TeacherModel> list2=  teacherDao.findAll();
		System.out.println(list2.size());
	}
}
