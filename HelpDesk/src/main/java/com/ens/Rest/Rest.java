package com.ens.Rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class Rest extends ResourceConfig {

	public Rest() {
		packages("com.ens.Rest.WebService");
	}
}
