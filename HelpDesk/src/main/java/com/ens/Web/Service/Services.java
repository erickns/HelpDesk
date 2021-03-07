package com.ens.Web.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class Services {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/testeService")
	public String testeServiçe() {
		String string = "";
		return string;
	}

}
