package cn.itlaobing.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapper<T> {
	/**
	 * ��ĳһ�����ݼǵ�ת��Ϊjavaʵ�����
	 * @param rs Ҫת����ĳ����¼
	 * @return ����ת����Ķ���
	 * @throws SQLException �������ܻ��׳��쳣 
	 * **/
   T rowMapper(ResultSet rs) throws SQLException;
}
