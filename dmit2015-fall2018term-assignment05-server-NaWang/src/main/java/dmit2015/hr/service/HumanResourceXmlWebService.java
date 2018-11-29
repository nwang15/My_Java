package dmit2015.hr.service;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import dmit2015.hr.entity.Job;


@WebService(serviceName="HumanResourceService",
			targetNamespace="http://localhost/",
			portName="HumanResourcePort")
public class HumanResourceXmlWebService {

	private int result;
	
	
	
	


	public int luckyLottoNumber() {
		return (int) Math.random()*49+1;
	}
	

	public int sortLuckyNumber()
	{
		for(int num = 1; num <50; num ++ )
		{
			result= num *49 +1;
		}
		return result;
	}
	
	public List<Job> findAllJob() {
		return entityManager.createQuery(
			"SELECT e FROM Job e ORDER BY e.jobTitle", Job.class
			).getResultList();
	}
	
	public Job findOneJob(String JobId) {
		return entityManager.find(Job.class, JobId);	
	}
	
	@PostConstruct
	public void retreiveAllJobs() {
		jobs = hrService.findAllJob();
	}
	
	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}
}
