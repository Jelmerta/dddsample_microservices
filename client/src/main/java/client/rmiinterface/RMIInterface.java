package client.rmiinterface;

import se.citerus.dddsample.client.location.UnLocode;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    public String helloTo(String name) throws RemoteException;

    public UnLocode UnLocode(final String countryAndLocation) throws RemoteException;
}
