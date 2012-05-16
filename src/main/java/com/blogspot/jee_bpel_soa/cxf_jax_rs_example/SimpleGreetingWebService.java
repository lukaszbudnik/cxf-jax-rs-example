package com.blogspot.jee_bpel_soa.cxf_jax_rs_example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;

@Path("/greetings")
@Produces("text/plain")
public class SimpleGreetingWebService {
	
	@GET
	@Path("/name/{name}")
	public String sayHi(@PathParam("name") String name) {
		return "Hi " + name + "! How are you!";
	}

	@GET
	@Path("/name/{name}/state/{state}")
	public String sayHi(@PathParam("name") String name,
			@PathParam("state") String state) {
		return sayHi(name) + " Do you like " + state + "?";
	}

	@GET
	@Path("/name/{name}/state/{state}/{params:.*}")
	public String sayHi(@PathParam("name") String name,
			@PathParam("state") String state,
			@PathParam("params") String paramsAsString,
			@PathParam("params") List<PathSegment> paramsAsList,
			@Context HttpServletRequest request) {
		return "response from application " + request.getContextPath() + " " + sayHi(name, state) + " You like to pass params? " 
				+ paramsAsString;
	}
}
