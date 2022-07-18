package client.rmiserver;

import client.rmiinterface.RMIInterface;
import se.citerus.dddsample.client.location.UnLocode;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


//javac src/main/java/client/rmiinterface/RMIInterface.java src/main/java/client/rmiserver/ServerOperation.java src/main/java/client/rmiclient/ClientOperation.java

//cd src
//start rmiregistry
//java main/java/client/rmiserver/ServerOperation.java


public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;
    protected ServerOperation() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    @Override
    public UnLocode UnLocode(final String countryAndLocation) throws RemoteException {
        return new UnLocode(countryAndLocation);
    }

    public static void main(String[] args){

        try {
            ServerOperation serverOperation = new ServerOperation();
//            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(serverOperation, 0);
//            Registry registry = LocateRegistry.getRegistry();

//            System.setProperty("java.rmi.server.hostname","127.0.1.1");
//            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(1099);// Start registry on port 0
            registry.rebind("//localhost/MyServer", serverOperation);
//            registry.rebind("//localhost/MyServer", serverOperation);
            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}