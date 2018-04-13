# Microservice Starter based on Spring Boot

Spring Boot is very popular framework for building microservice now a day as it has build in feature/support to fulfill all lifecycle stages

- Development 
- Packaging
- Deployment
- Launcher
- Monitoring

We are not covering development and monitoring here as it is out of scope becuase we are building the starter based on JAX-RS/JEE specification.

## Packaging
Spring Boot provide it own maven support to package the code and its all dependency as Uber jar including the container itself. For this, you need to add following build plugin and a simple `repackage` goal that repackage the binary built during normal maven `package` phase.

```
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <executions>
        <execution>
          <goals>
            <goal>repackage</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>

```

## Deployment

Spring Boot comes with differnce type of web container to support embbeded deployment of web Resources like Servlets/JSP.

- Tomcat
- Jetty
- Undertow

On top of that, it provides a Jersey container that can deploy RESTful resources. For that you need add following dependency to you maven build.

```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-jersey</artifactId>
</dependency>

```


## Launcher

Spring Boot has made launching an application as easy as run the Hello World program. Only 1 line of code trigger all the dependency management, package scan, container intialization etc. 

Just add follwing line into your main class and it will do the rest for you.

```
public static void main(String[] args) {
  SpringApplication.run(new Object[] { AppConfig.class }, args);
}
```






