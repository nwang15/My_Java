package dmit2015.hr.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dmit2015.hr.entity.Job;


public class HumanResourceService {

	@Inject
	private EntityManager entityManager;
	
	
	// Jobs
	public void addJob (Job newJob)
	{
		entityManager.persist(newJob);
	}
	
	public void updateJob (Job existingJob)
	{
		entityManager.merge(existingJob);
	}
	

	public void deleteJob(Job existingJob) throws Exception
	{
		existingJob = entityManager.merge(existingJob);
		
		if(existingJob.getEmployees().size()>0)
		{
			throw new Exception("This job with employees cannot be deleted");
		}
		entityManager.remove( existingJob );
	}
	
//	public void deleteJobById(String JobId) 
//	{
//		Job existingJob = findOneJob(JobId);
//		deleteJob(existingJob);
//	}
	
	public Job findOneJob(String JobId) {
		return entityManager.find(Job.class, JobId);	
	}
	
	public List<Job> findAllJob() {
		return entityManager.createQuery(
			"SELECT e FROM Job e ORDER BY e.jobTitle", Job.class
//			"FROM Job",Job.class
			).getResultList();
	}
	
	
	

	
}
