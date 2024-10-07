package TP_RMI_RMI;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.*;

public class AnimalImpl extends UnicastRemoteObject implements IAnimal {
    private String nomAnimal;
    private String nomMaitre;
    private EspeceImpl espece;
    private String race;
    private DossierSuiviImpl dossierSuivi;

    public void setNomAnimal(String nomAnimal){
        this.nomAnimal=nomAnimal;
    }
    public void setNomMaitre(String nomMaitre){
        this.nomAnimal=nomMaitre;
    }
    public void setEspece(EspeceImpl espece){
        this.espece=espece;
    }
    public void setRace(String race){
        this.race=race;
    }
    @Override
    public String getNomAnimal() throws RemoteException {
        return nomAnimal;
    }

    @Override
    public String getNomMaitre() throws RemoteException {
        return nomMaitre;
    }

    @Override
    public IEspece getEspece() throws RemoteException {
        return espece;
    }

    @Override
    public String getRace() throws RemoteException {
        return race;
    }



    public AnimalImpl() throws RemoteException{
        this.nomAnimal="Nom";
        this.nomMaitre="Maitre";
        this.espece= new EspeceImpl();
        this.race="Race";
        this.dossierSuivi=new DossierSuiviImpl();
    }


    public AnimalImpl(String n, String m, EspeceImpl e, String r)throws RemoteException{
        this.nomAnimal=n;
        this.nomMaitre=m;
        this.espece=e;
        this.race=r;
        this.dossierSuivi=new DossierSuiviImpl();
    }

    public AnimalImpl(String n, String m, EspeceImpl e, String r, DossierSuiviImpl d)throws RemoteException{
        this.nomAnimal=n;
        this.nomMaitre=m;
        this.espece=e;
        this.race=r;
        this.dossierSuivi=d;
    }

    @Override
    public String getDescription() throws RemoteException {
        if (getEspece().getNomEspece().equals("chat")) {
            return getNomAnimal() +" "+ getNomMaitre() + " " +getEspece().getNomEspece() + " " +getRace() + " " + getDossier().getEtat() + " Durée de vie 10 ans ";

        } else if (getEspece().getNomEspece().equals("chien")) {
            return getNomAnimal() +" "+ getNomMaitre() + " " +getEspece().getNomEspece() + " " +getRace() + " " + getDossier().getEtat() + " Durée de vie 13 ans ";
        }
    return "";
    }
    @Override
    public String toString(){
        try {
            return getDescription();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "404, Erreur";
    }

    @Override
    public IDossierSuivi getDossier() throws RemoteException {
        return (IDossierSuivi) dossierSuivi;
    }
    public void setDossierSuivi(DossierSuiviImpl dossierSuivi){
        this.dossierSuivi=dossierSuivi;
    }
}
