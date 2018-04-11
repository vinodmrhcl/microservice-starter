package rnd.web.service.rest;

import java.net.URI;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class App {

	public static void main(String[] args) throws Exception {

		GrizzlyHttpServerFactory.createHttpServer(//
				new URI("http://localhost:8080/"), //
				new rnd.web.service.rest.AppConfig(//
				)).start();
	}

}