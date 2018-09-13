package Ex01;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BankAccount {

	private UUID id;
	private BigDecimal balance;
	private double annulIntrestRate;
	private LocalDate dateCreated;
	
	public BankAccount()
	{
		id = UUID.randomUUID();
		balance = BigDecimal.ZERO;
		annulIntrestRate= 0 ;
		dateCreated = LocalDate.now();
		
	}
	
	
	

	public BankAccount(UUID id, BigDecimal balance, double annulIntrestRate, LocalDate dateCreated) {
		super();
		this.id = id;
		this.balance = balance;
		this.annulIntrestRate = annulIntrestRate;
		this.dateCreated = dateCreated;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public double getAnnulIntrestRate() {
		return annulIntrestRate;
	}

//	public void setAnnulIntrestRate(double annulIntrestRate) {
//		this.annulIntrestRate = annulIntrestRate;
//	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setAnnulIntrestRate(double annulIntrestRate )
	{
		if (annulIntrestRate >= 0)
		{
			this.annulIntrestRate = annulIntrestRate;
		}
	}
	
	
	public double getMontlyInterestRate()
	{
		return  annulIntrestRate /100/12;
		
	}
	
	public BigDecimal getMontlyInterest ()
	{
		return BigDecimal.valueOf(balance.doubleValue() * getMontlyInterestRate());
	}
	
	
	public BigDecimal addMonthlyInterest()
	{
		balance = balance.add(getMontlyInterest());
		return balance;
	}
	
	public BigDecimal withdraw (BigDecimal amount)
	{
		if (amount.doubleValue() > 0 && amount.doubleValue()< balance.doubleValue())
		{
			balance = balance.subtract(amount);
			return balance;
		}
		else
		{
			return balance;
		}
	}
	
	public BigDecimal deposit (BigDecimal amount)
	{
		if (amount.doubleValue() > 0 && amount.doubleValue()< balance.doubleValue())
		{
			balance = balance.add(amount);
			return balance;
		}
		else
		{
			return balance;
		}
	}
	
	
	
	
	
}
