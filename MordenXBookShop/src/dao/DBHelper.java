
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mapper.IRowMapper;

public class DBHelper<T> {
    private PreparedStatement psmd;
    private ResultSet rs;
    private int rows=-1;
    private Connection conn;
    
    static{
 	   try{
 		   Class.forName("org.gjt.mm.mysql.Driver");
 	   }catch(ClassNotFoundException e){
 		   e.printStackTrace();
 		   System.out.println("注意：数据库驱动加载失败，请检查"
 		   		+ "项目中是否已经导入驱动jar或者驱动名称书写是正确！");
 	   }
    }
    /**
     * 获取数据库连接
     * @return 返回数据库连接对象
     * @ThrowS SQLException 此方法可能会抛出SQLException异常
     * */
    private void getConnection() throws SQLException{
    	if( conn == null || conn.isClosed()){
    	 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mordenxshop","root","root");
    	 }
    }
    /**
     * 关闭数据库连接
     * @param 要关闭的数据库连接对象
     * */
    public void  close(){
 	   try{
 		   if(rs!=null){
 			   rs.close();
 			   rs = null;
 		   }
 		   if(psmd !=null){
 			   psmd.close();
 			   psmd = null;
 		   }
 		   if(conn !=null && !conn.isClosed()){
 			   conn.close();
 			   conn=null;
 		   }
 	   }
 	   catch(SQLException ex){
 		   ex.printStackTrace();
 	   }
    }
    /**
     * 执行删，改的方法
     * @param conn 数据库连接对象
     * @param sql SQL语句
     * @param objs SQL语句中的参数
     * @return 返回执行的行数
     * @throws SQLException 方法可能会抛出异常
     * */
    public int executeSQL(String sql,Object...objs) throws SQLException{
    	getConnection();
    	//创建执行SQL语句的PreparedStatement对象
    	psmd=conn.prepareStatement(sql);
    	//给带占位符的SQL赋值
    	setParam(objs);
    	//执行SQL
    	rows=psmd.executeUpdate();
    	//返回执行结果
    	return rows;
    }
    
    /**
     * 执行Insert语句并返回新生成的主键ID的方法
     * @param sql SQL语句
     * @param objs SQL语句中的参数
     * @return 返回生成的主键值ID
     * @throws SQLException 方法可能会抛出异常
     * **/
    public int executeInsert(String sql,Object...objs) throws SQLException{
    	getConnection();
    	//创建执行SQL语句的PreparedStatement对象
    	psmd=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    	//给带占位符的SQL赋值
    	setParam(objs);
    	//执行SQL
    	rows=psmd.executeUpdate();
    	//获取生成的主键
    	rs=psmd.getGeneratedKeys();
    	//返回主键
    	if(rs.next()){
    		return rs.getInt(1);
    	}
    	//返回执行结果
    	return -1;
    }
    
    /**
     * 返回查询结果集
     * @param sql SQL语句
     * @param objs SQL语句中的参数
     * @return 返回生成的主键值ID
     * @throws SQLException 方法可能会抛出异常
     * **/
    /*public ResultSet executeQuery(String sql,Object...objs) throws SQLException{
    	getConnection();
    	//创建执行SQL语句的PreparedStatement对象
    	psmd=conn.prepareStatement(sql);
    	//给带占位符的SQL赋值
    	setParam(objs);
    	//执行SQL
    	rs=psmd.executeQuery();
    	return rs;
    }
    */
    
    public List<T> executeQuery(String sql,IRowMapper<T> mapper,Object...objs) throws SQLException{
    	getConnection();
    	//创建执行SQL语句的PreparedStatement对象
    	psmd=conn.prepareStatement(sql);
    	//给带占位符的SQL赋值
    	setParam(objs);
    	//执行SQL
    	rs=psmd.executeQuery();
    	//创建 List集合
    	List<T> list  = new ArrayList<T>();
    	list.clear();
    	while(rs.next()){
    		T t = mapper.rowMapper(rs);
    		list.add(t);
    	}
    	return list;
    }
    
    /**
     * 给psmd预编译的参数赋值
     * @param objs 参数列表
     * @throws SQLException 方法可能会抛出异常
     * */
    private void setParam(Object...objs) throws SQLException{
    	if(objs!=null && objs.length>0){
    		for (int i = 0; i < objs.length; i++) {
    			psmd.setObject(i+1, objs[i]);
			}
    	}
    }
    /**
     * 执行聚合函数查询
     * */
	public Object executeScalar(String sql, Object... objs) throws SQLException {
		getConnection();
    	//创建执行SQL语句的PreparedStatement对象
    	psmd=conn.prepareStatement(sql);
    	//给带占位符的SQL赋值
    	setParam(objs);
    	//执行SQL
    	rs=psmd.executeQuery();
    	
    	Object object=null;
    	if(rs.next()){
    		object = rs.getObject(1);
    	}
    	return object;
	}
}
