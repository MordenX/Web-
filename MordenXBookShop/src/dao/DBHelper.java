
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
 		   System.out.println("ע�⣺���ݿ���������ʧ�ܣ�����"
 		   		+ "��Ŀ���Ƿ��Ѿ���������jar��������������д����ȷ��");
 	   }
    }
    /**
     * ��ȡ���ݿ�����
     * @return �������ݿ����Ӷ���
     * @ThrowS SQLException �˷������ܻ��׳�SQLException�쳣
     * */
    private void getConnection() throws SQLException{
    	if( conn == null || conn.isClosed()){
    	 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mordenxshop","root","root");
    	 }
    }
    /**
     * �ر����ݿ�����
     * @param Ҫ�رյ����ݿ����Ӷ���
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
     * ִ��ɾ���ĵķ���
     * @param conn ���ݿ����Ӷ���
     * @param sql SQL���
     * @param objs SQL����еĲ���
     * @return ����ִ�е�����
     * @throws SQLException �������ܻ��׳��쳣
     * */
    public int executeSQL(String sql,Object...objs) throws SQLException{
    	getConnection();
    	//����ִ��SQL����PreparedStatement����
    	psmd=conn.prepareStatement(sql);
    	//����ռλ����SQL��ֵ
    	setParam(objs);
    	//ִ��SQL
    	rows=psmd.executeUpdate();
    	//����ִ�н��
    	return rows;
    }
    
    /**
     * ִ��Insert��䲢���������ɵ�����ID�ķ���
     * @param sql SQL���
     * @param objs SQL����еĲ���
     * @return �������ɵ�����ֵID
     * @throws SQLException �������ܻ��׳��쳣
     * **/
    public int executeInsert(String sql,Object...objs) throws SQLException{
    	getConnection();
    	//����ִ��SQL����PreparedStatement����
    	psmd=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    	//����ռλ����SQL��ֵ
    	setParam(objs);
    	//ִ��SQL
    	rows=psmd.executeUpdate();
    	//��ȡ���ɵ�����
    	rs=psmd.getGeneratedKeys();
    	//��������
    	if(rs.next()){
    		return rs.getInt(1);
    	}
    	//����ִ�н��
    	return -1;
    }
    
    /**
     * ���ز�ѯ�����
     * @param sql SQL���
     * @param objs SQL����еĲ���
     * @return �������ɵ�����ֵID
     * @throws SQLException �������ܻ��׳��쳣
     * **/
    /*public ResultSet executeQuery(String sql,Object...objs) throws SQLException{
    	getConnection();
    	//����ִ��SQL����PreparedStatement����
    	psmd=conn.prepareStatement(sql);
    	//����ռλ����SQL��ֵ
    	setParam(objs);
    	//ִ��SQL
    	rs=psmd.executeQuery();
    	return rs;
    }
    */
    
    public List<T> executeQuery(String sql,IRowMapper<T> mapper,Object...objs) throws SQLException{
    	getConnection();
    	//����ִ��SQL����PreparedStatement����
    	psmd=conn.prepareStatement(sql);
    	//����ռλ����SQL��ֵ
    	setParam(objs);
    	//ִ��SQL
    	rs=psmd.executeQuery();
    	//���� List����
    	List<T> list  = new ArrayList<T>();
    	list.clear();
    	while(rs.next()){
    		T t = mapper.rowMapper(rs);
    		list.add(t);
    	}
    	return list;
    }
    
    /**
     * ��psmdԤ����Ĳ�����ֵ
     * @param objs �����б�
     * @throws SQLException �������ܻ��׳��쳣
     * */
    private void setParam(Object...objs) throws SQLException{
    	if(objs!=null && objs.length>0){
    		for (int i = 0; i < objs.length; i++) {
    			psmd.setObject(i+1, objs[i]);
			}
    	}
    }
    /**
     * ִ�оۺϺ�����ѯ
     * */
	public Object executeScalar(String sql, Object... objs) throws SQLException {
		getConnection();
    	//����ִ��SQL����PreparedStatement����
    	psmd=conn.prepareStatement(sql);
    	//����ռλ����SQL��ֵ
    	setParam(objs);
    	//ִ��SQL
    	rs=psmd.executeQuery();
    	
    	Object object=null;
    	if(rs.next()){
    		object = rs.getObject(1);
    	}
    	return object;
	}
}
