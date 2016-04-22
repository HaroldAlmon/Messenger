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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.translationdata.messenger.model.Message;
import com.translationdata.messenger.service.MessageService;

// Maps to http://localhost:8080/Messenger/webapi/messages, case sensitive application name.
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService messageService = new MessageService();
	// Uncomment the JSON support, <artifactId>jersey-media-moxy</artifactId>, in the pom.xml to get JSON support working...
	@GET
	public List<Message> getMessages(@QueryParam("year") int year, 
									 @QueryParam("start") int start, 
									 @QueryParam("size") int size ) {
		if(year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if(start > 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Message postMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@GET
	@Path("/{messageId}")
	// Jersey will cast the String to long...
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
}
