package security.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import security.entity.LoginGroup;
import security.service.LoginService;



@Named
@RequestScoped
public class LoginGroupController {
	
	@Inject
	private Logger logger;
	@Inject
	private LoginService loginService;
	
	private String groupname;

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}		
	
	public List<LoginGroup> retreiveAllLoginGroups() {
		return loginService.findAllLoginGroup();
	}
	
	public void createLoginGroup() {
		try {
			loginService.addLoginGroup(groupname);
			Messages.addGlobalInfo("Group name \"{0}\" was added successfully", groupname);
			groupname = "";
		} catch(Exception e) {
			logger.log(Level.FINE, e.getMessage());			
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void removeLoginGroup(LoginGroup selectedLoginGroup) {
		try {
			loginService.deleteLoginGroup(selectedLoginGroup);
			Messages.addGlobalInfo("Successfully removed \"{0}\"", selectedLoginGroup.getGroupname());
		} catch (Exception e) {
			logger.log(Level.FINE, e.getMessage());
			Messages.addGlobalError("Removal of {0} was not successful.", groupname);
		}	
	}
	
	
	
	
}
