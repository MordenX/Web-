package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.UserInfoModel;

public class UserInfoMapper implements IRowMapper<UserInfoModel>{

	@Override
	public UserInfoModel rowMapper(ResultSet rs) throws SQLException {
		UserInfoModel userInfoModel =new UserInfoModel();
		userInfoModel.setId(rs.getInt("id"));
		userInfoModel.setUsername(rs.getString("username"));
		userInfoModel.setUserpass(rs.getString("password"));
		return userInfoModel;
	}

}
