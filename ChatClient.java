import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
 
public class ChatClient {
	public static void main (String[] argv) {
	    try {
		    	System.setSecurityManager(new RMISecurityManager());
		    	Scanner s = new Scanner(System.in);
		    	System.out.println("Enter your name and press enter:");
		    	String name = s.nextLine().trim();		    		    	
		    	ChatInterface client = new Chat(name);

				Registry registry = LocateRegistry.getRegistry(1900); //default null on port 1099
 
		    	ChatInterface server = (ChatInterface)registry.lookup("rmi://localhost:1900/CHAT");
		    	String msg = "["+client.getName()+"] is connected";
		    	server.send(msg);
		    	System.out.println("[System] Ready to CHAT:");
		    	server.setClient(client);
 
		    	while(true){
		    		msg = s.nextLine().trim();
		    		msg = "["+client.getName()+"] "+msg;		    		
	    			server.send(msg);
		    	}
 
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
}