package rnd.web.service.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		context.setResourceBase(System.getProperty("java.io.tmpdir"));
		server.setHandler(context);

		ServletHolder servletHolder = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		servletHolder.setInitParameter("javax.ws.rs.Application", "rnd.web.service.rest.AppConfig");

		server.start();
		server.join();
	}

}