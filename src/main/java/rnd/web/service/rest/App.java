package rnd.web.service.rest;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class App {

	public static void main(String[] args) throws LifecycleException {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);

		Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

		Wrapper servletWrapper = Tomcat.addServlet(ctx, "rnd.web.service.rest.App", "org.glassfish.jersey.servlet.ServletContainer");
		servletWrapper.addInitParameter("javax.ws.rs.Application", "rnd.web.service.rest.AppConfig");
		ctx.addServletMappingDecoded("/*", "rnd.web.service.rest.App");

		tomcat.start();
		tomcat.getServer().await();
	}

}