package com.translationdata.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.translationdata.messenger.model.Message;
import com.translationdata.messenger.model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap() {
		{
			this.put(1L, new Message(1, "Hello Java", "Almon"));
			this.put(2L, new Message(2, "Hello Jersey", "Almon"));
		}
	};
	private static Map<String, Profile> profiles = new HashMap() {
		{
			this.put(1L, new Profile(1, "harold", "Harold", "Almon"));
			this.put(1L, new Profile(1, "harold", "Jack", "Smith"));
		}
	};
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
