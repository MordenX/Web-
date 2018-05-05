package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.TeacherModel;

public class TeacherMapper implements IRowMapper<TeacherModel>{

	@Override
	public TeacherModel rowMapper(ResultSet rs) throws SQLException {
		TeacherModel teacherModel =new TeacherModel();
		teacherModel.setId(rs.getInt("id"));
		teacherModel.setName(rs.getString("name"));
		return teacherModel;
	}

}
