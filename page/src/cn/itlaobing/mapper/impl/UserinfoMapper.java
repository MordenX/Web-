package cn.itlaobing.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itlaobing.mapper.IRowMapper;
import cn.itlaobing.models.UserInfoModel;

public class UserinfoMapper implements IRowMapper<UserInfoModel> {

	@Override
	public UserInfoModel rowMapper(ResultSet rs) throws SQLException {
		UserInfoModel userInfoModel = new UserInfoModel();
		try {
			userInfoModel.setId(rs.getInt("id"));
			userInfoModel.setUsername(rs.getString("username"));
			userInfoModel.setUserpass(rs.getString("userpass"));
			userInfoModel.setAge(rs.getInt("age"));
			userInfoModel.setProvince(rs.getString("province"));
			userInfoModel.setGender(rs.getString("gender"));
			userInfoModel.setHobby(rs.getString("hobby"));
			userInfoModel.setBirthday(rs.getObject("birthday")==null ? null: rs.getTimestamp("birthday"));
			userInfoModel.setImgurl(rs.getString("imgurl"));
			userInfoModel.setReg_date(rs.getObject("reg_date")==null ? null: rs.getTimestamp("reg_date"));
		
		} catch (Exception e) {
			e.printStackTrace();
			userInfoModel = null;
		}
		return userInfoModel;
	}

}
