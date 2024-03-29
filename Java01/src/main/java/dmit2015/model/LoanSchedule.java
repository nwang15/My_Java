package dmit2015.model;

public class LoanSchedule {
	
	private int paymentNumber;
	private double interestPaid;
	private double principalPaid;
	private double remainingBalance;





	public int getPaymentNumber() {
		return paymentNumber;
	}
	
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	
	public double getInterestPaid() {
		return interestPaid;
	}
	
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}
	
	public double getPrincipalPaid() {
		return principalPaid;
	}
	
	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}
	
	public double getRemainingBalance() {
		return remainingBalance;
	}
	
	public void setRemainingBalance(double remainingBalance) {
	
		this.remainingBalance = remainingBalance;
	}
	
	public LoanSchedule() {
//		super();
//		// TODO Auto-generated constructor stub
//		this.paymentNumber = 1;
//		this.interestPaid=0;
//		this.principalPaid=0;
//		this.remainingBalance=0;
//	
	}
	
	public LoanSchedule(int paymentNumber, double interestPaid, double principalPaid, double remainingBalance) {
		this.paymentNumber = paymentNumber;
		this.interestPaid = interestPaid;
		this.principalPaid = principalPaid;
		this.remainingBalance = remainingBalance;
	}
	
	@Override
	public String toString() {
		return "LOabSchedule [paymentNumber=" + paymentNumber + ", interestPaid=" + interestPaid + ", principalPaid="
				+ principalPaid + ", remainingBalance=" + remainingBalance + "]";
	}

}


