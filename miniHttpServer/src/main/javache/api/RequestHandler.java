package main.javache.api;

public interface RequestHandler {
	public byte[] handleRequest(String requestContent);
	
	public boolean hasIntercepted();
}
