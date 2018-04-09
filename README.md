# Microservice Starter

## Basic Setup

At bare minimum, a micro-service required any of these
- A public API
- A messaging service 
- A task scheduler

To start with, let try to implement simplest of above i.e a A public API exposed as REST endpoints. 

I tried to make it at beginner level and avoided any business level complexity, so that any one can try it without having any background domain knowledge. Also, To maintain compatibility and ease of comparison across various tools/frameworks, I restricted to a single REST controller and method/API.

You can use current repository as base maven dependency.

```
<dependency>
	<groupId>microservice-starter</groupId>
	<artifactId>microservice-starter</artifactId>
	<version>1.0.0</version>
</dependency>
```


It provides a HelloWorldWorldResource as JAX-RS endpoint and a method getHello() as REST API, which can be invoked using below URI

```
http://localhost:8080/helloworld
```

On top of that a micro-service requires it own ability to perform following operation.

- Packaging
- Deployment
- Launcher

You need to refer below specific implementation to see how all this happens for various tools/frameworks.


## Implementations

1. [Spring Boot](https://github.com/ERS-HCL/microservice-starter-springboot)
2. [Tomcat](https://github.com/ERS-HCL/microservice-starter-tomcat)
3. [Jetty](https://github.com/ERS-HCL/microservice-starter-jetty)
4. [Grizzly](https://github.com/ERS-HCL/microservice-starter-grizzly)
5. [Netty](https://github.com/ERS-HCL/microservice-starter-netty)
6. [JBoss Undertow](https://github.com/ERS-HCL/microservice-starter-jboss)
7. [Wildfly Swarm](https://github.com/ERS-HCL/microservice-starter-wildflyswarm)
