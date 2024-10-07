package TP_RMI_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.*;

public class EspeceImpl extends UnicastRemoteObject implements IEspece {
    private String nomEspece;
    private int dureeVie;

    public EspeceImpl() throws RemoteException{
        this.nomEspece="chien";
        this.dureeVie=14;
    }
    public EspeceImpl(String n, int dVie) throws RemoteException{
        this.nomEspece=n;
        this.dureeVie=dVie;
    }

    public EspeceImpl(String n) throws RemoteException{
        this.nomEspece=n;
        this.dureeVie=0;
    }


    @Override
    public String getNomEspece() throws RemoteException {
        return nomEspece;
    }

    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    @Override
    public int getDureeVie() throws RemoteException {
        return dureeVie;
    }


    public void setDureeVie(int dureeVie) {
        this.dureeVie = dureeVie;
    }
}