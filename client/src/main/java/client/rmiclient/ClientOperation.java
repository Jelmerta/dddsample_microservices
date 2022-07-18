package client.rmiclient;

import client.rmiinterface.RMIInterface;
import se.citerus.dddsample.client.location.UnLocode;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientOperation {

	private static RMIInterface look_up;

	static {
		try {
//			Registry registry = LocateRegistry.getRegistry(0);// Start registry on port 0
			Registry registry = LocateRegistry.getRegistry();
			look_up = (RMIInterface) registry.lookup("//localhost/MyServer");
		} catch (NotBoundException e) {
			throw new RuntimeException(e);
//		} catch (MalformedURLException e) {
//			throw new RuntimeException(e);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		UnLocode xxxxx = createUnLocode("XXXXX");
		System.out.println(xxxxx);
	}

//	public static void main(String[] args)
//		throws MalformedURLException, RemoteException, NotBoundException {
//
//		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
//		String txt = JOptionPane.showInputDialog("What is your name?");
//
//		String response = look_up.helloTo(txt);
//		JOptionPane.showMessageDialog(null, response);
//
//	}

	public static UnLocode createUnLocode(final String countryAndLocation) {
		try {
			return look_up.UnLocode(countryAndLocation);
		} catch (RemoteException e) {
			throw new RuntimeException(e); // TODO Error handling -> Very important to discuss
		}
	}
}