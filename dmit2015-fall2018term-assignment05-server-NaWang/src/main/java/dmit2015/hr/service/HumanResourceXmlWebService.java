package dmit2015.hr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import dmit2015.hr.entity.Job;


@WebService(serviceName="HumanResourceService",
			targetNamespace="http://localhost/",
			portName="HumanResourcePort")
public class HumanResourceXmlWebService {

	@Inject
	private EntityManager entityManager;
	

	@WebMethod
	public int luckyLottoNumber() {
		return new Random().nextInt(49) +1;
	}
	

	public @WebResult(name="LuckyNumber") 
	String sortLuckyNumber (@WebParam(name="times") int count) {
		String result="";		
		Random random = new Random();
	    ArrayList<Integer> arrayList = new ArrayList<Integer>();	    	    
	    while (arrayList.size() < count) { // how many numbers u need - it will count
	    	int a =0;
	        a = random.nextInt(49)+1; // this will give numbers between 1 and 50.

	        if (!arrayList.contains(a)) {
	            arrayList.add(a);
	        }	        	        
	    }
	    Collections.sort(arrayList);	  	    
	   
	    for (int item:arrayList)
	    {
	    	result+=item+" ";
	    }	
	    
	    return result;
	  }
	    public @WebResult(name="allJobs") List<Job> findAllJobs() {
			return entityManager.createQuery(
				"SELECT j FROM Job  j ORDER BY j.jobId",Job.class
				).getResultList();
		}
		
		
		public @WebResult(name="findOneJob") Job findOneJob(@WebParam(name="jobid") String jobId) {
			return entityManager.find(Job.class, jobId);	
		}
	
	
}
