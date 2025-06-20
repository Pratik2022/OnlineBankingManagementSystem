package user.Exception;

public class poorRegisterException extends Exception
{
 String msg;
  
 public poorRegisterException(String msg)
 {
	 this.msg = msg;
 }
 
 public String toString()
 {
	return "create username and password atleast at 8 in length"; 
 }
 
}
