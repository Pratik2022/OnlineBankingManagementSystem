package com.serviceImpl;

import java.sql.Connection;
import java.util.Random;

import com.Aspects.ObjectProvider;
import com.bean.Account;
import com.dao.AccountDaoInterface;
import com.daoimpl.AccountDaoImpl;
import com.services.AccountServices;

public class AccServiceImpl implements AccountServices {

	private int accNo;
	private float accBal=0;
	private String accType;
	private Account a;
	Random r1 = new Random();
	AccountDaoInterface Dao;
	AccountDaoInterface dao;

	public void setInfo(String Dao,Connection con)
	{
		dao = ObjectProvider.createDaoObject(Dao);
		((AccountDaoImpl) dao).setConnection(con);
	}
	
	public Account openAccount(String accType, float amount) 
	{
		a  = new Account(accNo,accType,(int)amount);
		accNo = r1.nextInt(100);
		a.setAccNo(accNo);
		dao.insertRecord(a);
		assert(amount>=1000):"minimum amount for opening for account is min 1000rs";
		accBal = amount;
		
		return a;
	}

	public Account balEnquiry(int accNo, String accType)
	{
		Account a = dao.retriveRecord(accNo);
	
	   if(a!=null&&a.getAccNo()==accNo && a.getAccType().equalsIgnoreCase(accType))
	   {
				return a;
	   }
	   else
	   {
				return null;
	   }
	 }
		

	public float deposit(int accNo, float amount) {
		
		if(amount<=1000)
		{
			return 0.0f;
		}
		Account a = dao.retriveRecord(accNo);
		
		if(a==null)
		{
			return 0.0f;
		}
		else
		{
			if((a.getAccNo()==(accNo)))
			{
				synchronized(this)
				{
					if(a!=null)
					{
						float newBal = a.getAccBal() + amount;
						a.setAccBal(newBal);
						dao.updateRecord(a);
						return newBal;
					}
				}
			}
			else
			{
				return 0.0f;
			}
		}
		return 0.0f;
	}
	
	public float withdraw(int accNo,float amount)
	{
	   Account a = dao.retriveRecord(accNo);
	   
	   if(a==null)
	   {
		   return  -1.0f;
	   }
	   
	   if (a.getAccBal() - amount < 500) {
	        return -2.0f; // Prevent withdrawal if balance goes below ₹500
	    }
	   
	   if(a.getAccBal()<amount)
	   {
		   return -0.0f;
	   }
	   else
	   {
		   float newBal = a.getAccBal()-amount;
		   a.setAccBal(newBal);
		   dao.updateRecord(a);
		   return newBal;		   
	   }
	}
	
	public float delete(int accNo)
	{
		a = dao.retriveRecord(accNo);
		
		if(a==null)
		{
			return -1.0f;
		}
		else
		{
			a.getAccNo();
			dao.deletedRecord(a.getAccNo());
			return a.getAccBal();
		}
	}
}
