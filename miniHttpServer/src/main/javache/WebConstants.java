package main.javache;

public class WebConstants {
	static final String serverName = "Javache/1.0";
	static final int SOCKET_TIMEOUT_MILLISECONDS = 1000000;
	public static final String SERVER_HTTP_VERSION = "HTTP/1.1";
	public static final String PROJECT_DIRECTORY = System.getProperty("user.dir");
	public static final String HTML_EXTENSION_AND_SEPARATOR = ".html";
	public static final String ASSETS_FOLDER_PATH = PROJECT_DIRECTORY.concat("\\src\\main\\resources\\assets\\");
	public static final String PAGES_FOLDER_PATH = PROJECT_DIRECTORY.concat("\\src\\main\\resources\\pages\\");
}
