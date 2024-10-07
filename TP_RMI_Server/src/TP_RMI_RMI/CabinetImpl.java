package TP_RMI_RMI;
import common.*;
import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class CabinetImpl extends UnicastRemoteObject implements ICabinet {
    private ArrayList<IAnimal> animals;
    private ArrayList<IClient> clients;

    protected CabinetImpl() throws RemoteException{
        this.animals=new ArrayList<IAnimal>();
        this.clients=new ArrayList<IClient>();
    }

    @Override
    public ArrayList<IAnimal> getCabinet() throws RemoteException {
        return this.animals;
    }

    public void addAnimal(IAnimal animal) throws RemoteException {
        this.animals.add(animal);
        if(animals.size()>=3){
            JOptionPane.showMessageDialog(null, "**** NOTE IMPORTANTE: On a plus de 100 animaux dans le cabinet!",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            for (IClient client : this.clients){
                client.alertClient("****NOTE_IMPORTANTE: On a plus 100 animaux dans le cabinet");
            }
        }
    }



    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, IEspece espece, String race, IDossierSuivi dosssier) throws RemoteException {
        EspeceImpl espece1 = new EspeceImpl();
        espece1.setDureeVie(espece.getDureeVie());
        espece1.setNomEspece(espece.getNomEspece());
        DossierSuiviImpl doss= new DossierSuiviImpl();
        doss.setEtat(dosssier.getEtat());
        AnimalImpl animal = new AnimalImpl(nomAnimal,nomMaitre,espece1,race,doss);
        this.animals.add(animal);
        if(animals.size()>=3){
            JOptionPane.showMessageDialog(null, "**** NOTE IMPORTANTE: On a plus de 100 animaux dans le cabinet!",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            for (IClient client : this.clients){
                client.alertClient("****NOTE_IMPORTANTE: On a plus 100 animaux dans le cabinet\n");
            }
        }
    }

    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race) throws RemoteException {
        EspeceImpl espece1 = new EspeceImpl(espece);
        DossierSuiviImpl doss= new DossierSuiviImpl("Parfait");
        AnimalImpl animal = new AnimalImpl(nomAnimal, nomMaitre, espece1, race,doss);
        this.animals.add(animal);
        if(animals.size()>=3){
            JOptionPane.showMessageDialog(null, "**** NOTE IMPORTANTE: On a plus de 100 animaux dans le cabinet!",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            for (IClient client : this.clients){
                client.alertClient("****NOTE_IMPORTANTE: On a plus 100 animaux dans le cabinet\n");
            }
        }
    }

    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, String espece, String race, String dossierSuivi) throws RemoteException {
    EspeceImpl esp = new EspeceImpl(espece);
    DossierSuiviImpl doss = new DossierSuiviImpl(dossierSuivi);
    AnimalImpl animal = new AnimalImpl(nomAnimal, nomMaitre, esp, race,doss);
    this.animals.add(animal);
    if(animals.size()>=3){
        JOptionPane.showMessageDialog(null, "**** NOTE IMPORTANTE: On a plus de 100 animaux dans le cabinet!",
                "Alert", JOptionPane.WARNING_MESSAGE);
            for (IClient client : this.clients){
                client.alertClient("****NOTE_IMPORTANTE: On a plus 100 animaux dans le cabinet\n");
            }
        }
    }

    @Override
    public void addAnimal(String nomAnimal, String nomMaitre, IEspece espece, String race, String dossierSuivi) throws RemoteException {
        EspeceImpl esp = new EspeceImpl();
        esp.setDureeVie(espece.getDureeVie());
        esp.setNomEspece(espece.getNomEspece());
        DossierSuiviImpl doss = new DossierSuiviImpl(dossierSuivi);
        AnimalImpl animal = new AnimalImpl(nomAnimal, nomMaitre, esp, race, doss);
        this.animals.add(animal);
        if (animals.size() >= 3) {
            JOptionPane.showMessageDialog(null, "**** NOTE IMPORTANTE: On a plus de 100 animaux dans le cabinet!",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            for (IClient client : this.clients) {
                client.alertClient("****NOTE_IMPORTANTE: On a plus 100 animaux dans le cabinet\n");
            }
        }
    }
    @Override
    public IAnimal searchAnimal(String nomAnimal) throws RemoteException {
        for(int i = 0; i <this.animals.size(); i++) {
            try {
                if (this.animals.get(i).getNomAnimal().equals(nomAnimal));
                return this.animals.get(i);
            } catch (RemoteException e){
                e.printStackTrace();
            }
        }
        System.out.println("Cette animal est inexistant dans notre cabinet\n");
        return null;
    }

        @Override
        public void addClient (IClient client){
            this.clients.add(client);
        }

        @Override
        public void deleteClient (IClient client){
            for (int i = 0; i < clients.size(); i++) {
                if (client.equals(clients.get(i))) {
                    clients.remove(i);
                }
            }

        }
    }
