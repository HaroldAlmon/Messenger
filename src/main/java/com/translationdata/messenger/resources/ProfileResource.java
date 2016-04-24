package com.translationdata.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.translationdata.messenger.model.Profile;
import com.translationdata.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService = new ProfileService();
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile postProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateMessage(@PathParam("profileName") String name, 
								 Profile profile) {
		profile.setId(profile.getId());
		return profileService.updateProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String name) {
		return profileService.getProfile(name);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String name) {
		profileService.removeProfile(name);
	}
}
