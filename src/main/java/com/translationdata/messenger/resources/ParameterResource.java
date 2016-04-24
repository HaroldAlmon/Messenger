package com.translationdata.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("parameter")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class ParameterResource {
	@GET
	@Path("/annotations")
	public String getParamsUsinsAnnotations(@MatrixParam("size") int size,
											@CookieParam("name") String name,
											@HeaderParam("priorityLevel") String priority) {
		return "Test Params by Annotation.\nSize = " + size + "\nName (Cookie Parameter) = " + name + "\nPriority (Header Parameter)= " + priority;
	}
}
