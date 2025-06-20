package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Account;
import com.dao.AccountDaoInterface;

//CRUD operations implementation
public class AccountDaoImpl implements AccountDaoInterface
{
	   //get database connetion from the provider class
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void setConnection(Connection con)
	{
		this.con = con;
	}
	
	public int insertRecord(Account a)
	{
		int updateCount = 0;
		try
		{
			pst = con.prepareStatement("insert into account values(?,?,?)");
			pst.setInt(1, a.getAccNo());
			pst.setString(2, a.getAccType());
			pst.setFloat(3,a.getAccBal());
			updateCount = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return updateCount;
	}

	public Account retriveRecord(int accNo)
	{
		Account a = null;
		try
		{
			pst = con.prepareStatement("select * from Account where accNo = ?");
			pst.setInt(1, accNo);
			rs = pst.executeQuery();
			if(rs.next())
			{
				int no = rs.getInt(1);
				String type = rs.getString(2);
				float bal = rs.getFloat(3);
				a = new Account(no,type,bal);
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
  
	//for update the Record
	public void updateRecord(Account a)
	{
		try
		{
				pst = con.prepareStatement("update account set accBal = ? WHERE accNo = ?");
				pst.setFloat(1, a.getAccBal());
				pst.setInt(2, a.getAccNo());
				int updateCount = pst.executeUpdate();
				
				if(updateCount>0)
				{
					System.out.println("Record are updated successfully");
				}
				else
				{
					System.out.println("updated Record failed");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//for Deleted the Record
	public void deletedRecord(int accNo)
	{
		int updateCount=0;
	  try
	  {
			  pst = con.prepareStatement("delete from account where accNo = ?");
			  pst.setInt(1, accNo);
			  updateCount = pst.executeUpdate();
			  
			  if(updateCount>0)
			  {
				  System.out.println("Record deleted successfully");
			  }
			  else
			  {
				  System.out.println("Record deleted failed");
			  }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	}
	
}
