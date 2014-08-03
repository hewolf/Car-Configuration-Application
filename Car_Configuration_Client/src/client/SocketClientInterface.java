package client;

/* Controls the actions for socket client */

public interface SocketClientInterface{
	boolean openConnection();
    void handleSession();
    void closeSession();
}
