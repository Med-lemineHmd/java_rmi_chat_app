import java.rmi.*;
 
public interface ChatInterface extends Remote{
	// getName() : Cette méthode récupère le nom de l’utilisateur connecté.
	public String getName() throws RemoteException;
	//  send(String msg) : Cette méthode permet d’envoyer un message
	public void send(String msg) throws RemoteException;
	//  setClient(ChatInterface c): Cette méthode associé un client au serveur
	public void setClient(ChatInterface c) throws RemoteException;
	//  getClient() : Cette méthode récupère l’objet client.
	public ChatInterface getClient() throws RemoteException;
}