package com.translationdata.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

@Path("parameter")
public class ParameterResource {
	// http://localhost:8080/messenger/webapi/parameter
	@GET
	public String getParams() {
		return ("getParams() called");
	}
	
	// http://localhost:8080/messenger/webapi/parameter/annotations
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("size") int size,
											@CookieParam("name") String name,
											@HeaderParam("priorityLevel") String priority) {
		return "Test Params by Annotation.\nSize = " + size + "\nName (Cookie Parameter) = " + name + "\nPriority (Header Parameter)= " + priority;
	}

	@GET
	@Path("/context")
	public String getParamsUsingAnnotations(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		return "UriInfo: " + uriInfo.getAbsolutePath() 
				+ "\nHeaders = " + headers.getRequestHeaders().toString()
				+ "\nCookies = " + headers.getCookies().toString();
	}
}
