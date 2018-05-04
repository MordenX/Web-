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
 * �����������ִ��sql���
 * �������ͨ�ã�ͨ����ָ�����еı��sql��䶼�ܹ�ִ��
 */
public class DBHelper {
	//��������
	private Connection connection = null;
	private PreparedStatement statement =null;
	private ResultSet rs = null;
	private static String URL="jdbc:mysql://localhost:3306/xbmu";
	private static String USER="root";
	private static String PASS="root";//Ӳ����
	
	//��̬�����������ֻ����һ��
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//�������ݿ�������ļ�
	static{
		try {
			File file =new File("c:/db.properties");
			FileInputStream inStream =new FileInputStream(file);
			//Properties�Ǽ�ֵ�Եļ����࣬���ӿ���Map
			Properties prop = new Properties();
			prop.load(inStream);
			URL = (String)prop.get("url");
			USER = (String)prop.get("user");
			PASS = (String)prop.get("pass");
		} catch (IOException e) {
			System.out.println("���ݿ������ļ�����ʧ�ܣ���ֹͣ���еĲ�����������ݿ������ļ�");
		}
	}
	
	/**
	 * ��ʼ�����Ӷ���
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
	 * ִ����ӣ�ɾ�����޸ĵ����
	 * @param sql ��ִ�е�sql���
	 * @param values sql�����ռλ����ֵ
	 * @return ����Ӱ�������
	 * @throws SQLException 
	 */
	public int executeUpdate(String sql,Object ...values) throws SQLException{
		//�������Ӷ���
		initConnection();
		//����ִ��sql���Ķ���
		statement = connection.prepareStatement(sql);
		//Ϊsql���ռλ����ֵ
		setParameter(values);
		//ִ��sql���
		return statement.executeUpdate();
	}
	
	public ResultSet executeQuery(String sql,Object ...values) throws SQLException{
		//�������ݿ�
		initConnection();
		//����ִ��sql������
		statement= connection.prepareStatement(sql);
		//Ϊռλ����ֵ
		setParameter(values);
		rs = statement.executeQuery();
		return rs;
	}
	/**
	 * Ϊռλ����ֵ
	 */
	private void setParameter(Object ...values) throws SQLException{
		if(values!=null && values.length>0){
			for (int i = 0; i < values.length; i++) {
				statement.setObject(i+1, values[i]);
			}
		}
	}
	/**
	 * �ر����ݿ�
	 */
	public void close(){
		//�رտ�
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
