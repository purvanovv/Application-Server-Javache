package main;

import java.io.IOException;

import main.javache.Server;

public class StartUp {
	public static void main(String args[]) throws IOException {
		Server server = new Server(8080);
		server.run();
	}
}
