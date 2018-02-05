import java.sql.*;  

class DBVar {
	ResultSet rs=null;//声明数据库结果集，即查询到的结果集，通过getString(?)获得结果；
	PreparedStatement stmt=null;//数据库指令操作实体语句；
	String sql=null;//String变量用于记录前端输入的语句；
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
		    System.out.println("加载驱动成功！");  
		}catch(Exception e){  
		    e.printStackTrace();  
		    System.out.println("加载驱动失败！");  
		}  
		try{  
		    Connection connection=DriverManager.getConnection(dbURL,userName,userPwd);  
		    System.out.println("连接数据库成功！");  
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
		    System.out.print("SQL Server连接失败！");  
		}  
		
	}  
}
