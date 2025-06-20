package bean;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class Account
{
	@Id
	@Column(name = "accNo")
	private int accNo;
	@Column(name = "acctype")
	private String accType;
	@Column(name = "accBal")
	private float accBal;
	
	public Account()
	{
		this.accNo = 0;
		this.accType = "None";
		this.accBal = 0;
	}
	
	public Account(int accNo,String accType,float accBal)
	{
		this.accNo = accNo;
		this.accType = accType;
		this.accBal = accBal;
	}
	
	public void setAccNo(int accNo)
	{
		this.accNo = accNo;
	}
	
	public void setAccType(String accType)
	{
		this.accType = accType;
	}
	
	public void setAccBal(float accBal)
	{
		this.accBal = accBal;
	}
	
	public int getAccNo()
	{
		return this.accNo;
	}
	
	public String getAccType()
	{
		return this.accType;
	}
	
	public float getAccBal()
	{
		return this.accBal;
	}
	
	public void display()
	{
		System.out.println("AccNo = "+accNo);
		System.out.println("AccType = "+accType);
		System.out.println("AccBal = "+accBal);
		System.out.println();
	}
	
	public String toString()
	{
		return "the AccNo = "+accNo+" AccType = "+accType+" accBal = "+accBal;
	}

	public int hashCode() {
		return Objects.hash(accBal, accType);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accBal == other.accBal && Objects.equals(accType, other.accType);
	}
	
	

}
