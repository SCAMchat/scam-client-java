package main;


import java.net.*;
import java.io.*;

public class Connection {
	private Socket socket;
    private String address;
    DataOutputStream outToServer; 
    BufferedReader inFromServer;

 
    public Connection(String adr) {
    	try {
            address = adr;
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
 
    public boolean connect() {
    	try {
    		socket = new Socket(address,42069);
    		outToServer = new DataOutputStream(socket.getOutputStream());
    		inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		return true;
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }
    
    
    public void sendPacket(String msg) {
    	try {
    		outToServer.write(msg.getBytes());
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    public String recievePacket() {
    	try {
    		return inFromServer.readLine();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return null;
    	}
    }
 
    public void close() {
    	try {
            socket.close();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
