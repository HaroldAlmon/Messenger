package com.translationdata.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	// http://localhost:8080/messenger/webapi/
	@GET
	public String getComments(@PathParam("messageId") long messageId) {
		return "All comments, Message Id = " + messageId;
	}

	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return "Generic comment, Message Id = " + messageId + ", comment = " + commentId;
	}
}
