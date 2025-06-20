package com.Aspects;

import java.io.FileInputStream;
import java.util.Properties;

import com.dao.AccountDaoInterface;
import com.services.AccountServices;

public class ObjectProvider {

	public static AccountServices provideBusinessObjects(String name)
	{
		AccountServices acc = null;
		
		try
		{
			acc = (AccountServices) Class.forName(name).newInstance() ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return acc;
	}
	
	public static AccountDaoInterface createDaoObject(String name)
	{
		AccountDaoInterface dao = null;
		
		try
		{
			dao = (AccountDaoInterface) Class.forName(name).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return dao;
	}

}
