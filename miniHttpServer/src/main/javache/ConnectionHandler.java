package main.javache;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Set;
import main.javache.api.RequestHandler;
import main.javache.io.Reader;
import main.javache.io.Writer;

public class ConnectionHandler extends Thread{
	
	private Socket clientSocket;
	
	private InputStream clientSocketInputStream;
	
	private OutputStream clientSocketOutputStream;
	
	private Set<RequestHandler> requestHandlers;

	public ConnectionHandler(Socket clientSocket, Set<RequestHandler> requestHandlers) {
		this.initializeConnection(clientSocket);
		this.requestHandlers = requestHandlers;
	}

	private void initializeConnection(Socket clientSocket) {
		this.clientSocket = clientSocket;
		try {
			this.clientSocketInputStream = this.clientSocket.getInputStream();
			this.clientSocketOutputStream = this.clientSocket.getOutputStream();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		}
		
	@Override
	public void run() {
		try{
			String requestContent = Reader.readAllLines(this.clientSocketInputStream);
			byte[] responseContent = null;
			for(RequestHandler requestHandler : requestHandlers) {
				responseContent = requestHandler.handleRequest(requestContent);
				if(requestHandler.hasIntercepted()) {
					break;
				}
			}
			Writer.writeBytes(responseContent,this.clientSocketOutputStream);
			clientSocket.close();
			clientSocketInputStream.close();
			clientSocketOutputStream.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
	
	
	
	

}
