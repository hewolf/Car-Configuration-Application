package client;

/* Default socket client which handles the file and message communication with 
 * the socket server. 
 * */

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import model.Automobile;

public class SocketClient extends Thread implements SocketClientInterface,
		SocketClientConstants {
	private Socket sock;
	private String strHost;
	private int iPort;
	private Socket socket;
	
	ObjectOutputStream oos = null;
	BufferedOutputStream out = null;
	FileInputStream in = null;

	public SocketClient(String strHost, int iPort) {
		setPort(iPort);
		setHost(strHost);
	}

	public SocketClient(Socket sock) {
		this.sock = sock;
	}

	public void setHost(String strHost) {
		this.strHost = strHost;
	}

	public void setPort(int iPort) {
		this.iPort = iPort;
	}

	public void run() {
		while(true) {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
		}
	}

	public boolean openConnection() {
		try {
			socket = new Socket("localhost", 18999);
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException socketError) {
			socketError.printStackTrace();
			return false;
		}
		return true;
	}

	public void handleSession() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to Car Configuration Tool!");
			System.out.println("Please enter 'upload' or 'configure': ");

			String userOption = scanner.nextLine();
			oos.flush();

			if (userOption.equals("upload")) {
				oos.writeObject("upload");
				System.out.println("Input file path:");
				String propertyFileLocation = scanner.nextLine();

				File file = new File(propertyFileLocation);
				byte[] buf = new byte[1024];

				OutputStream os = socket.getOutputStream();

				out = new BufferedOutputStream(os, 1024);
				in = new FileInputStream(file);

				int i = 0;
				int bytecount = 1024;
				while ((i = in.read(buf, 0, 1024)) != -1) {
					bytecount = bytecount + 1024;
					out.write(buf, 0, i);
					out.flush();
				}

				socket.shutdownOutput();
				System.out.println("Bytes Sent test :" + bytecount);

				ObjectInputStream ois = new ObjectInputStream(
						socket.getInputStream());

				ois.skip(Long.MAX_VALUE);
				String confirmation = (String) ois.readObject();
				System.out.println("from server : " + confirmation);

			} else if (userOption.equals("configure")) {
				oos.writeObject("configure");
				oos.flush();
				ObjectInputStream ois = new ObjectInputStream(
						socket.getInputStream());
				ois.skip(Long.MAX_VALUE);	
				@SuppressWarnings("unchecked")
				ArrayList<String> readObject = (ArrayList<String>) ois.readObject();
				ArrayList<String> autoModelList = readObject;
				System.out.println("from server autoModelList: ");
				System.out.println(autoModelList);

				System.out.println("Enter the model name to configure:");
				String configModel = scanner.nextLine();
				oos.writeObject(configModel);
				oos.flush();

				Automobile configAuto = (Automobile) ois.readObject();
				if (configAuto != null) {
					System.out.println("Received config model from server:");
					configAuto.print();

					// Test make choice module
					configAuto.makeChoice();
					configAuto.printChoice();
				}

			} else {
				System.err.println("Invalid input!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeSession() {
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		String strLocalHost = "";
		try {
			strLocalHost = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.err.println("Unable to find local host");
		}
		SocketClient client;
		try {
			client = new SocketClient(new Socket("localhost", 18999));
			client.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
