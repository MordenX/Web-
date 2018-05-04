package cn.itlaogin.services;

import java.sql.ResultSet;

import cn.itlaogin.dao.UserinfoDao;
import cn.itlaogin.models.UserinfoModel;

public class UserinfoService {
	private UserinfoDao userinfoDao =new UserinfoDao();
	/**
	 * �����û�
	 * @param model
	 * @return -1��ʾ�û����Ѿ�����
	 */
	public int save(UserinfoModel model) throws Exception {
		/*
		 * ע���ҵ������
		 * 1����֤�û����Ƿ����
		 * 2:ע��
		 * */
		boolean exists = userinfoDao.existsByUsername(model.getUserName());
		if(exists==false) {
			return userinfoDao.save(model);
		}else {
			return -1;
		}
	}
	/**
	 * ��¼
	 * @param userName
	 * @param userPass
	 * @return ����null��ʾ������û��������룬�����û�����������ȷ
	 */
	public UserinfoModel findByUserNameAndUserPass(String userName,String userPass) throws Exception{
		return userinfoDao.findByUserNameAndUserPass(userName, userPass);
	}
}
