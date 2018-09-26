package main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import main.casebook.CaseBookApplication;
import main.database.entities.User;
import main.database.repositories.UserRepository;
import main.javache.Server;
import main.javache.api.RequestHandler;
import main.javache.http.HttpSessionStorage;
import main.javache.http.HttpSessionStorageImpl;

public class StartUp {
	public static void main(String args[]) throws IOException {
	//	Server server = new Server(8080,initializeApplications());
	//	server.run();
		
		User user = new User();
		user.setPassword("1234");
		user.setUsername("penka");
		UserRepository repository = new UserRepository();
		repository.save(user);
		repository.close();
	}
	
	private static Set<RequestHandler> initializeApplications() {
		Set<RequestHandler> requestHandlers = new HashSet<>();
		requestHandlers.add(new CaseBookApplication(getSessionStorage()));
		return requestHandlers;
		
	}
	
	private static HttpSessionStorage getSessionStorage() {
		return new HttpSessionStorageImpl();
	}
	
}