package dmit2015.model;

import java.util.Arrays;

public class Loan {
	
	private double mortgageAmount;
	private double annualInterestRate;
	private int amortizationPeriod;
	
	public Loan()
	{
		
	}
	
	public Loan(double mortgageAmount, double annualInterestRate, int amortizationPeriod) {
		super();
		this.mortgageAmount = mortgageAmount;
		this.annualInterestRate = annualInterestRate;
		this.amortizationPeriod = amortizationPeriod;
	}
	
	public double getMonthlyPayment()
	{
		return mortgageAmount*(Math.pow((1+annualInterestRate/200),(1.0/6.0))-1)
				/(1-Math.pow(Math.pow((1+annualInterestRate/200),(1.0/6.0)), (-12*amortizationPeriod)));
	}
	
	public double monthlyPercentageRate()
	{
		return Math.pow(((1+annualInterestRate)/200),1.0/6.0)-1;
	}
	
	
	public double getMortgageAmount() {
		return mortgageAmount;
	}
	public void setMortgageAmount(double mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public int getAmortizationPeriod() {
		return amortizationPeriod;
	}
	public void setAmortizationPeriod(int amortizationPeriod) {
		this.amortizationPeriod = amortizationPeriod;
	}

	
	public double getInterestPaid() 
	{
		return monthlyPercentageRate() * mortgageAmount;
	}
		
					
	public double getPrincipalPaid()
	{
		return getMonthlyPayment() - getInterestPaid();
	}
	
	public LoanSchedule[] getLoanScheduleArray()
	{
		
		
		int totalPayments = amortizationPeriod * 12;
		double principalPaid = getPrincipalPaid();
		double insterestPaid = getInterestPaid();
		double amount = mortgageAmount;
		double mpp = monthlyPercentageRate();
		double remainingBalance = 0;
		
		LoanSchedule[] loanScheduleTable = new LoanSchedule[totalPayments];
		
		for(int paymentNumber = 1; paymentNumber <= totalPayments; paymentNumber++)
		{
			// LoanSchedule currentLoanSchedule = new LoanSchedule();
			
			
			insterestPaid = mpp * amount;
			
			principalPaid = getMonthlyPayment() - insterestPaid;
			amount -= principalPaid;
			remainingBalance = amount;
			
			
			
			loanScheduleTable[paymentNumber - 1] = new LoanSchedule();
			
			loanScheduleTable[paymentNumber - 1 ].setPaymentNumber(paymentNumber);
			loanScheduleTable[paymentNumber - 1].setInterestPaid(insterestPaid);
			loanScheduleTable[paymentNumber - 1].setPrincipalPaid(principalPaid);
			loanScheduleTable[paymentNumber - 1].setRemainingBalance(remainingBalance);
			
		
		}
		
		return loanScheduleTable;
	}
	

	@Override
	public String toString() {
		return "Loan [getLoanScheduleArray()=" + Arrays.toString(getLoanScheduleArray()) + "]";
	}			
		

}
