package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	private String id;
	
	private boolean editMode = false;
	
	//private Integer selectLocationId;
	
	private String selectCountryId = null;
	
	public String createLocation()
	{
		String outcome = null;
		try
		{
			if(selectCountryId !=null && !selectCountryId.isEmpty())
			{
				Country selectCountry = humanResourceService.findOneCountry(selectCountryId);
				
;			}
		} catch 
	}
	
	
	
	public List<Location> retreiveAllLocations() {
		return humanResourceService.findAllLocation();
	}
	
	
	public Location getLocationDetail() {
		return locationDetail;
	}

	public void setLocationDetail(Location locationDetail) {
		this.locationDetail = locationDetail;
	}

	public String getId() {
		return id;
	}


	public String getSelectCountryId() {
		return selectCountryId;
	}



	public void setSelectCountryId(String selectCountryId) {
		this.selectCountryId = selectCountryId;
	}



	public void setId(String id) {
		this.id = id;
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
