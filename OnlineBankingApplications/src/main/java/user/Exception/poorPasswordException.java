package user.Exception;

 public class poorPasswordException extends Exception
 {
    String msg;
 
    public poorPasswordException(String msg)
    {
	this.msg = msg;
    }
    
    public String toString()
    {
    	return "username and password length must be greater or equal than 8";
    }
 }
