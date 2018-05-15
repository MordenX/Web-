package dao;

import java.util.ArrayList;
import java.util.List;

import mapper.BookInfoMapper;
import models.BookInfoModel;

public class BookInfoDao {
	DBHelper dbHelper=new DBHelper();
	List<BookInfoModel> list =new ArrayList<>();
	@SuppressWarnings("unchecked")
	public List<BookInfoModel> findByType(Object...objs) throws Exception{
		try {
			String sql ="select * from bookinfo where booktype=?";
			list = dbHelper.executeQuery(sql, new BookInfoMapper(), objs);
		} catch (Exception e) {
			throw e;
		}
		finally {
			dbHelper.close();
		}
		return list;
	} 
	
	
}
