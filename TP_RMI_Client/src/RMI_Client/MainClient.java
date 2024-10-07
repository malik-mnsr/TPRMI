package RMI_Client;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Client client = new Client();
        try {
            System.out.println("Attendez Client!");
            System.out.println("Cabinet est ici");
            client.startClient();
            System.out.println("Lets Go");
            Scanner sc = new Scanner(System.in);
            int choix = -1;
            while(choix < 6) {
                System.out.println("1-Voir cabinet, 2-Ajouter animal, 3-Ajouter plsieur animaux, 4-Ajouter chien, 5-Quitter");
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        client.displayCabinet();
                        System.out.println();
                        System.out.println("\n");
                        break;
                    case 2:
                        System.out.println("On ira ajouter votre animal");
                        Scanner inp = new Scanner(System.in);
                        System.out.println("Nom animal:");
                        String nomAnimal = inp.nextLine();
                        System.out.println("\nNom Maitre:");
                        String nomMaitre = inp.nextLine();
                        System.out.println("\nEspece:");
                        String espece = inp.nextLine();
                        System.out.println("\nRace:");
                        String race = inp.nextLine();
                        System.out.println("\nDescprtions");
                        String dess = inp.nextLine();
                        client.addAnimal(nomAnimal, nomMaitre, espece, race, dess);
                        System.out.println("\n Nouvel animal : " + client.showAnimal(nomAnimal).getDescription());
                        break;
                    case 3:
                        System.out.println("Ajout plusieurs animaux:\n");
                        System.out.println("Combien voulez vous créer: \n");
                        int n = sc.nextInt();
                        System.out.println("Ajout " + n + "animaux \n");
                        Scanner inp1;
                        for (int i = 0; i < n; i++) {
                            inp1 = new Scanner(System.in);
                            System.out.println("\nNom animal:");
                            nomAnimal = inp1.nextLine();
                            System.out.println("\nNom Maitre:");
                            nomMaitre = inp1.nextLine();
                            System.out.println("\nEspece:");
                            espece = inp1.nextLine();
                            System.out.println("\nRace:");
                            race = inp1.nextLine();
                            System.out.println("\nDescprtions");
                            dess = inp1.nextLine();
                            client.addAnimal(nomAnimal, nomMaitre, espece, race, dess);
                        }
                        break;
                    case 4:
                        System.out.println("Ajout d'un chien: \n");
                        Scanner inp2 = new Scanner(System.in);
                        System.out.println("\nNom animal:");
                        nomAnimal = inp2.nextLine();
                        System.out.println("\nNom Maitre:");
                        nomMaitre = inp2.nextLine();
                        System.out.println("\nRace:");
                        race = inp2.nextLine();
                        System.out.println("\nDescprtions");
                        dess = inp2.nextLine();
                        client.addAnimal(nomAnimal, nomMaitre, race,dess);
                        System.out.println("\n Nouvel animal : " + client.showAnimal(nomAnimal).getDescription());
                        //System.out.println("Nouvel Animal\n" + client.showAnimal(nomAnimal).toString());
                        break;


                    default:
                        System.out.println("C'est bon \n");
                        client.exitClient();
                        System.exit(0);
                        break;
                }
            }
            sc.close();
        }catch (RemoteException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

