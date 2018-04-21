package cn.itlaobing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapper<T> {
	/**
	 * 将某一条数据记当转换为java实体对象
	 * @param rs 要转换的某条记录
	 * @return 返回转换后的对象
	 * @throws SQLException 方法可能会抛出异常 
	 * **/
   T rowMapper(ResultSet rs) throws SQLException;
}
