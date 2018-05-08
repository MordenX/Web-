package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapper<T> {
	public abstract T rowMapper(ResultSet rs) throws SQLException;
}
