package com.translationdata.messenger.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.translationdata.messenger.model.Message;
import com.translationdata.messenger.service.MessageService;

// Maps to http://localhost:8080/Messenger/webapi/messages, case sensitive application name.
@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	// Jersey will cast the String to long...
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}
}
