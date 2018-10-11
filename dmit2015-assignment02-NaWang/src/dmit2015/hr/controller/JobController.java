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
	private String id;
	
	
	

	public List<Job> retreiveAllJobs()
	{
		return humanResourceService.findAllJob();
	}

}
