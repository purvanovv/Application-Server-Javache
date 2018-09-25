package main.javache.http;

import java.util.Map;

public interface HttpSessionStorage {
	public Map<String,HttpSession> getAllSessions();
	
	public HttpSession getById(String sessionId);

	public void addSession(HttpSession session);

	public void refreshSession();

}
