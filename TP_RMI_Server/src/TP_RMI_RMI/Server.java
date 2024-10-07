package TP_RMI_RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import common.*;
public class Server {
    public Server() {

    }
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.setProperty("java.security.policy", "./security.policy");
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);
        System.setProperty("java.rmi.server.codebase", "file:./TP_RMI_Client/obj/");
        CabinetImpl cabinet = new CabinetImpl();
        EspeceImpl especeChien = new EspeceImpl("chien",13);
        AnimalImpl animal1 = new AnimalImpl("Rex","Théo",especeChien,"Pitbull");
        cabinet.addAnimal(animal1);

        Registry registry = LocateRegistry.createRegistry((1099));

        if(registry==null){
            System.out.println("500, Registry is out => TP_RMI_RMI.Server is out\n");
        }
        else {
            registry.bind("cabinet", cabinet);
            System.err.println("200 démarrage du TP_RMI_RMI.Server\n");
        }
    }

}
