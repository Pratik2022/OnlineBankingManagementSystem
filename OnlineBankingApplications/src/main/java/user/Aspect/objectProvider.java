package user.Aspect;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import user.DaoServices.DaoInterface;
import user.serviceImpl.loginServiceImpl;
import user.services.loginServices;

public class objectProvider
{
	
	public static loginServices ProvideBusinessObjects(String bClass)
	{
		loginServices lss = null;
		try
		{
			lss=(loginServices) Class.forName(bClass).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lss;
	}
	
	
	public static DaoInterface ProvideDaoObject(String DaoClass)
	{
		DaoInterface DI = null;
		
		try
		{
			DI = (DaoInterface) Class.forName(DaoClass).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return DI;
		
	}
	    

}




