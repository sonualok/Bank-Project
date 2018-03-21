package org.citybank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Profile;
import com.spring.service.ProfileService;

@RestController
@RequestMapping(value="/profiles")
public class ProfileResource {

	@Autowired
	private ProfileService p;
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public ResponseEntity<ProfileService> getallProfile(){
	return new ResponseEntity<ProfileService>(new ProfileService(p.getAllprofile()),
			                                  HttpStatus.OK);	
	}
	
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public ResponseEntity<Profile> addProfile(@RequestBody Profile profile){
	return new ResponseEntity<Profile>(p.addProfile(profile),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{profileName}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public ResponseEntity<Profile> getProfile(@PathVariable("profileName") String profileName){
	return new ResponseEntity<Profile>(p.getprofile(profileName),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{profileName}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.PUT)
	public ResponseEntity<Profile> updateProfile(@PathVariable("profileName") String profileName,
			                                     @RequestBody Profile profile){
	profile.setProfilename(profileName);	
	return new ResponseEntity<Profile>(p.updateProfile(profile),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{profileName}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.DELETE)
	public ResponseEntity<Profile> deleteProfile(@PathVariable("profileName") String profileName){
	return new ResponseEntity<Profile>(p.removeProfile(profileName),HttpStatus.OK);
	}
}
