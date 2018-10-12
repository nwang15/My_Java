package dmit2015.hr.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dmit2015.hr.entity.Job;
import dmit2015.hr.service.HumanResourceService;


@Named("currentJobController")
@ViewScoped	

public class JobController {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HumanResourceService humanResourceService;
	
	private Job jobDetail;
	private String Jobid;
	private boolean editMode = false;
	private String selectJobId;
	
	
	public List<Job> retreiveAllJobs()
	{
		return humanResourceService.findAllJob();
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
