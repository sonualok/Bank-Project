package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.spring.stubdatabase.DatabaseClass;

import com.spring.model.Profile;
import com.spring.model.Profile;

@XmlRootElement(name = "Profile-list")  
public class ProfileService {
    
	private Map<String, Profile> profiles = DatabaseClass.getProfile(); 
	private List<Profile> ProfileList;  
	
	public ProfileService() {
	profiles.put("Alok", new Profile(1L,"Alok","Alok","Prakash"));
	profiles.put("Sonu", new Profile(2L,"Sonu","Sonu","Badhani"));
	
	}

	public ProfileService(List<Profile> ProfileList) {  
		  this.ProfileList = ProfileList;  
		 }  
	
	@javax.xml.bind.annotation.XmlElement(name = "profile")  
	public List<Profile> getAllprofile(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "Profile2")
	public Profile getprofile(String profileName){
		return profiles.get(profileName);
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "Profile3")
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() +1);
		profiles.put(profile.getProfilename(),profile);
		
		return profile;
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "Profile4")
	public Profile updateProfile(Profile profile){
		if(profile.getProfilename().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfilename(),profile);
		return profile;
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "Profile5")
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
