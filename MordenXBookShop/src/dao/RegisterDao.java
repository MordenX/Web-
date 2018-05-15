package dao;
import java.sql.SQLException;
public class RegisterDao {
	private boolean judgeScusse;
	DBHelper dbHelper=new DBHelper<>();
	public boolean judgeScusse(Object...objs ) {
		int i=0;
		try {
			String sql="insert into userinfo(userEmail,userName,Password) values(?,?,?) ";
			i=dbHelper.executeInsert(sql, objs);
			if(i>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
