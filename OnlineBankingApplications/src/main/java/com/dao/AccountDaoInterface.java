package com.dao;

import com.bean.Account;

//CRUD operations summary
public interface AccountDaoInterface 
{
  public int insertRecord(Account a);
  public Account retriveRecord(int acc);
  public void updateRecord(Account a);
  public void deletedRecord(int acc);
}
