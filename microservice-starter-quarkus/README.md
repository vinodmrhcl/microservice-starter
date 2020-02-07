# Microservice Starter based on Red Hat Quarkus

Red Hat Quarkus is supersonic, subatomic Java framework for creating cloud native apps and services using JEE specification. It supports full project lifecycle using its own maven dependency management and build plugin.


### Packaging

Red Hat Quarkus provides its own maven support to package the code and it's all dependency as Uber jar including the container itself. For this, you need to add following build plugin.

```
<build>
  <plugins>
    <plugin>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-maven-plugin</artifactId>
      <version>${quarkus.version}</version>
      <executions>
        <execution>
          <goals>
            <goal>build</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

### Deployment

Red Hat Quarkus provide multiple embeddable container that can be that can be used dependency. JAX-RS support is provided by resteasy container.

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-resteasy</artifactId>
</dependency>
```

### Launcher

Red Hat Quarkus container can be launched using multiple options

- Dev - Just run following maven goal on project.

```
mvn quarkus:dev
```

- Prod - The maven package generate a fat jar which contain generated main class and JAX-RS application which can be run using plain java.

```
java -jar java -jar target\microservice-starter-quarkus-1.0.0-runner.jar
```
