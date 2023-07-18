/*
 * Creer une application de gestion des notes ( Pour etudiants):
 * Etudiant  : etudantId , nom , prenom
 * Cours : coursId nomCours
 * Notes : etudantId, coursId , note1, note2
 * 1. Creer Les trois DAO.
 * 2. Creer un menu Principal.
 *      1. Etudiant
 *      2. Cours
 *      3. Notes   
 *      4. Sortie
 * 3.Pour chaque branche de menu principal, creer un sous menu.
 *      1. Ajouter
 *      2. Afficher
 *      3. Supprimer
 *      4. Sortie
 */
package test;

import daoImplementation.CoursDaoImp;
import daoImplementation.EtudiantDaoImp;
import daoImplementation.NotesDaoImp;
import daoInterface.CoursInterface;
import daoInterface.EtudiantInt;
import daoInterface.NotesInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import model.Cours;
import model.Etudiant;
import model.Notes;

/**
 *
 * @author mgrac
 */
public class Main {

    //read input from keyboard
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static EtudiantInt dao = new EtudiantDaoImp();
    static CoursInterface daoCours = new CoursDaoImp();
    static NotesInterface daoNotes = new NotesDaoImp();

    public static void main(String[] args) throws IOException {
        //List<Etudiant> etudiantList = new ArrayList<Etudiant>();
        int choix;
        int choixSousMenu;
        String res = "";
        do {
            menuPrincipal();
            choix = getUserChoice(br);
            //main menu
            switch (choix) {
                case 1:
                    afficheSousMenu();
                    choixSousMenu = Integer.parseInt(br.readLine());
                    //switch for Etudiant sub menu
                    switch (choixSousMenu) {

                        case 1:
                            ajouterEtudiant();
                            break;
                        case 2:
                            afficheEtudiant();
                            break;
                        case 3:
                            deleteEtudiant();
                            break;
                        case 4:
                            exit();
                            break;
                        default:
                            System.out.println("Entrée invalide! Essayer a nouveau!");
                            break;
                    }
                    //switch end sub menu
                    break;
                case 2:
                    afficheSousMenu();
                    choixSousMenu = getUserChoice(br);
                    switch (choixSousMenu) {
                        case 1:
                            ajouterCours();
                            break;
                        case 2:
                            afficheCours();
                            break;
                        case 3:
                            deleteCours();
                            break;
                        case 4:
                            exit();
                            break;
                        default:
                            System.out.println("Entrée invalide! Essayer a nouveau!");
                            break;
                    }
                    break;
                case 3:
                    afficheSousMenu();
                    choixSousMenu = getUserChoice(br);
                    switch (choixSousMenu) {
                        case 1:
                            ajouterNote();
                            break;
                        case 2:
                            afficheNotes();
                            break;
                        case 3:
                            deleteNote();
                            break;
                        case 4:
                            exit();
                            break;
                        default:
                            System.out.println("Entrée invalide! Essayer a nouveau!");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("****** MERCI *******");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entrée invalide! Essayer a nouveau!");
                    break;
            }
            //end of switch main menu
            System.out.println("Voulez-vous faire une autre tache(OUI/NON): ");
            res = br.readLine().toLowerCase();
        } while (res.equalsIgnoreCase("oui") || res.equalsIgnoreCase("o"));
    }

    private static void menuPrincipal() {
        System.out.println("**** GESTION DES NOTES ******");
        System.out.println("\t1. Etudiant");
        System.out.println("\t2. Cours");
        System.out.println("\t3. Notes");
        System.out.println("\t4. Sortie");
        System.out.println("Entrez votre choix: ");
    }

    private static void afficheSousMenu() {
        System.out.println("\t1. Ajouter");
        System.out.println("\t2. Afficher");
        System.out.println("\t3. Supprimer");
        System.out.println("\t4. Sortie");
        System.out.println("Entrez votre choix: ");
    }

    //AJOUTER UN ETUDIANT
    public static void ajouterEtudiant() throws IOException {
        System.out.println("Entrez ID de l'etudiant: ");
        int etudiantId = Integer.parseInt(br.readLine());
        System.out.println("Entrez Nom: ");
        String nom = br.readLine();
        System.out.println("Entrez Prenom: ");
        String prenom = br.readLine();

        Etudiant etud = new Etudiant(etudiantId, nom, prenom);
        int status = dao.addStudent(etud);

        if (status == 1) {
            System.out.println("Etudiant ajouté avec succès!");
        } else {
            System.out.println("ERROR lors de l'ajout d'étudiant!");
        }
        System.out.println("\n");
    }

    //AFFICHE LES ETUDIANTS
    public static void afficheEtudiant() {
        System.out.printf("%-8s%-15s%-15s", "ID", "NOM", "PRENOM");
        System.out.println("");
        System.out.print("--------------------------------\n");
        List<Etudiant> listEtudiant = dao.findAll();
        for (Etudiant etudiant : listEtudiant) {
            System.out.printf("%-8s%-15s%-15s", etudiant.getEtudiantId(), etudiant.getNom(), etudiant.getPrenom());
            System.out.println("");
        }
        System.out.print("--------------------------------");
        System.out.println("\n");
    }

    //RETRIEVE STUDENT RECORD
    public static void afficheEtudiant(Etudiant etudiant) {
        System.out.println("Etudiant ID: " + etudiant.getEtudiantId());
        System.out.println("Nom: " + etudiant.getNom());
        System.out.println("Prenom: " + etudiant.getPrenom());
        System.out.println("\n");
    }

    //DELETE ETUDIANT
    public static void deleteEtudiant() throws IOException {
        System.out.println("---------------------------------");
        System.out.print("Entrez Etudiant ID: ");
        int etudiantId = Integer.parseInt(br.readLine());
        int status = dao.deleteEtudiant(etudiantId);
        if (status == 1) {
            System.out.println("Etudiant a supprimé avec succès!");
        } else {
            System.out.println("ERROR lors de suppression de l'étudiant!");
        }
        System.out.println("\n");
    }

    //ajouter un nouvel cours 
    public static void ajouterCours() throws IOException {
        System.out.println("Entrez Cours ID: ");
        String coursId = br.readLine();
        System.out.println("Entrez Nom de Cours: ");
        String nomCours = br.readLine();

        Cours cours = new Cours(coursId, nomCours);
        int status = daoCours.addCours(cours);

        if (status == 1) {
            System.out.println("Cours ajouté avec succès!");
        } else {
            System.out.println("ERROR lors de l'ajout de cours!");
        }
        System.out.println("\n");
    }

    //affiche tous les cours
    public static void afficheCours() {
        System.out.printf("%-12s%-15s", "COURSID", "NOM COURS");
        System.out.println("");
        System.out.print("-----------------------------\n");
        List<Cours> listCours = daoCours.findAll();
        for (Cours cours : listCours) {
            System.out.printf("%-12s%-15s", cours.getCoursId(), cours.getNomCours());
            System.out.println("");
        }
        System.out.println("-----------------------------");
        System.out.println("\n");
    }

    //retrieve cours record
    public static void afficheCours(Cours cours) {
        System.out.println("Cours ID: " + cours.getCoursId());
        System.out.println("Nom Cours: " + cours.getNomCours());
        System.out.println("\n");
    }

    //delete a course
    public static void deleteCours() throws IOException {
        System.out.println("---------------------------------");
        System.out.print("Entrez Cours ID: ");
        String coursId = br.readLine();
        int status = daoCours.deleteCours(coursId);
        if (status == 1) {
            System.out.println("Cours supprimé avec succès!");
        } else {
            System.out.println("ERROR lors de le suppression de cours!");
        }
        System.out.println("\n");
    }

    //affiche notes
    public static void afficheNotes() {
        System.out.printf("%-16s%-16s%-15s%-15s\n", "ETUDIANT ID", "COURS ID", "NOTE 1", "NOTE 2");
        System.out.println("----------------------------------------------------------");
        List<Notes> listNote = daoNotes.findAll();
        for (Notes note : listNote) {
            if (note.getNote1() != 0 || note.getNote2() != 0) {
                affiche(note);
            }
        }
        System.out.print("-----------------------------------------------------------");
        System.out.println("\n");
    }

    //RETRIEVE STUDENT RECORD
    public static void affiche(Notes note) {
        System.out.printf("%-16s%-16s%-15.1f%-15.1f\n", note.getEtudiantId().getEtudiantId(), note.getCoursId().getCoursId(), note.getNote1(), note.getNote2());
    }

    ////AJOUTER UNE NOTE
    public static void ajouterNote() throws IOException {
        System.out.println("Entrez ID de l'etudiant: ");
        int etudiantId = Integer.parseInt(br.readLine());
        System.out.println("Entrez Cours ID: ");
        String coursId = br.readLine();
        System.out.println("Entrez Note1: ");
        double note1 = Double.parseDouble(br.readLine());
        System.out.println("Entrez Note1: ");
        double note2 = Double.parseDouble(br.readLine());

        Etudiant etudiant = new Etudiant(etudiantId);
        Cours cours = new Cours(coursId);
        Notes notes = new Notes(etudiant, cours, note1, note2);
        int status = daoNotes.addNote(notes);

        if (status == 1) {
            System.out.println("Notes ajouté avec succès!");
        } else {
            System.out.println("ERROR lors de l'ajout des notes!");
        }
        System.out.println("\n");
    }

    //SUPPRIMER UNE NOTE
    public static void deleteNote() throws IOException {
        System.out.println("---------------------------------");
        System.out.print("Entrez Etudiant ID: ");
        int etudiantId = Integer.parseInt(br.readLine());
        int status = daoNotes.deleteNote(etudiantId);
        if (status == 1) {
            System.out.println("Notes supprimé avec succès!");
        } else {
            System.out.println("ERROR lors de le suppression de cours!");
        }
        System.out.println("\n");
    }

    //valider le choix dans le Switch
    //only numbers 1 to 4 are accepted
    public static int getUserChoice(BufferedReader br) throws IOException {
        int choix;
        while (true) {
            try {
                choix = Integer.parseInt(br.readLine());
                if (choix >= 1 && choix <= 4) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entree invalide, entrez un nombre de 1 a 4");
                System.out.print("Entrez votre Choix: ");
            }
        }
        return choix;
    }   
    public static void exit() {
        System.out.println("\n");
        System.out.println("****** MERCI *******");
        System.exit(0);
    }
}
