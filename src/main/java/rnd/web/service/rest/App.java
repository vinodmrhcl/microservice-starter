package rnd.web.service.rest;

import javax.servlet.ServletException;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

public class App {

	public static void main(String[] args) throws ServletException {

		DeploymentInfo servletBuilder = Servlets.deployment() //
				.setClassLoader(App.class.getClassLoader()) //
				.setContextPath("/") //
				.setDeploymentName("star.war")//
				.addServlets(//
						Servlets.servlet("rnd.web.service.rest.App", org.glassfish.jersey.servlet.ServletContainer.class)//
								.addInitParam("javax.ws.rs.Application", "rnd.web.service.rest.AppConfig")//
								.addMapping("/*"));

		DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
		manager.deploy();

		PathHandler path = Handlers.path(manager.start());

		Undertow server = Undertow.builder()//
				.addHttpListener(8080, "localhost")//
				.setHandler(path)//
				.build();

		server.start();

	}

}