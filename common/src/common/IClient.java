package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {

    public void startClient() throws RemoteException;
    public void displayCabinet() throws RemoteException;
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race) throws RemoteException;
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race, String dossierSuivi) throws RemoteException;
    public void setEtatAnimal(String nom, String etat) throws RemoteException;
    public IAnimal showAnimal(String name) throws RemoteException;
    public void exitClient() throws RemoteException;
    public void alertClient(String message) throws RemoteException;
    public String outputCabinet() throws RemoteException;
}
