package user.Aspect;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class UserDBConnectionProvider
{
	public static Connection connectionProvider()
	{
		Connection con =null;
		try
		{
			FileInputStream fis = new FileInputStream(".//Resources//DBInfo.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String driverClass= p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			con = DriverManager.getConnection(url,username,password);
			Class.forName(driverClass).newInstance();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}	
}
