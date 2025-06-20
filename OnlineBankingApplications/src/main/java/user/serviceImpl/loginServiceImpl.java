package user.serviceImpl;

import java.sql.Connection;

import user.Aspect.UserDBConnectionProvider;
import user.Aspect.objectProvider;
import user.DaoService.DaoServiceImpl;
import user.DaoServices.DaoInterface;
import user.Exception.poorPasswordException;
import user.Exception.poorRegisterException;
import user.bean.User;
import user.services.loginServices;

public class loginServiceImpl implements loginServices {
	
	User user;
	DaoInterface dao;
	Connection con;
	

	public void setConfigInfo(String DaoClass,Connection con)
	{
		this.con = con;
		dao = objectProvider.ProvideDaoObject(DaoClass);
		((DaoServiceImpl) dao).setConnection(con);
	}
	
	

	public synchronized int signUp(String username, String password, String Sqn, String Sqa) throws poorRegisterException
	{
	  if((username.length()>=8)&&(password.length()>=8))
      {
    	  user = dao.retrieveRecord(username, password);
    	  if(user==null)
    	  {
    		  user = new User(username,password,Sqn,Sqa);
        	  dao.insertRecord(user);
        	  return 1;
    	  }
    	  else
    	  {
    		  return 0;
    	  }
      }
      else
      {
    	  return -1;
      }
	}
	
	

	public int signIn(String username, String password) throws poorPasswordException
	{
		if((username.length()>=8) && (password.length()>=8))
		{
		boolean outcome = false;
		user = dao.retrieveRecord(username, password);
		  if(user!=null)
		  {
			  if((user.getUserName().equals(username))&&(user.getPassWord().equals(password)))
			  {
				return 1;
			  }
			  else
			  {
				return 0;
			  }
		  }
		  else
		  {
			  return -1;
		  }
		}
		else
		{
			return -2;
		}
	}
	
	

	public String forgetPassword(String username, String Sqn, String Sqa)
	{
        user = dao.retrieveRecord(username, Sqn, Sqa);
		
        if(user!=null)
        {
        	if((user.getUserName().equals(username))&&(user.getSqn().equals(Sqn))&&(user.getSqa().equals(Sqa)))
    		{
    			return user.getPassWord();		
    		}
    		else
    		{
    			return "Invalid";
    		}
        }
        else
        {
        	return "Invalid";
        }
	}
	
	

	public synchronized String updatePassword(String username, String password, String newPassWord)
	{
		user = dao.retrieveRecord(username, password);
		if(user!=null && user.getUserName().equals(username) && user.getPassWord().equals(password))
		{
			dao.updateRecord(newPassWord,username);
			user = dao.retrieveRecord(username, newPassWord);
			return user.getPassWord();
		}
		else
		{
			return "Invalid";
		}
	}


	public boolean deleteId(String username, String password)
	{
		user = dao.retrieveRecord(username, password);
		if(user!=null && user.getUserName().equals(username) && user.getPassWord().equals(password))
		{
			dao.deleteRecord(username, password);
			return true;
		}
		else
		{
			return false;
		}		
	}
}
