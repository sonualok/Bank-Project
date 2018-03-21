package org.spring.stubdatabase;

import java.util.HashMap;
import java.util.Map;
import com.spring.model.*;

public class DatabaseClass {

	private static Map<Long,Message> message = new HashMap<Long, Message>();
    private static Map<String,Profile> profile = new HashMap<String, Profile>();
	
    public static Map<Long, Message> getMessage() {
		return message;
	}
	public static Map<String, Profile> getProfile() {
		return profile;
	}
    
    
	
}
