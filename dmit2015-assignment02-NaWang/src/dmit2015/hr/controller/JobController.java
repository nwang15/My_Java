package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.sun.mail.handlers.message_rfc822;

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
	private String selectJobId;
	
	@PostConstruct 
	public void init() {
		jobDetail = new Job();
	}
	
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
	public String getSelectJobId() {
		return selectJobId;
	}
	public void setSelectJobId(String selectJobId) {
		this.selectJobId = selectJobId;
	}
	

}
