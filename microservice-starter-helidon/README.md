# Microservice Starter based on Oracle Helidon

Oracle Helidon is a collection of Java libraries for writing microservices that run on a fast web core powered by Netty.


### Packaging

Oracle Helidon uses maven dependency plugin for packaging the applcation which put all the runtime dependencies into libs folder.

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-dependency-plugin</artifactId>
  <executions>
    <execution>
    <id>copy-libs</id>
    </execution>
  </executions>
</plugin>
```

It also support uber jar [creation](https://github.com/oracle/helidon/issues/1358) with some [limitation](https://github.com/oracle/helidon/issues/1362) using maven shade plugin.

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
            <transformer implementation="org.apache.maven.plugins.shade.resource.IncludeResourceTransformer">
              <resource>META-INF/beans.xml</resource>
            </transformer>
          <transformer implementation="org.apache.maven.plugins.shade.resource.ServicesResourceTransformer"/>
        </transformers>
      </configuration>
    </execution>
  </executions>
</plugin>
```


### Deployment

Oracle Helidon is full microprofile implementation and support JAXRS out of the box but requires some exlusion which currently does not support uber jar creation.

```
<dependency>
  <groupId>io.helidon.microprofile.bundles</groupId>
  <artifactId>helidon-microprofile</artifactId>
  <exclusions>
    <exclusion>
      <groupId>io.helidon.microprofile.tracing</groupId>
      <artifactId>helidon-microprofile-tracing</artifactId>
    </exclusion>
    <exclusion>
      <groupId>io.helidon.microprofile.metrics</groupId>
      <artifactId>helidon-microprofile-metrics2</artifactId>
    </exclusion>
    <exclusion>
      <groupId>io.helidon.microprofile.jwt</groupId>
      <artifactId>helidon-microprofile-jwt-auth-cdi</artifactId>
    </exclusion>
    <exclusion>
      <groupId>io.helidon.microprofile</groupId>
      <artifactId>helidon-microprofile-fault-tolerance</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

### Launcher

Oracle Helidon provide built in launcher with beans and logging configuration support which can directly run and packaged within jar.

```
<properties>
  <mainClass>io.helidon.microprofile.server.Main</mainClass>
</properties>
```  

#### Dev
```
mvn exec:java
```

#### Prod

```
java - jar target/microservice-starter-helidon.jar
```
  

