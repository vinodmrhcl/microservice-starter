# Microservice Starter project based on Undertow

Undertow is a web server that power up popular JBoss AS and able to run as emebeded container. It provide granular HTTP and non-blocking IO services. On top of that is provide Servlet and Web Socket implementations. It can be used for building micro-services in similar fashion.

- Packaging
- Deployment
- Launcher

## Packaging

We can you use maven standard plugin like assemply and shade for packaging the web service and thier depenencies.

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

Undertow provide a HTTP Servlet container that can be used with Jeresy Servlet container.

```
<dependency>
  <groupId>io.undertow</groupId>
  <artifactId>undertow-servlet</artifactId>
  <version>2.0.3.Final</version>
</dependency

```


## Launcher

It also provide a programatic API to deploy Jersey container and Rest Endpoints.

```
public static void main(String[] args) throws Exception {

  DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(App.class.getClassLoader()) //
    .setContextPath("/").setDeploymentName("star.war")//
    .addServlets(Servlets.servlet("rnd.web.service.rest.App", org.glassfish.jersey.servlet.ServletContainer.class)//
      .addInitParam("javax.ws.rs.Application", "rnd.web.service.rest.AppConfig")//
      .addMapping("/*"));
  DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
  manager.deploy();
  
  PathHandler path = Handlers.path(manager.start());
  
  Undertow server = Undertow.builder().addHttpListener(8080, "localhost").setHandler(path).build();
  server.start();
 }

```
