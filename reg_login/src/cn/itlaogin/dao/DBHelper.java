package cn.itlaogin.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 该类的作用是执行sql语句
 * 该类必须通用，通用是指对所有的表的sql语句都能够执行
 */
public class DBHelper {
	//定义属性
	private Connection connection = null;
	private PreparedStatement statement =null;
	private ResultSet rs = null;
	private static String URL="jdbc:mysql://localhost:3306/xbmu";
	private static String USER="root";
	private static String PASS="root";//硬编码
	
	//静态块加载驱动，只加载一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//加载数据库的配置文件
	static{
		try {
			File file =new File("c:/db.properties");
			FileInputStream inStream =new FileInputStream(file);
			//Properties是键值对的集合类，父接口是Map
			Properties prop = new Properties();
			prop.load(inStream);
			URL = (String)prop.get("url");
			USER = (String)prop.get("user");
			PASS = (String)prop.get("pass");
		} catch (IOException e) {
			System.out.println("数据库配置文件加载失败，请停止所有的操作，检查数据库配置文件");
		}
	}
	
	/**
	 * 初始化连接对象
	 */
	private void initConnection(){
		try {
			if(connection==null || connection.isClosed()==true){
				connection = DriverManager.getConnection(URL,USER,PASS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//sql=insert into user(username,userpass)values(?,?)
	//values=["admin","123"]
	/**
	 * 执行添加，删除，修改的语句
	 * @param sql 被执行的sql语句
	 * @param values sql语句中占位符的值
	 * @return 返回影响的行数
	 * @throws SQLException 
	 */
	public int executeUpdate(String sql,Object ...values) throws SQLException{
		//创建连接对象
		initConnection();
		//创建执行sql语句的对象
		statement = connection.prepareStatement(sql);
		//为sql语句占位符赋值
		setParameter(values);
		//执行sql语句
		return statement.executeUpdate();
	}
	
	public ResultSet executeQuery(String sql,Object ...values) throws SQLException{
		//连接数据库
		initConnection();
		//创建执行sql语句对象
		statement= connection.prepareStatement(sql);
		//为占位符赋值
		setParameter(values);
		rs = statement.executeQuery();
		return rs;
	}
	/**
	 * 为占位符赋值
	 */
	private void setParameter(Object ...values) throws SQLException{
		if(values!=null && values.length>0){
			for (int i = 0; i < values.length; i++) {
				statement.setObject(i+1, values[i]);
			}
		}
	}
	/**
	 * 关闭数据库
	 */
	public void close(){
		//关闭库
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
