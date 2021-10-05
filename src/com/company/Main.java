/**
 * auteur: Afshin Motehaver
 * date: 9-25-2021
 * fonction: Jeu de Yum dans le console java
 */

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // initisalisation des librairies Scanner et Random
    public static Random rand = new Random();
    public static Scanner clavier = new Scanner(System.in);

    // initialisation des constantes
    public static final int NB_DE = 5;
    public static final int NB_TOURS = 13;

    public static void main(String[] args) {

        int round = 0;
        int compteur = 0;
        boolean changerValeurDe = false;

        while (round < NB_TOURS) {

            int[] tableauDice = dice(new int[5]);
            int[] tableauDeComparaison = tableauDice.clone();
            System.out.println("");
            affichageDesDices(tableauDice);

            int[] croissant = tableauDice.clone();
            placeInOrder(croissant);
            //initialisation de la grille de pointage avec tous les valeurs
            grillePointage(Ones(tableauDice), Twos(tableauDice), Threes(tableauDice), Fours(tableauDice),
                    Fives(tableauDice), Sixes(tableauDice), brelan(tableauDice), carre(tableauDice),
                    mainPleine(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                            quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                    courteSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                            quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                    longueSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                            quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                    surplus(tableauDice), yum(tableauDice));

            //initialisation des choix possible par rapport aux fonctions créées pour determiner les choix possibles
            choixPossible(Ones(tableauDice), Twos(tableauDice), Threes(tableauDice), Fours(tableauDice),
                    Fives(tableauDice), Sixes(tableauDice), brelan(tableauDice), carre(tableauDice),
                    mainPleine(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                            quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                    courteSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                            quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                    longueSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                            quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                    surplus(tableauDice), yum(tableauDice));
            while (!changerValeurDe) {

                optionDeChanger(tableauDice);
                if (tableauDice == new int[]{0, 0, 0, 0, 0}) {
                    changerValeurDe = true;
                } else {
                    compteur++;
                }
                if (compteur == 2) {
                    changerValeurDe = true;
                }
                affichageDesDices(tableauDice);

                grillePointage(Ones(tableauDice), Twos(tableauDice), Threes(tableauDice), Fours(tableauDice),
                        Fives(tableauDice), Sixes(tableauDice), brelan(tableauDice), carre(tableauDice),
                        mainPleine(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                                quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                        courteSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                                quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                        longueSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                                quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                        surplus(tableauDice), yum(tableauDice));

                choixPossible(Ones(tableauDice), Twos(tableauDice), Threes(tableauDice), Fours(tableauDice),
                        Fives(tableauDice), Sixes(tableauDice), brelan(tableauDice), carre(tableauDice),
                        mainPleine(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                                quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                        courteSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                                quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                        longueSequence(quantityOnes(croissant), quantityTwos(croissant), quantityThrees(croissant),
                                quantityFours(croissant), quantityFives(croissant), quantitySixes(croissant)),
                        surplus(tableauDice), yum(tableauDice));
                tableauDeComparaison = tableauDice.clone();
            }

            changerValeurDe = false;
            round++;
            System.out.println("Test complete");
            compteur = 0;

        }
    }

    // Cette fonction vérifie la quantité de un dans les dés actuels
    public static int[] dice(int[] tab) {

        for (int i = 0; i < tab.length; i++) {
            tab[i] = rand.nextInt(6) + 1;
        }
        return tab;
    }

    // Fonction créée pour tester avec des dés prédéterminés
    /*
    public static int[] testingDice(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
        }
        return tab;
    }
     */

    // Fonction créée pour compter la somme des uns dans le tableau de dés
    public static int Ones(int[] tab) {

        int nbDeUn = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1) {
                nbDeUn = tab[i] + nbDeUn;
            }
        }
        // Retourne la somme des un dans la présente tableau de dé
        return nbDeUn;
    }

    // Fonction créée pour compter la somme des deux dans le tableau de dés
    public static int Twos(int[] tab) {

        int nbDeDeux = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 2) {
                nbDeDeux = tab[i] + nbDeDeux;
            }
        }
        // Retourne la somme des deux dans la présente tableau de dé
        return nbDeDeux;
    }

    // Fonction créée pour compter la somme des trois dans le tableau de dés
    public static int Threes(int[] tab) {

        int nbDeTrois = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 3) {
                nbDeTrois = tab[i] + nbDeTrois;
            }
        }
        // Retourne la somme des trois dans la présente tableau de dé
        return nbDeTrois;
    }

    // Fonction créée pour compter la somme des quatres dans le tableau de dés
    public static int Fours(int[] tab) {

        int nbDeQuatres = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 4) {
                nbDeQuatres = tab[i] + nbDeQuatres;
            }
        }
        // Retourne la somme des quatres dans la présente tableau de dé
        return nbDeQuatres;
    }

    // Fonction créée pour compter la somme des cinqs dans le tableau de dés
    public static int Fives(int[] tab) {

        int nbDeCinqs = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 5) {
                nbDeCinqs = tab[i] + nbDeCinqs;
            }
        }
        // Retourne la somme des cinqs dans la présente tableau de dé
        return nbDeCinqs;
    }

    // Fonction créée pour compter la somme des six dans le tableau de dés
    public static int Sixes(int[] tab) {

        int nbDeSix = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 6) {
                nbDeSix = tab[i] + nbDeSix;
            }
        }
        // Retourne la somme des six dans la présente tableau de dé
        return nbDeSix;
    }

    // Fonction créée pour compter le nombre d'occurences des uns dans le tableau de dés
    public static int quantityOnes(int[] tab) {

        int nbDeUn = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1) {
                nbDeUn++;
            }
        }
        // Retourne le nombre d'occurence des un dans la présente tableau de dé
        return nbDeUn;
    }

    // Fonction créée pour compter le nombre d'occurences des deux dans le tableau de dés
    public static int quantityTwos(int[] tab) {

        int nbDeDeux = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 2) {
                nbDeDeux++;
            }
        }
        // Retourne le nombre d'occurence des deux dans la présente tableau de dé
        return nbDeDeux;
    }

    // Fonction créée pour compter le nombre d'occurences des trois dans le tableau de dés
    public static int quantityThrees(int[] tab) {

        int nbDeTrois = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 3) {
                nbDeTrois++;
            }
        }
        // Retourne le nombre d'occurence des trois dans la présente tableau de dé
        return nbDeTrois;
    }

    // Fonction créée pour compter le nombre d'occurences des quatres dans le tableau de dés
    public static int quantityFours(int[] tab) {

        int nbDeQuatres = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 4) {
                nbDeQuatres++;
            }
        }
        // Retourne le nombre d'occurence des quatres dans la présente tableau de dé
        return nbDeQuatres;
    }

    // Fonction créée pour compter le nombre d'occurences des cinqs dans le tableau de dés
    public static int quantityFives(int[] tab) {

        int nbDeCinqs = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 5) {
                nbDeCinqs++;
            }
        }
        // Retourne le nombre d'occurence des cinqs dans la présente tableau de dé
        return nbDeCinqs;
    }

    // Fonction créée pour compter le nombre d'occurences des six dans le tableau de dés
    public static int quantitySixes(int[] tab) {

        int nbDeSix = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 6) {
                nbDeSix++;
            }
        }
        // Retourne le nombre d'occurence des six dans la présente tableau de dé
        return nbDeSix;
    }

    // Fonction créée pour mettre les chiffre en order à l'aide d'un algorithme triSelection
    public static int[] placeInOrder(int[] tab) {

        int permutation = 0, nbrePlusPetit = 0;

        // Algorithme triSelection
        for (int i = 0; i < tab.length - 1; i++) {
            nbrePlusPetit = i;
            for (int j = i + 1; j < tab.length; j++) {

                if (tab[nbrePlusPetit] > tab[j]) {
                    nbrePlusPetit = j;
                }
            }
            permutation = tab[nbrePlusPetit];
            tab[nbrePlusPetit] = tab[i];
            tab[i] = permutation;
        }
        return tab;
    }

    // Fonction créée pour vérifie les valeurs dans le tableau cherchant un brelan
    public static int brelan(int[] tab) {

        int a, b, c, d, e;

        a = tab[0];
        b = tab[1];
        c = tab[2];
        d = tab[3];
        e = tab[4];

        // Vérifie si les 3 des valeurs (en ordre croissant) ont la même valeur en order xxx-nn, n-xxx-n et nn-xxx
        if (a == b & b == c | b == c & c == d | c == d & d == e) {

            // retourne la somme totales des points accumulés pour le brelan
            return a + b + c + d + e;
        } else {

            // retourne la valeur 0 si le brelan n'existe pas
            return 0;
        }
    }

    // Fonction créée pour vérifié les valeurs dans le tableau cherchant un carré
    public static int carre(int[] tab) {

        int a, b, c, d, e;

        a = tab[0];
        b = tab[1];
        c = tab[2];
        d = tab[3];
        e = tab[4];

        if (a == b & b == c & c == d | b == c & c == d & d == e) {

            // retourne la somme des points
            return a + b + c + d + e;
        } else {

            // retourne 0 puisqu'il n'y a pas de carré
            return 0;
        }

    }

    public static int mainPleine(int ones, int twos, int threes, int fours, int fives, int sixes) {

        boolean conditionTriple = false, conditionDouble = false;
        int retourPointage = 0;

        if (ones == 3 | twos == 3 | threes == 3 | fours == 3 | fives == 3 | sixes == 3) {
            conditionTriple = true;
        }
        if (ones == 2 | twos == 2 | threes == 2 | fours == 2 | fives == 2 | sixes == 2) {
            conditionDouble = true;
        }
        if (conditionTriple & conditionDouble == true) {
            return retourPointage = 25;
        }
        return retourPointage = 0;
    }

    public static boolean courteSequence(int ones, int twos, int threes, int fours, int fives, int sixes) {

        if (ones >= 1 & twos >= 1 & threes >= 1 & fours >= 1) {
            return true;
        }
        if (twos >= 1 & threes >= 1 & fours >= 1 & fives >= 1) {
            return true;
        }
        if (threes >= 1 & fours >= 1 & fives >= 1 & sixes >= 1) {
            return true;
        }
        return false;
    }

    public static boolean longueSequence(int ones, int twos, int threes, int fours, int fives, int sixes) {

        if (ones >= 1 & twos >= 1 & threes >= 1 & fours >= 1 & fives >= 1) {
            return true;
        }
        if (twos >= 1 & threes >= 1 & fours >= 1 & fives >= 1 & sixes >= 1) {
            return true;
        }
        return false;
    }

    public static int surplus(int[] tab) {

        int somme = 0;

        for (int i = 0; i < tab.length; i++) {
            somme += tab[i];
        }
        return somme;
    }

    public static int yum(int[] tab) {

        int a, b, c, d, e, pointage;

        a = tab[0];
        b = tab[1];
        c = tab[2];
        d = tab[3];
        e = tab[4];

        if (a == b & b == c & c == d & d == e) {
            return pointage = 30;
        }
        return pointage = 0;
    }

    public static void afficherDe(int[] tab) {

        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }

    }

    // Fonction qui imprime la grille de pointage
    public static void grillePointage(int ones, int twos, int threes, int fours, int fives, int sixes,
                                      int brelan, int carre, int mainPleine, boolean courteSequence,
                                      boolean longueSequence, int surplus, int yum) {
        int pointageCourte = 0;
        int pointageLongue = 0;

        // vérifie l'état de courte séquence et retourne les points si l'état est vrai
        if (courteSequence) {
            pointageCourte = 15;
        } else {
            pointageCourte = 0;
        }

        // vérifie l'état de longue séquence et retourne les points si l'état est vrai
        if (longueSequence) {
            pointageLongue = 15;
        } else {
            pointageLongue = 0;
        }
        System.out.println("");
        System.out.println("                 GRILLE DE POINTAGE");
        System.out.println("-----------------------------------------------------");
        System.out.println("     1      |   " + ones + "   |         |Brelan       |   " + brelan + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println("     2      |   " + twos + "   |         |Carre        |   " + carre + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println("     3      |   " + threes + "   |         |Main Pleine  |   " + mainPleine + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println("     4      |   " + fours + "   |         |Petite suite |   " + pointageCourte + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println("     5      |   " + fives + "   |         |Grosse suite |   " + pointageLongue + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println("     6      |   " + sixes + "   |         |Surplus      |   " + surplus + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println(" Sous total |   0   |         |YUM          |   " + yum + "   |");
        System.out.println("---------------------         -----------------------");
        System.out.println(" Bonus      |   0   |         |Total bas    |   0   |");
        System.out.println("---------------------         -----------------------");
        System.out.println(" Total haut |   0   |         |Total        |   0   |");
        System.out.println("---------------------         -----------------------");
    }

    // Fonction qui imprime le tableau des choix possibles
    public static void choixPossible(int ones, int twos, int threes, int fours, int fives, int sixes,
                                     int brelan, int carre, int mainPleine, boolean courteSequence,
                                     boolean longueSequence, int surplus, int yum) {

        int pointageCourte = 0;
        int pointageLongue = 0;

        // vérifie l'état de courte séquence et retourne les points si l'état est vrai
        if (courteSequence) {
            pointageCourte = 15;
        } else {
            pointageCourte = 0;
        }

        // vérifie l'état de longue séquence et retourne les points si l'état est vrai
        if (longueSequence) {
            pointageLongue = 15;
        } else {
            pointageLongue = 0;
        }

        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("                 CHOIX POSSIBLES");
        System.out.println("-----------------------------------------------------");

        // Vérifie pour chaque fonctions s'il y a des points sinon n'affiche pas la partie concernée
        if (ones != 0) {
            System.out.println("|      1      |   " + ones + "   |");
            System.out.println("--------------------");
        }
        if (twos != 0) {
            System.out.println("|      2      |   " + twos + "   |");
            System.out.println("--------------------");
        }
        if (threes != 0) {
            System.out.println("|      3      |   " + threes + "   |");
            System.out.println("--------------------");
        }
        if (fours != 0) {
            System.out.println("|      4      |   " + fours + "   |");
            System.out.println("--------------------");
        }
        if (fives != 0) {
            System.out.println("|      5      |   " + fives + "   |");
            System.out.println("--------------------");
        }
        if (sixes != 0) {
            System.out.println("|      6      |   " + sixes + "   |");
            System.out.println("--------------------");
        }
        if (brelan != 0) {
            System.out.println("|Brelan       |   " + brelan + "   |");
            System.out.println("--------------------");
        }
        if (carre != 0) {
            System.out.println("|Carre        |   " + carre + "   |");
            System.out.println("--------------------");
        }
        if (mainPleine != 0) {
            System.out.println("|Main Pleine  |   " + mainPleine + "   |");
            System.out.println("--------------------");
        }
        if (courteSequence) {
            System.out.println("|Petite suite |   " + pointageCourte + "   |");
            System.out.println("--------------------");
        }
        if (longueSequence) {
            System.out.println("|Grosse suite |   " + pointageLongue + "   |");
            System.out.println("--------------------");
        }
        if (surplus != 0) {
            System.out.println("|Surplus      |   " + surplus + "   |");
            System.out.println("--------------------");
        }
        if (yum != 0) {
            System.out.println("|YUM          |   " + yum + "   |");
            System.out.println("--------------------");
        }
    }

    public static void affichageDesDices(int[] tab) {

        String premierDeUn = "", premierDeDeux = "", premierDeTrois = "", secondDeUn = "", secondDeDeux = "";
        String secondDeTrois = "", troisiemeDeUn = "", troisiemeDeDeux = "", troisiemeDeTrois = "", quatriemeDeUn = "";
        String quatriemeDeDeux = "", quatriemeDeTrois = "", cinquiemeDeUn = "", cinquiemeDeDeux = "", cinquiemeDeTrois = "";

        int valeurActuel = 0;

        String Espace = "       ";
        String valeur1Partie2 = "   o   ";
        String valeur1Partie3 = "  ___  ";
        String valeur2Partie1 = " o     ";
        String valeur2Partie3 = "  ___o ";
        String valeur3Partie1 = " o     ";
        String valeur3Partie2 = "   o   ";
        String valeur3Partie3 = "  ___o ";
        String valeur4Partie1 = " o   o ";
        String valeur4Partie3 = " o___o ";
        String valeur5Partie1 = " o   o ";
        String valeur5Partie2 = "   o   ";
        String valeur5Partie3 = " o___o ";
        String valeur6Partie1 = " o   o ";
        String valeur6Partie2 = " o   o ";
        String valeur6Partie3 = " o___o ";

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1 & i == 0) {
                premierDeUn = Espace;
                premierDeDeux = valeur1Partie2;
                premierDeTrois = valeur1Partie3;
            } else if (tab[i] == 2 & i == 0) {
                premierDeUn = valeur2Partie1;
                premierDeDeux = Espace;
                premierDeTrois = valeur2Partie3;
            } else if (tab[i] == 3 & i == 0) {
                premierDeUn = valeur3Partie1;
                premierDeDeux = valeur3Partie2;
                premierDeTrois = valeur3Partie3;
            } else if (tab[i] == 4 & i == 0) {
                premierDeUn = valeur4Partie1;
                premierDeDeux = Espace;
                premierDeTrois = valeur4Partie3;
            } else if (tab[i] == 5 & i == 0) {
                premierDeUn = valeur5Partie1;
                premierDeDeux = valeur5Partie2;
                premierDeTrois = valeur5Partie3;
            } else if (tab[i] == 6 & i == 0) {
                premierDeUn = valeur6Partie1;
                premierDeDeux = valeur6Partie2;
                premierDeTrois = valeur6Partie3;
            } else if (tab[i] == 1 & i == 1) {
                secondDeUn = Espace;
                secondDeDeux = valeur1Partie2;
                secondDeTrois = valeur1Partie3;
            } else if (tab[i] == 2 & i == 1) {
                secondDeUn = valeur2Partie1;
                secondDeDeux = Espace;
                secondDeTrois = valeur2Partie3;
            } else if (tab[i] == 3 & i == 1) {
                secondDeUn = valeur3Partie1;
                secondDeDeux = valeur3Partie2;
                secondDeTrois = valeur3Partie3;
            } else if (tab[i] == 4 & i == 1) {
                secondDeUn = valeur4Partie1;
                secondDeDeux = Espace;
                secondDeTrois = valeur4Partie3;
            } else if (tab[i] == 5 & i == 1) {
                secondDeUn = valeur5Partie1;
                secondDeDeux = valeur5Partie2;
                secondDeTrois = valeur5Partie3;
            } else if (tab[i] == 6 & i == 1) {
                secondDeUn = valeur6Partie1;
                secondDeDeux = valeur6Partie2;
                secondDeTrois = valeur6Partie3;
            } else if (tab[i] == 1 & i == 2) {
                troisiemeDeUn = Espace;
                troisiemeDeDeux = valeur1Partie2;
                troisiemeDeTrois = valeur1Partie3;
            } else if (tab[i] == 2 & i == 2) {
                troisiemeDeUn = valeur2Partie1;
                troisiemeDeDeux = Espace;
                troisiemeDeTrois = valeur2Partie3;
            } else if (tab[i] == 3 & i == 2) {
                troisiemeDeUn = valeur3Partie1;
                troisiemeDeDeux = valeur3Partie2;
                troisiemeDeTrois = valeur3Partie3;
            } else if (tab[i] == 4 & i == 2) {
                troisiemeDeUn = valeur4Partie1;
                troisiemeDeDeux = Espace;
                troisiemeDeTrois = valeur4Partie3;
            } else if (tab[i] == 5 & i == 2) {
                troisiemeDeUn = valeur5Partie1;
                troisiemeDeDeux = valeur5Partie2;
                troisiemeDeTrois = valeur5Partie3;
            } else if (tab[i] == 6 & i == 2) {
                troisiemeDeUn = valeur6Partie1;
                troisiemeDeDeux = valeur6Partie2;
                troisiemeDeTrois = valeur6Partie3;
            } else if (tab[i] == 1 & i == 3) {
                quatriemeDeUn = Espace;
                quatriemeDeDeux = valeur1Partie2;
                quatriemeDeTrois = valeur1Partie3;
            } else if (tab[i] == 2 & i == 3) {
                quatriemeDeUn = valeur2Partie1;
                quatriemeDeDeux = Espace;
                quatriemeDeTrois = valeur2Partie3;
            } else if (tab[i] == 3 & i == 3) {
                quatriemeDeUn = valeur3Partie1;
                quatriemeDeDeux = valeur3Partie2;
                quatriemeDeTrois = valeur3Partie3;
            } else if (tab[i] == 4 & i == 3) {
                quatriemeDeUn = valeur4Partie1;
                quatriemeDeDeux = Espace;
                quatriemeDeTrois = valeur4Partie3;
            } else if (tab[i] == 5 & i == 3) {
                quatriemeDeUn = valeur5Partie1;
                quatriemeDeDeux = valeur5Partie2;
                quatriemeDeTrois = valeur5Partie3;
            } else if (tab[i] == 6 & i == 3) {
                quatriemeDeUn = valeur6Partie1;
                quatriemeDeDeux = valeur6Partie2;
                quatriemeDeTrois = valeur6Partie3;
            } else if (tab[i] == 1 & i == 4) {
                cinquiemeDeUn = Espace;
                cinquiemeDeDeux = valeur1Partie2;
                cinquiemeDeTrois = valeur1Partie3;
            } else if (tab[i] == 2 & i == 4) {
                cinquiemeDeUn = valeur2Partie1;
                cinquiemeDeDeux = Espace;
                cinquiemeDeTrois = valeur2Partie3;
            } else if (tab[i] == 3 & i == 4) {
                cinquiemeDeUn = valeur3Partie1;
                cinquiemeDeDeux = valeur3Partie2;
                cinquiemeDeTrois = valeur3Partie3;
            } else if (tab[i] == 4 & i == 4) {
                cinquiemeDeUn = valeur4Partie1;
                cinquiemeDeDeux = Espace;
                cinquiemeDeTrois = valeur4Partie3;
            } else if (tab[i] == 5 & i == 4) {
                cinquiemeDeUn = valeur5Partie1;
                cinquiemeDeDeux = valeur5Partie2;
                cinquiemeDeTrois = valeur5Partie3;
            } else if (tab[i] == 6 & i == 4) {
                cinquiemeDeUn = valeur6Partie1;
                cinquiemeDeDeux = valeur6Partie2;
                cinquiemeDeTrois = valeur6Partie3;
            }
        }

        System.out.println("  _____    _____    _____    _____    _____");
        System.out.println("|" + premierDeUn + "|" + "|" + secondDeUn + "|" + "|" +
                troisiemeDeUn + "|" + "|" + quatriemeDeUn + "|" + "|" + cinquiemeDeUn + "|");
        System.out.println("|" + premierDeDeux + "|" + "|" + secondDeDeux + "|" + "|" +
                troisiemeDeDeux + "|" + "|" + quatriemeDeDeux + "|" + "|" + cinquiemeDeDeux + "|");
        System.out.println("|" + premierDeTrois + "|" + "|" + secondDeTrois + "|" + "|" +
                troisiemeDeTrois + "|" + "|" + quatriemeDeTrois + "|" + "|" + cinquiemeDeTrois + "|");

    }

    public static int[] optionDeChanger(int[] tab) {

        System.out.println("\nEntrez les des que vous voulez changer, sinon entrez 0 pour garder les des");
        String entry = clavier.next();

        boolean occurenceZero = entry.contains("0");
        boolean occurenceOne = entry.contains("1");
        boolean occurenceTwo = entry.contains("2");
        boolean occurenceThree = entry.contains("3");
        boolean occurenceFour = entry.contains("4");
        boolean occurenceFive = entry.contains("5");
//yeet
        if (occurenceZero) {
            return tab;
        }

        if (occurenceOne) {
            tab[0] = rand.nextInt(6) + 1;
        }
        if (occurenceTwo) {
            tab[1] = rand.nextInt(6) + 1;
        }
        if (occurenceThree) {
            tab[2] = rand.nextInt(6) + 1;
        }
        if (occurenceFour) {
            tab[3] = rand.nextInt(6) + 1;
        }
        if (occurenceFive) {
            tab[4] = rand.nextInt(6) + 1;
        }
        return tab;
    }
}
