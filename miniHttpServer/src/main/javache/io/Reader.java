package main.javache.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//final - ne moje da se nasledqva
public final class Reader {

	public Reader() {
	}
	
	public static String readAllLines(InputStream inputStream) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder result = new StringBuilder();
		
		while(buffer.ready()) {
			result.append((char)buffer.read());
		}
		return result.toString();
	}
	
}
