import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
 
public class ChatServer {
public static void main (String[] argv) {
    try {
	    	System.setSecurityManager(new RMISecurityManager());
	    	Scanner s = new Scanner(System.in);
	    	System.out.println("Enter your name and press enter:");
	    	String name=s.nextLine().trim();
 
	    	Chat server = new Chat(name);

			Registry registry = LocateRegistry.createRegistry(1900);
 
	    	registry.rebind("rmi://localhost:1900/CHAT", server);
 
	    	System.out.println("[System] Ready to CHAT:");
 
	    	while(true){
	    		String msg = s.nextLine().trim();
	    		if (server.getClient() != null){
	    			ChatInterface client = server.getClient();
	    			msg = "["+server.getName()+"] "+msg;
	    			client.send(msg);
	    		}	
	    	}
 
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
	}
}