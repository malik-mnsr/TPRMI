package RMI_Client;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.*;

public class Client extends UnicastRemoteObject implements IClient {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private Registry registry;
    private ICabinet cabinet;


    protected Client() throws RemoteException{
        registry = null;
        cabinet = null;

    }

    @Override
    public void startClient() throws RemoteException {
        try {
            this.registry = LocateRegistry.getRegistry();
            this.cabinet = (ICabinet) registry.lookup("cabinet");
            this.cabinet.addClient(this);
            System.out.println("Connecté.\n");
        } catch (NotBoundException e){
            System.out.println("400");
            e.printStackTrace();
        }
    }

    public void addChien(String nom, String maitre, String race, String doss) throws RemoteException {
        Chien esp = new Chien();
        this.cabinet.addAnimal(nom,maitre,esp,race,doss);
        System.out.println(nom + "Ajouté");
    }

    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race) throws RemoteException {
        this.cabinet.addAnimal(nomAnimal,nomMaitre,espece,race);
        System.out.println(nomAnimal + " ajouté\n");
    }
    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race, String dossier) throws RemoteException {
        this.cabinet.addAnimal(nomAnimal,nomMaitre,espece,race,dossier);
        System.out.println(nomAnimal + " ajouté\n");
    }

    @Override
    public void setEtatAnimal(String nom, String etat) throws RemoteException {
        try {
            IAnimal animal = cabinet.searchAnimal(nom);
            animal.getDossier().setEtat(etat);
            System.out.println("Etat de " + nom + " est mis a jour \n");
        } catch (Exception e) {
            System.out.println("Animal non trouvé\n");
        }
    }

    @Override
    public void exitClient() throws RemoteException {
        try {
            cabinet.deleteClient(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Impossible d'acceder au cabinet \n");
        }
    }

    @Override
    public void displayCabinet() throws RemoteException {
        if(cabinet != null){
            System.out.println("Animaux du cabinet: \n");
            for (IAnimal animal : cabinet.getCabinet()){
                System.out.println(" - " + animal.getDescription());


            }
        }
    }

    @Override
    public String outputCabinet() throws RemoteException {
        String animalString = null;
        if(cabinet !=null){
            System.out.println("\nAnimaux du cabinet: \n");
            for(IAnimal animal: cabinet.getCabinet()){
                animalString += ("- "+animal.getNomAnimal() + " " +animal.getNomMaitre()+" "+ animal.getEspece().getNomEspece() + " " + animal.getRace()
                        + " " + animal.getDossier().getEtat());
            }
        }
        return animalString;
    }

    @Override
    public IAnimal showAnimal(String name) throws RemoteException {
        return this.cabinet.searchAnimal(name);
    }

    @Override
    public void alertClient(String message) throws RemoteException {
        JOptionPane.showMessageDialog(null, message, "Server Alert", JOptionPane.INFORMATION_MESSAGE);

    }
}
