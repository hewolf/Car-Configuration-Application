package server;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class DefaultSocketServer extends Thread implements
		SocketClientInterface, SocketClientConstants {
	private String strHost;
	private int iPort;
	private Socket socket;
	ServerSocket serverSocket;

	ObjectInputStream ois = null;
	BufferedInputStream in2 = null;
	FileOutputStream inFile = null;

	String filename = "serverReceived.cfg";
	AutoServer iAutoServer = new BuildCarModelOptions();

	public DefaultSocketServer(String strHost, int iPort) {
		setPort(iPort);
		setHost(strHost);
	}// constructor

	public DefaultSocketServer(ServerSocket serverSocket, Socket sock) {
		this.serverSocket = serverSocket;
		this.socket = sock;
	}

	public void run() {
		if (openConnection()) {
			handleSession();
			// closeSession();
		} else {
			System.out.println("failed to open connection");
		}
	}

	public boolean openConnection() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void handleSession() {
		try {
			ois.skip(Long.MAX_VALUE);
			String clientOption = (String) ois.readObject();
			System.out.println("from client, clientOption: " + clientOption);

			if (clientOption.equals("upload")) {
				byte[] b = new byte[1024];
				int len = 0;
				int bytcount = 1024;
				File file = new File(filename);
				inFile = new FileOutputStream(file);
				InputStream is = socket.getInputStream();
				in2 = new BufferedInputStream(is, 1024);
				while ((len = in2.read(b, 0, 1024)) != -1) {
					bytcount = bytcount + 1024;
					inFile.write(b, 0, len);
				}
				System.out.println("Bytes Writen : " + bytcount);

				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());

				oos.flush();
				oos.writeObject("ok");
				System.out.println("Message sent to the client is " + "ok");

				iAutoServer.buildwithProperty(filename);
			} else if (clientOption.equals("configure")) {
				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());
				oos.flush();

				ArrayList<String> availableModels = iAutoServer.getModelList();
	
				System.out.println(availableModels.toString());
				oos.writeObject(availableModels);
				oos.flush();
				System.out.println("Message sent to the client is " + "ok");

				String configModel = (String) ois.readObject();
				System.out.println("Client want to config: " + configModel);

				iAutoServer.sendSelectedAuto(oos, configModel);
			} else {
				System.err.println("Invalid input from client!!!!!!!!!!");
			}

		} catch (EOFException eof) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleInput(String strInput) {
		System.out.println(strInput);
	}

	public void closeSession() {
		try {
			in2.close();
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setHost(String strHost) {
		this.strHost = strHost;
	}

	public void setPort(int iPort) {
		this.iPort = iPort;
	}
}
