package user.DaoServices;

import com.bean.Account;

import user.bean.User;

public interface DaoInterface
{
   public void insertRecord(User user);
   public User retrieveRecord(String username,String password);
   public User retrieveRecord(String username, String sqn,String sqa);
   public void updateRecord(String newPassword,String username);
   public void deleteRecord(String username,String password);

   

}
