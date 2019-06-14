package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBAccessException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.hr.entity.Country;
import dmit2015.hr.entity.Location;
import dmit2015.hr.service.HumanResourceService;


@Named("currentLocationController")
@ViewScoped
public class LocationController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HumanResourceService humanResourceService;
	
	private Location locationDetail;
	
	private Long id;
	
	private boolean editMode = false;
	
	//private Integer selectLocationId;
	
	private String selectCountryId = null;
	
	
	@PostConstruct 
	public void init()
	{
		locationDetail = new Location();
	}
	public String createLocation()
	{
		String outcome = null;
		
		try
		{
			if(selectCountryId !=null && !selectCountryId.isEmpty())
			{
				Country selectCountry = humanResourceService.findOneCountry(selectCountryId);
				locationDetail.setCountry(selectCountry);
				humanResourceService.addLocation(locationDetail);
				locationDetail = new Location();
				Messages.addFlashGlobalInfo("Create was successful.");
				outcome = "viewLocations?faces-redirect=true";
				
;			}
			else
			{
				Messages.addGlobalError("Create was not successful. Country is required.");
			}
		}catch(EJBAccessException e)
		{
			Messages.addGlobalError(e.getMessage());			
		}catch(Exception e)
		{
			Messages.addGlobalError("create was not successful.");
		}
		
		return outcome;
	}
	
	public void findLocationById()
	{
		if(id !=null && id !=0)
		{
			Location item= humanResourceService.findOneLocation(id);
			if(item == null)
			{
				Messages.addGlobalError("Bad request. Unknown id {0}.", id);
				
			}else
			{
				editMode = true;
				locationDetail = item;
				selectCountryId = locationDetail.getCountry().getCountryId();
			}

		}
	}
	
	public String updateLocation()
	{
		String outcome = null;
		
		try
		{
			if(selectCountryId !=null && !selectCountryId.isEmpty())
			{
				Country selectCountry = humanResourceService.findOneCountry(selectCountryId);
				locationDetail.setCountry(selectCountry);
				humanResourceService.updateLocation(locationDetail);
				locationDetail = new Location();
				Messages.addFlashGlobalInfo("Update was successful.");
				editMode = false;
				outcome = "viewLocations?faces-redirect=true";	
				
			}else
			{
				Messages.addGlobalError("Update was not successful. Country is required");
			}
		}catch(EJBAccessException e)
		{
			Messages.addGlobalError(e.getMessage());			
		}catch(Exception e)
		{
			Messages.addGlobalError("update was not successful.");
		}
		
		return outcome;
	}
	
	public String remmoveLocation()
	{
		String outcome = null;
		try
		{
			humanResourceService.deleteLocation(locationDetail);
			Messages.addFlashGlobalInfo("Remove Location {0} was successful", 
					locationDetail.getLocationId());
			locationDetail = new Location();
			editMode = false;
			outcome = "viewLocations?faces-redirect=true";
			
		}catch(EJBAccessException e)
		{
			Messages.addGlobalError(e.getMessage());			
		}catch(Exception e)
		{
			Messages.addGlobalError("Remove was not successful.");
		}
		
		return outcome;
	}
	
	//List and Cancle
	public List<Location> retreiveAllLocations() {
		return humanResourceService.findAllLocation();
	}
	
	public List<Country> retreiveAllCountry()
	{
		return humanResourceService.findAllCountries();
	}
	public String cancel() {
		editMode = false;
		return "viewLocations?faces-redirect=true";
	}
	
	
	
	
	
	// getter and setter
	public Location getLocationDetail() {
		return locationDetail;
	}

	public void setLocationDetail(Location locationDetail) {
		this.locationDetail = locationDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSelectCountryId() {
		return selectCountryId;
	}

	public void setSelectCountryId(String selectCountryId) {
		this.selectCountryId = selectCountryId;
	}


	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
//
//	public Integer getSelectLocationId() {
//		return selectLocationId;
//	}
//
//	public void setSelectLocationId(Integer selectLocationId) {
//		this.selectLocationId = selectLocationId;
//	}

	
	
}
