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
		
	}
	public LoanSchedule[] getLoanScheduleArray()
	{
		
	}
	
	
	

}
