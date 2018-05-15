package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.BookInfoModel;

public class BookInfoMapper implements IRowMapper<BookInfoModel> {
	@Override
	public BookInfoModel rowMapper(ResultSet rs) throws SQLException {
		BookInfoModel bookInfoModel=new BookInfoModel();
		bookInfoModel.setBookName(rs.getString("bookname"));
		bookInfoModel.setBookType(rs.getString("booktype"));
		bookInfoModel.setBookStatus(rs.getString("bookstatus"));
		bookInfoModel.setBookPrice(rs.getDouble("bookprice"));
		bookInfoModel.setBookImage(rs.getString("bookimg"));
		return bookInfoModel;
	}


}
