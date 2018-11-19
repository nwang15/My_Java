package dmit2015.hr.service;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import dmit2015.hr.entity.Country;
import dmit2015.hr.entity.Job;
import dmit2015.hr.entity.Location;

@Stateless
@DeclareRoles({"DMIT2015Instructor","DMIT2015Student","PROG_DMIT"})
public class HumanResourceService {

	@Inject
	private EntityManager entityManager;
	
	// Jobs
	@RolesAllowed({"DMIT2015Instructor","DMIT2015Student","PROG_DMIT"})
	public void addJob (Job newJob)
	{
		entityManager.persist(newJob);
	}
	
	@RolesAllowed({"DMIT2015Instructor","DMIT2015Student"})
	public void updateJob (Job existingJob)
	{
		entityManager.merge(existingJob);
	}
	

//	public void deleteJob(Job existingJob) throws Exception
//	{
//		existingJob = entityManager.merge(existingJob);
//		
//		if(existingJob.getEmployees().size()>0)
//		{
//			throw new Exception("This job with employees cannot be deleted");
//		}
//		entityManager.remove( existingJob );
//	}
	@RolesAllowed({"DMIT2015Instructor"})
	public void deleteJob(Job existingJob) {
		existingJob = entityManager.merge(existingJob);
		entityManager.remove( existingJob );
	}
	
	
	public void deleteJobById(String JobId) 
	{
		Job existingJob = findOneJob(JobId);
		deleteJob(existingJob);
	}
	
	public Job findOneJob(String JobId) {
		return entityManager.find(Job.class, JobId);	
	}
	
	public List<Job> findAllJob() {
		return entityManager.createQuery(
			"SELECT e FROM Job e ORDER BY e.jobTitle", Job.class
			).getResultList();
	}
	
	
	
	
	// Location

	public void addLocation (Location newLocation)
	{
		entityManager.persist(newLocation);
	}
	
	public void updateLocation(Location existingLocation)
	{
		entityManager.merge(existingLocation);
	}
	public void deleteLocation(Location existingLocation) throws Exception
	{
		existingLocation = entityManager.merge(existingLocation);
		if(existingLocation.getDepartments().size()>0)
		{
			throw new Exception("A location with department cannot deleted");
		}
		
		entityManager.remove(existingLocation);
	}
	
	public Location findOneLocation(Long LocationId)
	{
		return entityManager.find(Location.class, LocationId);
	}
	
	public List<Location> findAllLocation()
	{
		return entityManager.createQuery(
				"SELECT r FROM Location r ORDER By r.locationId", Location.class
				).getResultList();
	}
	
	
	public Country findOneCountry(String CountryId)
	{
		return entityManager.find(Country.class,CountryId );
	}
	public List<Country> findAllCountries()
	{
		return entityManager.createQuery(
				"FROM Country",Country.class).getResultList();
	}
	
	
	
	
}
