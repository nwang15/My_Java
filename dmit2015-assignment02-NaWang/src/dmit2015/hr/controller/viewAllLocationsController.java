package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dmit2015.hr.entity.Location;
import dmit2015.hr.service.HumanResourceService;

@Named
@ViewScoped
public class viewAllLocationsController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private HumanResourceService humanResourceService;
	
	private List<Location> locations;
	
	@PostConstruct
	public void retreiveAllLocations()
	{
		locations = humanResourceService.findAllLocation();
	}
	
	@Produces
	@Named	
	public List<Location> getLocations()
	{
		return locations;
	}
	
//    @PostConstruct
//	public List<Location> retrieveAllLocation() {
//		return humanResourceService.findAllLocation();
//	}
	@PostConstruct
	public void onLocationListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Location country) {
		retreiveAllLocations();
	}
	
	
	
	
	
	
	
}
