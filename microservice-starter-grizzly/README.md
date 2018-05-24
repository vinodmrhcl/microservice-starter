# Microservice Starter project based on Grizzly

Grizzly is not so popular web container but it power up the most standard Application Server for JEE community and serve as RI for them. Yes, it's the engine behind Glassfish server. It does provide out of the box features for building micro services.

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

Unlike Tomcata and Jetty, it provide out of the box support for deploying web service build using Jersey and also provide standard container based on Grizzaly HTTP services. 

```
<dependency>
  <groupId>org.glassfish.jersey.containers</groupId>
  <artifactId>jersey-container-grizzly2-http</artifactId>
  <version>2.26</version>
</dependency>
```


## Launcher

Like Spring Boot, it provide very abstract API for configuring REST services and running the container itself and that within single line of code.

```
public static void main(String[] args) throws Exception {
  GrizzlyHttpServerFactory.createHttpServer( new URI("http://localhost:8080/"), new rnd.web.service.rest.AppConfig()).start();
}
```


