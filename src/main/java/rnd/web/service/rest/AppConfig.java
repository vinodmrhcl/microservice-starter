package rnd.web.service.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {

	public AppConfig() {
		register(HelloWorldResource.class);
	}
}