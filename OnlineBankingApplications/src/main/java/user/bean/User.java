package user.bean;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class User {
    
	@Id
	private String username;
	private String password;
	private String Sqn;
	private String Sqa;
	
	public User()
	{
		this.username ="NULL";
		this.password = "NULL";
		this.Sqn = "NULL";
		this.Sqa = "NULL";
	}
	
	public User(String username,String password,String Sqn,String Sqa)
	{
		this.username = username;
		this.password = password;
		this.Sqn = Sqn;
		this.Sqa = Sqa;
	}
	
	public void setUserName(String username)
	{
		this.username = username;
	}
	
	public void setPassWord(String password)
	{
		this.password = password;
	}
	
	public void setSqn(String Sqn)
	{
		this.Sqn = Sqn;
	}
	
	public void setSqa(String Sqa)
	{
		this.Sqa = Sqa;
	}
	
	public String getUserName()
	{
		return this.username;
	}
	
	public String getPassWord()
	{
		return this.password;
	}
	
	public String getSqn()
	{
		return this.Sqn;
	}
	
	public String getSqa()
	{
		return this.Sqa;
	}
	
	public String toString()
	{
		return "username = "+this.username+"  password = "+this.password;
	}

	public int hashCode() {
		return Objects.hash(Sqa, Sqn, password, username);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Sqa, other.Sqa) && Objects.equals(Sqn, other.Sqn)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}

