package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mapper.TeacherMapper;
import models.TeacherModel;

public class TeacherDao {
	private DBHelper<TeacherModel> helper =new DBHelper();
	
	public List<TeacherModel> findAll() throws Exception{
		List<TeacherModel> list =new ArrayList<>();
		try {
			String sql ="select * from teacher";
			list = helper.executeQuery1(sql,new TeacherMapper(),null);
		} catch (Exception e) {
			throw e;
		}finally {
			helper.close();
		}
		return list;
	}
}
