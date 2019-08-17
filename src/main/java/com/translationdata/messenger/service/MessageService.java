package com.translationdata.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.translationdata.messenger.database.DatabaseClass;
import com.translationdata.messenger.model.Message;

// http://localhost:8080/messenger/webapi/messages
public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();

// This gets executes on every HTTP request so it never remembers changes to the data...
/*	public MessageService() {
		{
		messages.put(1L, new Message(1, "Hello Java", "Almon"));
		messages.put(2L, new Message(2, "Hello Jersey", "Almon"));
		}
	}*/
	
	public List<Message> getAllMessages() {
				
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public void removeMessage(long id) {
		messages.remove(id);
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> list = new ArrayList<>(messages.values());
		if(start - 1 + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start - 1, start - 1 + size);
	}
}
