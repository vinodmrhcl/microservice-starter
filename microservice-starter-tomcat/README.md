# Microservice Starter project based on Tomcat

Tomcat is generally use as web container for deploying web application. But it can also be used as a emebeded container for running packaged micro-services. For this it requries below thing in place to make a contained micro-service.

- Packaging
- Deployment
- Launcher

## Packaging

Unlike Spring Boot, it does not provide out of box solution for packing your micro-service, but you can use maven standard plugin like assemble and shade to build a uber jar that contain all the dependencies and support main class manifiests.

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

All the tomcat runtime modules can be provided with a single dependency that can deploy and run the Jersey container.

```
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-core</artifactId>
  <version>8.5.15</version>
</dependency>
```


## Launcher

Tomcat allows you to configure your endpoint and container programatically, Also you can start and stop the instance within your control.


```
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

```



