package user.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Account;

import user.Aspect.objectProvider;
import user.DaoServices.DaoInterface;
import user.bean.User;

public class DaoServiceImpl implements DaoInterface
{
	PreparedStatement pst;
	ResultSet rs;
	Connection con;
	
	public void setConnection(Connection con)
	{
		this.con = con;
	}

	public void insertRecord(User user)
	{
		try
		{
			pst = con.prepareStatement("insert into login values(?,?,?,?)");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassWord());
			pst.setString(3, user.getSqn());
			pst.setString(4, user.getSqa());
			int updateCount = pst.executeUpdate();
			
			if(updateCount>0)
			{
			System.out.println("Username and password registered successfully");
			}else {
				System.out.println("registration failed");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public User retrieveRecord(String username,String password)
	{
		User user = null;
		try
		{
		   pst = con.prepareStatement("select * from login where username = ? and password = ?");
		   pst.setString(1, username);
		   pst.setString(2, password);
		   rs = pst.executeQuery();
		   
		   if(rs.next())
		   {
			  username = rs.getString(1) ;
			  password = rs.getString(2);
			  String sqn = rs.getString(3);
			  String sqa = rs.getString(4);
			  user = new User(username,password,sqn,sqa);
			  
		   }
		   else
		   {
			  user = null;
		   }
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}



public User retrieveRecord(String username, String sqn,String sqa)
{
	User user = null;
	try
	{
	   pst = con.prepareStatement("select * from login where username = ? and sqn = ? and sqa = ?");
	   pst.setString(1, username);
	   pst.setString(2, sqn);
	   pst.setString(3, sqa);
	   rs = pst.executeQuery();
	   
	   if(rs.next())
	   {
		  username = rs.getString(1) ;
		  String password = rs.getString(2);
		   sqn = rs.getString(3);
		  sqa = rs.getString(4);
		  user = new User(username,password,sqn,sqa);
		  
	   }
	   else
	   {
		  user = null;
	   }
		  
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return user;
}

   public void updateRecord(String newPassWord,String username)
  {
	   try
	   {
		  pst = con.prepareStatement("update login set password = ? where username = ?");
		  pst.setString(1, newPassWord);
		  pst.setString(2, username);
		  int updateCount = pst.executeUpdate();
		  
		  if(updateCount>0)
			  System.out.println("Record updated successfully");
		  else
			  System.out.println("Record updation failed");
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	
	
  }

   
  public void deleteRecord(String username, String password) 
  {
	  try
	  {
		pst = con.prepareStatement("delete from login where username = ? and password = ?");
		pst.setString(1, username);
		pst.setString(2, password);
		int updateCount = pst.executeUpdate();
		
		if(updateCount>0)
			System.out.println("Record deleted successfully");
		else
			System.out.println("Record deletion failed");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	
  }
}

