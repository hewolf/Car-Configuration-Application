package server;

/* This is a server that communicates with the client throught a socket */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket = null;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(18999);
			System.out.println("Listening on port 18999");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runServer() {
		DefaultSocketServer defaultClientSocket = null;
		try {
			while(true) {
				Socket socket = serverSocket.accept();
				defaultClientSocket = new DefaultSocketServer(serverSocket, socket);
	            defaultClientSocket.start();
			}
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.runServer();
	}
}
