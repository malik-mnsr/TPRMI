package TP_RMI_RMI;
import common.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DossierSuiviImpl extends UnicastRemoteObject implements IDossierSuivi {
    private String etat;

    @Override
    public void setEtat(String e) throws RemoteException {
    this.etat=e;
       }

    @Override
    public String getEtat() throws RemoteException {
        return etat;
    }

    public DossierSuiviImpl(String e) throws  RemoteException{
        this.etat=e;
    }
    public DossierSuiviImpl() throws  RemoteException{
        this.etat="Normal";
    }
}
