package bean;

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
	private String sqn;
	private String sqa;
	
	public User()
	{
		this.username ="NULL";
		this.password = "NULL";
		this.sqn = "NULL";
		this.sqa = "NULL";
	}
	
	public User(String username,String password,String Sqn,String Sqa)
	{
		this.username = username;
		this.password = password;
		this.sqn = Sqn;
		this.sqa = Sqa;
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
		this.sqn = Sqn;
	}
	
	public void setSqa(String Sqa)
	{
		this.sqa = Sqa;
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
		return this.sqn;
	}
	
	public String getSqa()
	{
		return this.sqa;
	}
	
	public String toString()
	{
		return "username = "+this.username+"  password = "+this.password;
	}

	public int hashCode() {
		return Objects.hash(sqa, sqn, password, username);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(sqa, other.sqa) && Objects.equals(sqn, other.sqn)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}

