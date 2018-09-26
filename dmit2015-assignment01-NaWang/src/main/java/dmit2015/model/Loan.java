package dmit2015.model;

public class Loan {
	
	private double mortgageAmount;
	private double annualInterestRate;
	private int amortizationPeriod;
	
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
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
		this.mortgageAmount=mortgageAmount;
		this.annualInterestRate=annualInterestRate;
		this.amortizationPeriod=amortizationPeriod;
		
	}
	public Loan(double mortgageAmount, double annualInterestRate, int amortizationPeriod) {
		super();
		this.mortgageAmount = mortgageAmount;
		this.annualInterestRate = annualInterestRate;
		this.amortizationPeriod = amortizationPeriod;
	}
//	@Override
//	public String toString() {
//		return "Loan [mortgageAmount=" + mortgageAmount + ", annualInterestRate=" + annualInterestRate
//				+ ", amortizationPeriod=" + amortizationPeriod + "]";
//	}
//	
	public double getMonthlyPayment()
	{
		return mortgageAmount*(Math.pow(((1+annualInterestRate)/200),1.0/6.0)-1)/(1-Math.pow(Math.pow(((1+annualInterestRate)/200),1.0/6.0)+1, -12*amortizationPeriod));
	}
	
	

	public double getInterestPaid() 
	{
		return monthlyPercentageRate() * mortgageAmount;
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
		
		for(int paymentNumber =1; paymentNumber<= totalPayments; paymentNumber++)
		{
			// LoanSchedule currentLoanSchedule = new LoanSchedule();
			
			
			insterestPaid = mpp *amount;
			
			principalPaid = getMonthlyPayment() - insterestPaid;
			amount-=principalPaid;
			remainingBalance = amount;
			
			
			
			loanScheduleTable[paymentNumber] = new LoanSchedule();
			
			loanScheduleTable[paymentNumber].setPaymentNumber(paymentNumber +1);
			loanScheduleTable[paymentNumber].setInterestPaid(insterestPaid);
			loanScheduleTable[paymentNumber].setPrincipalPaid(principalPaid);
			loanScheduleTable[paymentNumber].setRemainingBalance(remainingBalance);
			
		
		}
		
		return loanScheduleTable;
	}
				
		
		public double monthlyPercentageRate()
		{
			return Math.pow(((1+annualInterestRate)/200),1.0/6.0)-1;
		}
		
		public double getPrincipalPaid()
		{
			return getMonthlyPayment() - getInterestPaid();
		}
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		

}
