package DaoService;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import DaoServices.DaoInterface;
import bean.User;

public class DaoServiceImpl implements DaoInterface
{
   private static SessionFactory factory;
   Transaction tx;
   User user;

	static 
	{
		try
		{
		 factory = 	new Configuration().configure().buildSessionFactory();
		 System.out.println("hibernate connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void insertRecord(User user)
	{
		try
		{
			Session ses = factory.openSession();
			tx = ses.beginTransaction();
			ses.save(user);
			tx.commit();
			ses.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public User retrieveRecord(String username, String password)
	{
	    try
	    {
	    	user = null;
		    Session session = factory.openSession();
		        user =  session.createQuery("FROM User WHERE username = :username AND password = :password", User.class)
	                      .setParameter("username", username).setParameter("password", password)
	                      .uniqueResult();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return user;
	}

	public User retrieveRecord(String username, String sqn, String sqa)
	{
		try
	    {
	    	user = null;
		    Session session = factory.openSession();
		        user =  session.createQuery("FROM User WHERE username = :username AND sqn = :sqn AND sqa = :sqa", User.class)
	                      .setParameter("username", username).setParameter("sqn", sqn).setParameter("sqa",sqa)
	                      .uniqueResult();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return user;
	}

	public void updateRecord(String newPassword, String username) {
	    Session ses = factory.openSession();
	    Transaction tx = ses.beginTransaction();

	    String hql = "UPDATE User SET password = :newPassword WHERE username = :username";
	    Query<?> query = ses.createQuery(hql);
	    query.setParameter("newPassword", newPassword);
	    query.setParameter("username", username);
	    
	    int rowsUpdated = query.executeUpdate();  // Make sure to execute
	    tx.commit();
	    ses.close();
	    
	    System.out.println("Rows updated: " + rowsUpdated);
	}


	public void deleteRecord(String username, String password)
	{
		Session ses = factory.openSession();
		tx = ses.beginTransaction();
        // HQL delete query to directly remove the user without loading it first
        String hql = "DELETE FROM User WHERE username = :username AND password = :password";
        Query<User> query = ses.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        int result = query.executeUpdate();		
		tx.commit();
		ses.close();
	}
}

