# Microservice Starter project based on Jetty

Jetty is perfect fit for deploying and running micro-service as it mostly used an emebeded container for running web applications. It also follows the same pattern as Tomcat to run micro-services 

- Packaging
- Deployment
- Launcher

## Packaging

Like Tomcat, It can utilize maven standard plugins to packing your code and dependencies in a single uber jar.

```
<build>
  <plugins>
    <plugin>
      <artifactId>maven-assembly-plugin</artifactId>
      <version>3.1.0</version>
      <configuration>
        <descriptorRefs>
          <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
          <manifest><mainClass>rnd.web.service.rest.App</mainClass></manifest>
        </archive>
      </configuration>
      <executions>
        <execution>
          <id>make-assembly</id>
          <phase>package</phase>
          <goals>
            <goal>single</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>

```

## Deployment

Jetty provide a servlet container that can be topped up by Jersey container to serve web services.

```
<dependency>
  <groupId>org.eclipse.jetty</groupId>
  <artifactId>jetty-servlet</artifactId>
  <version>9.4.8.v20171121</version>
</dependency>

```


## Launcher

Like Tomcat, it provide a similar programatic API to deploy Jersey container and Rest Endpoints.


```
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

```


