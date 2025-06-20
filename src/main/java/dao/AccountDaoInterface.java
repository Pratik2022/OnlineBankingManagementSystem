package dao;

import bean.Account;

//CRUD operations summary
public interface AccountDaoInterface 
{
  public int insertRecord(Account a);
  public Account retriveRecord(int acc);
  public void updateRecord(Account a, float newBal);
  public void deletedRecord(int acc);
}
