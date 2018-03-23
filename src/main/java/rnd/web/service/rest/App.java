package rnd.web.service.rest;

import java.net.URI;

import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;

import io.netty.channel.Channel;

public class App {

	public static void main(String[] args) throws Exception {

		final Channel server = NettyHttpContainerProvider.createHttp2Server(new URI("http://localhost:8080/"), new rnd.web.service.rest.AppConfig(), null);

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				server.close();
			}
		}));

		Thread.currentThread().join();
	}

}