
package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBAccessException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;



import dmit2015.hr.entity.Job;
import dmit2015.hr.service.HumanResourceService;


@Named("currentJobController")
@ViewScoped	
public class JobController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HumanResourceService humanResourceService;
	
	private Job jobDetail;
	private String Jobid;
	private boolean editMode = false;
	private Integer selectJobId;
	
	@PostConstruct 
	public void init() {
		jobDetail = new Job();
	}
	
	//create job
	public String createJob()
	{
		String outcome = null;
		
		try
		{
			if(jobDetail.getMaxSalary().doubleValue() > 1.25 * jobDetail.getMinSalary().doubleValue())
			{
				humanResourceService.addJob(jobDetail);
				jobDetail = new Job();
				Messages.addFlashGlobalInfo("Create was successful.");
				outcome = "viewJobs?faces-redirect=true";
			}
			
		} catch(EJBAccessException e)
		{
			Messages.addGlobalError(e.getMessage());			
		}catch(Exception e)
		{
			Messages.addGlobalError("Create was not successful.");
		}
		
		return outcome;
	}
	
	// find job by id
	public void findJobById ()
	{
		if(Jobid !=null && Jobid.length()>0)
		{
			Job item = humanResourceService.findOneJob(Jobid);
			if(item == null)
			{
				Messages.addGlobalError("Bad Request. Unkonwn id {0}." , Jobid);
			}
			else
			{
				editMode = true;
				jobDetail = item;
				
			}
		}
		
	}
	
	
	// update job
	public String updateJob()
	{
		String outcome = null;
		
		try
		{
			if(jobDetail.getMaxSalary().doubleValue() > 
			1.25 * jobDetail.getMinSalary().doubleValue())
			{
				humanResourceService.updateJob(jobDetail);
				jobDetail = new Job();
				Messages.addFlashGlobalInfo("Update was successful.");
				outcome = "viewJobs?faces-redirect=true";
			}
		}catch (Exception e) {
			Messages.addGlobalError("Update unsuccessful");	
			Messages.addGlobalError("{0}", e.getMessage());	
		}
		
		return outcome;
	}
	
	// remove job
	public String removeJob()
	{
		String outcome = null;
		try {
			humanResourceService.deleteJob(jobDetail);
			Messages.addFlashGlobalInfo
			("Remove Job {0} was successful", jobDetail.getJobId());
			jobDetail = new Job();
			editMode = false;
			outcome = "viewJobs?faces-redirect=true";
		}catch (Exception e) {
			Messages.addGlobalError("Delete unsuccessful");			
			Messages.addGlobalError("{0}", e.getMessage());	
		}
		
		return outcome;
		
	}
	public String cancel() {
		editMode = false;
		return "viewJobs?faces-redirect=true";
	}
	
	public List<Job> retreiveAllJobs() {
		return humanResourceService.findAllJob();
	}
	
	
	
	// getter and setter
	public Job getJobDetail() {
		return jobDetail;
	}
	public void setJobDetail(Job jobDetail) {
		this.jobDetail = jobDetail;
	}
	public String getJobid() {
		return Jobid;
	}
	public void setJobid(String jobid) {
		Jobid = jobid;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Integer getSelectJobId() {
		return selectJobId;
	}

	public void setSelectJobId(Integer selectJobId) {
		this.selectJobId = selectJobId;
	}


}

