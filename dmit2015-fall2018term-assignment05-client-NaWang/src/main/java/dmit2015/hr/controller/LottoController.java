package dmit2015.hr.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import org.omnifaces.util.Messages;

import dmit2015.soap.HumanResourceService;
import dmit2015.soap.HumanResourceXmlWebService;
import dmit2015.soap.Job;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class LottoController implements Serializable {
	private static final long serialVersionUID = 1L;

	//@WebServiceRef(wsdlLocation="http://localhost:8080/dmit2015-fall2018term-assignment05-server-start/HumanResourceService?wsdl")
	private HumanResourceService hrEndPoint = new HumanResourceService();
	
	private HumanResourceXmlWebService hrService;
	
	private int number;
	private List<Job> jobs;

	private String jobID;
	private Job oneJob ;
	

	@PostConstruct
	public void pageLoad() {
		hrService = hrEndPoint.getHumanResourcePort();
		jobs = hrService.findAllJobs();
		
	}
	
	public void doLuckyNumber() {
		int luckyNumber = hrService.luckyLottoNumber();
		Messages.addGlobalInfo("Your lucky number is {0}", luckyNumber);
	}
	
	public void getLuckyNumbers() {
		String luckyNumber = hrService.sortLuckyNumber(number);
		Messages.addGlobalInfo("Your lucky number is {0}", luckyNumber);
	}
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public Job getOneJob() {
		return oneJob;
	}

	public void setOneJob(Job oneJob) {
		this.oneJob = oneJob;
	}

	public Job findOneJob() {
		return oneJob = hrService.findOneJob(jobID);
	}
	
	
	
}
