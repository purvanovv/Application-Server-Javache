package main.javache;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Set;
import java.util.concurrent.FutureTask;

import main.javache.api.RequestHandler;

public class Server {

	private ServerSocket server;
	
	private Integer port;

	private Set<RequestHandler> requestHandlers;
	
	public Server(Integer port, Set<RequestHandler> requestHandlers) {
		this.port = port;
		this.requestHandlers = requestHandlers;
	}

	public void run() throws IOException {
		this.server = new ServerSocket(this.port);
		System.out.println("Server listening on port:" + port);
		this.server.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);
		while (true) {
			try (Socket clientSocket = this.server.accept()) {
				clientSocket.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);
				System.out.println("Socket timeout");
				ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket, this.requestHandlers);
				FutureTask<?> task = new FutureTask<>(connectionHandler, null);
				task.run();
			} catch (SocketTimeoutException e) {
				e.getMessage();
			}
		}
	}

}
