package dmit2015.controller;

import java.awt.ActiveEvent;
import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.highfaces.component.chartserie.ChartSerie;
import org.omnifaces.util.Messages;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import dmit2015.model.Loan;
import dmit2015.model.LoanSchedule;

public class LoanController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Loan currentLoan = new Loan();
	private BarChartModel loanChart; 
	private LoanSchedule[] currentLoanTable;
	
	
	public void calculate(ActiveEvent event)
	{
		currentLoanTable = currentLoan.getLoanScheduleArray();
		//setCurrentLoanTable(currentLoan.getLoanScheduleArray());
		
		Messages.addGlobalInfo("Your monthly mortagage payment is " + String.format("$%,.2f", currentLoan.getMonthlyPayment()));
		
		createBarModels();
	}
	
	@PostConstruct
	public void init()
	{
		loanChart = new BarChartModel();
		
		loanChart.setTitle("Amortization Schedule");
		
		Axis xAxis = loanChart.getAxis(AxisType.X);
        xAxis.setLabel("Years");
         
        Axis yAxis = loanChart.getAxis(AxisType.Y);
        yAxis.setLabel("Mortgage Amount");
        
		//createBarModel();
	}
	
	
	public void createBarModels() {
        //createBarModel();
        //createHorizontalBarModel();
        
        loanChart.clear();
        
        ChartSerie amountSeries = new ChartSerie();
        
        //amountSeries.setDataLabel("Amortization in Years");
        
        for(LoanSchedule currentLoanSchedule : currentLoan.getLoanScheduleArray())
        {
        	if(currentLoanSchedule.getPaymentNumber()%12 == 0) 
			{
				amountSeries.set	
				(currentLoanSchedule.getPaymentNumber()/12, currentLoanSchedule.getRemainingBalance());
			}
        }
        loanChart.addSeries(amountSeries);
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
