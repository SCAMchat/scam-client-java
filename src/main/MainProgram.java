package main;
import javax.swing.JOptionPane;

public class MainProgram {
    
    String host;
    String chatroom;
    String version="1.0";
    Interface frame;
    String URI;
    String token;
    Connection connection;
    
    public static void main(String[] args){
        MainProgram p= new MainProgram();
    }
    
    public MainProgram(){
        host = JOptionPane.showInputDialog("Input Host");
        chatroom = JOptionPane.showInputDialog("Input Chatroom ID");
        frame=new Interface(this);
        URI="scam+"+version+"://"+host+"/"+chatroom;
        frame.URIfield.setText(URI);
        connect();
    }
    
    public void connect(){
        frame.addLine("[LOG]connecting to chatroom "+chatroom+" at host "+host);
    	String h=URI.substring(URI.indexOf("://")+3,URI.lastIndexOf('/'));
    	
    	connection = new Connection(h);
    	if(connection.connect()) {
    		frame.addLine("[LOG]successfully connected");
    	}else {
    		frame.addLine("[LOG]connection error");
    	}
    	
    }
    
    public void disconnect() {
    	connection.close();
    	frame.addLine("[LOG]successfully disconnected");
    }
    
    public void send(String msg) {
    	System.out.println(msg);
    	connection.sendPacket(msg);
    }
    
    public void setURI(String u) {
    	URI=u;
    	disconnect();
    	connect();
    }
    
}
