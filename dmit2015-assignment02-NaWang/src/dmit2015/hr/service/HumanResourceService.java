package dmit2015.hr.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dmit2015.hr.entity.Country;
import dmit2015.hr.entity.Job;
import dmit2015.hr.entity.Location;

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
	
	public Location findOneLocation(int LocationId)
	{
		return entityManager.find(Location.class, LocationId);
	}
	public List<Location> findAllLocation()
	{
		return entityManager.createQuery(
				"SELECT r FROM Location r ORDER By r.locationId", Location.class
				).getResultList();
	}
	
	public Country findOneCountry(int CountryId)
	{
		return entityManager.find(Country.class,CountryId );
	}
	public List<Country> findAllCountries()
	{
		return entityManager.createQuery(
				"FROM COUNTRY",Country.class).getResultList();
	}
	
	
	
	
}
