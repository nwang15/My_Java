package dmit2015.controller;

import java.awt.ActiveEvent;
import java.io.Serializable;

import org.omnifaces.util.Messages;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import dmit2015.model.Loan;
import dmit2015.model.LoanSchedule;

public class LoanController implements Serializable
{
	private Loan currentLoan = new Loan();
	private BarChartModel loanChart; 
	private LoanSchedule[] currentLoanTable;
	
	
	public void init()
	{
		createBarModel();
	}
	
	public void calculate(ActiveEvent event)
	{
		currentLoanTable = currentLoan.getLoanScheduleArray();
		Messages.addGlobalInfo("Your monthly mortagage payment is " + String.format("$%,.2f", currentLoan.getMonthlyPayment()));
		createBarModels();
	}
	private void createBarModels() {
        createBarModel();
        //createHorizontalBarModel();
    }
     
	
	  private void createBarModel() {
		  
		  
	         
		  loanChart.setTitle("Mortgage Amortization Paydown");
		  loanChart.setLegendPosition("ne");
	         
	        Axis xAxis = loanChart.getAxis(AxisType.X);
	        xAxis.setLabel("Years");
	         
	        Axis yAxis = loanChart.getAxis(AxisType.Y);
	        yAxis.setLabel("amortgage Amount");
//	        yAxis.setMin(0);
//	        yAxis.setMax(200);
	    }
	  

		public Loan getCurrentLoan() {
			return currentLoan;
		}

		public void setCurrentLoan(Loan currentLoan) {
			this.currentLoan = currentLoan;
		}

		public BarChartModel getLoanChart() {
			return loanChart;
		}

		public void setLoanChart(BarChartModel loanChart) {
			this.loanChart = loanChart;
		}

		public LoanSchedule[] getCurrentLoanTable() {
			return currentLoanTable;
		}

		public void setCurrentLoanTable(LoanSchedule[] currentLoanTable) {
			this.currentLoanTable = currentLoanTable;
		}

}
