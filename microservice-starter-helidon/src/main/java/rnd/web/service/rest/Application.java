package rnd.web.service.rest;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

import io.helidon.common.CollectionsHelper;
import rnd.web.service.rest.HelloWorldResource;

@ApplicationScoped
@ApplicationPath("/")
public class Application extends javax.ws.rs.core.Application {

	@Override
	public Set<Class<?>> getClasses() {
		return CollectionsHelper.setOf(HelloWorldResource.class);
	}
}