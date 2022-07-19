package client.rmiserver;

import client.rmiinterface.LocationServiceInterface;
import client.rmiinterface.UnLocodeInterface;
import se.citerus.dddsample.client.location.UnLocode;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LocationService extends UnicastRemoteObject implements LocationServiceInterface {

    protected LocationService() throws RemoteException {
    }

    @Override
    public UnLocodeInterface newUnLocode(String countryAndLocation) throws RemoteException {
        UnLocode unLocode = new UnLocode(countryAndLocation);
        return new UnLocodeImpl(unLocode);
        // Registry bind unlocodeimpl? is that even required? How is it accessed otherwise? TODO

    }

    public static void main(String[] args) {

        try {
            LocationService locationService = new LocationService();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("//localhost/MyServer", locationService);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }

}