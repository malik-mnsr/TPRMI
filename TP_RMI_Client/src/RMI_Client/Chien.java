package RMI_Client;


import java.io.Serializable;
import java.rmi.RemoteException;
import common.IAnimal;
import common.IDossierSuivi;
import common.IClient;
import common.IEspece;

public class Chien  implements IEspece, Serializable {
    private String nomEspece;
    private int dureeVie;
    public Chien(){
        this.nomEspece="Chien";
        this.dureeVie=13;
    }

    @Override
    public String getNomEspece() throws RemoteException {
        return "";
    }

    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    @Override
    public int getDureeVie() throws RemoteException {
        return 0;
    }

    public void setDureeVie(int dureeVie) {
        this.dureeVie = dureeVie;
    }
}
