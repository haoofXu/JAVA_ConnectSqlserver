import java.sql.*;  

class DBVar {
	ResultSet rs=null;//�������ݿ�����������ѯ���Ľ������ͨ��getString(?)��ý����
	PreparedStatement stmt=null;//���ݿ�ָ�����ʵ����䣻
	String sql=null;//String�������ڼ�¼ǰ���������䣻
}


public class cnct {
	public static void main(String [] args)  
	 {  
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
//		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Test";  
//		String userName="sa";
//		String userPwd="Bloodyxu113";   
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=feiyi";  
		String userName="sa";
		String userPwd="Bloodyxu113";  
		 try  
		{  
		    Class.forName(driverName);  
		    System.out.println("���������ɹ���");  
		}catch(Exception e){  
		    e.printStackTrace();  
		    System.out.println("��������ʧ�ܣ�");  
		}  
		try{  
		    Connection connection=DriverManager.getConnection(dbURL,userName,userPwd);  
		    System.out.println("�������ݿ�ɹ���");  
	        DBVar S=new DBVar();
	        S.sql="select * from content where num = '2'";
			S.stmt=connection.prepareStatement(S.sql);
			S.rs=S.stmt.executeQuery();
			String text = null;
			while(S.rs.next()){
				text = S.rs.getString("context");
			}
			System.out.print(text);
		}catch(Exception e)  
		{  
		    e.printStackTrace();  
		    System.out.print("SQL Server����ʧ�ܣ�");  
		}  
		
	}  
}
