package main.javache.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpSessionStorageImpl implements HttpSessionStorage {
	private HashMap<String, HttpSession> allSessions;

	public HttpSessionStorageImpl() {
		this.allSessions = new HashMap<>();
	}
	public Map<String,HttpSession> getAllSessions(){
		return this.allSessions;
	}

	public HttpSession getById(String sessionId) {
		if (!this.allSessions.containsKey(sessionId)) {
			return null;
		}

		return this.allSessions.get(sessionId);

	}

	public void addSession(HttpSession session) {
		this.allSessions.putIfAbsent(session.getId(), session);
	}

	public void refreshSession() {
		List<String> idsToRemove = new ArrayList<>();

		for (HttpSession session : allSessions.values()) {
			if (!session.isValid()) {
				idsToRemove.add(session.getId());
			}
			for (String id : idsToRemove) {
				this.allSessions.remove(id);
			}
		}
	}
}
