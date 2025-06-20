package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bean.Account;
import bean.User;
import dao.AccountDaoInterface;

public class AccountDaoImpl implements AccountDaoInterface
{
	ResultSet rs;
	Account a;
	Session ses;
	Transaction tx;
	
	private static SessionFactory factory;

		static 
		{
			try
			{
			 factory = 	new Configuration().configure().buildSessionFactory();
			 System.out.println("hibernate connected to account");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	public int insertRecord(Account a)
	{
		int updateCount = 0;
		try
		{
			ses = factory.openSession();
			tx = ses.beginTransaction();
			ses.save(a);
			tx.commit();
			ses.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return updateCount;
	}

	public Account retriveRecord(int accNo)
	{
		 try
		    {
		    	a = null;
			    ses = factory.openSession();
			        a =  ses.createQuery("from Account where accNo = :accNo", Account.class)
		                      .setParameter("accNo", accNo)
		                      .uniqueResult();
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    return a;
	}
  
	//for update the Record
	public void updateRecord(Account a, float newBal)
	{
		 try
		 {
			 ses = factory.openSession();
			 tx = ses.beginTransaction();

			 String hql = "UPDATE Account SET accBal = :newBal WHERE accNo = :accNo";
			 Query<?> query = ses.createQuery(hql);
			 query.setParameter("newBal", newBal);
			 query.setParameter("accNo", a.getAccNo());
			    
			 int rowsUpdated = query.executeUpdate();  // Make sure to execute
			 tx.commit();
			 ses.close(); 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}

	//for Deleted the Record
	public void deletedRecord(int accNo)
	{
	  try
	  {
		ses = factory.openSession();
		tx = ses.beginTransaction();
		String hql = "delete from Account where accNo = :accNo";
		Query<?> query = ses.createQuery(hql);
		query.setParameter("accNo", accNo);
		query.executeUpdate();
		tx.commit();
		ses.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
			 
	}
	
}
