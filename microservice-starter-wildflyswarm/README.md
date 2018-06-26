
# Microservice Starter based on Wildfly Swarm

Wildfly Swarm is lightweight container for deploying apps and services using various JEE specification. It supports full project lifecycle using its own maven dependency management and build plugin.


### Packaging

Wildfly Swarm provides its own maven support to package the code and it's all dependency as Uber jar including the container itself. For this, you need to add following build plugin.

```
<build>
  <plugins>
    <plugin>
      <groupId>org.wildfly.swarm</groupId>
      <artifactId>wildfly-swarm-plugin</artifactId>
      <version>2018.3.3</version>
      <executions>
        <execution>
          <goals><goal>package</goal></goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

### Deployment

Wildfly Swarm is an embeddable container that provide support for multiple deployment options. It can deploy Web, JAXRS and EJB containers. You can add specific fraction for deploying only required container.

```
<dependency>
  <groupId>org.wildfly.swarm</groupId>
  <artifactId>jaxrs</artifactId>
  <version>2018.3.3</version>
</dependency>
```

### Launcher

Wildfly Swarm container can be launched using standard as well customer launchers.

- Standard - Just run following maven goal on project.

```
mvn wildfly-swarm:run
```

- Custom - Add an Application class to programmatically invoke and deploy containers. 

```
Swarm swarm = new Swarm();
swarm.start();

JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
deployment.addClass(HelloWorldResource.class);
swarm.deploy(deployment);

```
Note : Here we are using [ShrinkWrap](https://developer.jboss.org/wiki/ShrinkWrap) API to programmatically create deployable archive on runtime.
