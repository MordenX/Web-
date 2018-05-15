package service;

import java.util.List;

import dao.BookInfoDao;
import models.BookInfoModel;

public class GetBookInfoService {
	BookInfoDao bookInfoDao=new BookInfoDao();
	public List<BookInfoModel> getBookInfo(String type) throws Exception {
			return bookInfoDao.findByType(type);
	}
}
