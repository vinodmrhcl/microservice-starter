# Microservice Starter based on Micronaut

A modern, JVM-based, full-stack framework for building modular, easily testable microservice and serverless applications.


### Packaging

Micronaut uses maven shade plugin for packaging the applcation which put all the runtime dependencies an uber jar.

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-shade-plugin</artifactId>
    <executions>
      <execution>
      <phase>package</phase>
      <goals>
        <goal>shade</goal>
      </goals>
        <configuration>
          <transformers>
            <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
              <mainClass>${mainClass}</mainClass>
            </transformer>
          <transformer implementation="org.apache.maven.plugins.shade.resource.ServicesResourceTransformer"/>
        </transformers>
      </configuration>
    </execution>
  </executions>
</plugin>
```


### Deployment

Micronaut supports http deployment based on netty server and [partial/compatible support](https://github.com/micronaut-projects/micronaut-jaxrs/blob/master/src/main/docs/guide/introduction.adoc) for JAX-RS resrouces.

```
<dependencies>
  <dependency>
    <groupId>io.micronaut.jaxrs</groupId>
    <artifactId>micronaut-jaxrs-server</artifactId>
    <version>1.0.0.M1</version>
  </dependency>
  <dependency>
    <groupId>io.micronaut</groupId>
    <artifactId>micronaut-runtime</artifactId>
  </dependency>
  <dependency>
    <groupId>io.micronaut</groupId>
    <artifactId>micronaut-http-server-netty</artifactId>
    </dependency>
</dependencies>
```

In addition to these it required additional plugins/ dependecies at compile phase to process its annotations.

```
<annotationProcessorPaths>
  <path>
    <groupId>io.micronaut</groupId>
    <artifactId>micronaut-inject-java</artifactId>
  </path>
  <path>
    <groupId>io.micronaut</groupId>
    <artifactId>micronaut-validation</artifactId>
  </path>
  <path>
    <groupId>io.micronaut.jaxrs</groupId>
    <artifactId>micronaut-jaxrs-processor</artifactId>
  </path>
</annotationProcessorPaths>

```

### Launcher

Micronaut provides build in runner class that can be invoked through main class.

```
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
```

which can be trigger in multiple ways.

#### Dev

```
mvn exec:java
```

#### Prod

```
java - jar target/microservice-starter-helidon.jar
```

