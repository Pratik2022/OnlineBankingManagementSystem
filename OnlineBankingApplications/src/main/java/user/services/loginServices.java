package user.services;

import user.Exception.poorPasswordException;
import user.Exception.poorRegisterException;

public interface loginServices {
	
	public int signUp(String username,String password,String Sqn,String Sqa)throws poorRegisterException;
	public int signIn(String username,String password) throws poorPasswordException;
	public String forgetPassword(String username,String Sqn,String Sqa);
    public String updatePassword(String username,String password,String newpassword);
    public boolean deleteId(String username,String password);
}
