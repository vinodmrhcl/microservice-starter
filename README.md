# Microservice Starter
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FERS-HCL%2Fmicroservice-starter.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FERS-HCL%2Fmicroservice-starter?ref=badge_shield)


## Basic Setup

At bare minimum, a micro-service required any of these
- A web API
- A messaging service 
- A scheduled task/function 

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

### Servers
1. [Tomcat](microservice-starter-tomcat)
2. [Jetty](microservice-starter-jetty)
3. [Grizzly](microservice-starter-grizzly)
4. [Netty](microservice-starter-netty)
5. [Undertow](microservice-starter-undertow)

### Platform
1. [Spring Boot](microservice-starter-springboot)
2. [Wildfly Swarm](microservice-starter-wildflyswarm)
3. [Red Hat Quarkus](microservice-starter-quarkus)
4. [Oracle Helidon](microservice-starter-helidon)
5. [Micronaut](microservice-starter-micronaut)

## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FERS-HCL%2Fmicroservice-starter.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2FERS-HCL%2Fmicroservice-starter?ref=badge_large)
