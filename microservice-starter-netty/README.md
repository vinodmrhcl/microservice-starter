# Microservice Starter project based on Netty

Netty is a well known asyn and event driven client/server framework that support majority of protocol like FTP, SMTP, HTTP and provide low level programming for UDP and TCP applications. On top of that Glassfish provide a special Jersey container that uses it non-blocking IO and HTTP services. It can be used a web service container in simmilar fashion like Grizzly.

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

Like Grizzly, it provide out of the box support for deploying web service build using Jersey and also provide standard container based on Netty HTTP services. 

```
<dependency>
  <groupId>org.glassfish.jersey.containers</groupId>
  <artifactId>jersey-container-netty-http</artifactId>
  <version>2.26</version>
</dependency>
```


## Launcher

Like Grizzly, it provide very abstract API for configuring REST services and running the container.

```
public static void main(String[] args) throws Exception {
  Channel server = NettyHttpContainerProvider.createHttp2Server(new URI("http://localhost:8080/"), new rnd.web.service.rest.AppConfig(), null);

}
```
