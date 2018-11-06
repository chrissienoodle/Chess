import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int BLANC = 0;
        final int NOIR = 1;

        //création du plateau
        final int SIZE = 8;
        String plateau[][] = new String[SIZE][SIZE];
        final String PIECES[] = {"T","C","F","Q","K","F","C","T"};
        for (int i=0; i<PIECES.length; i++){
            plateau[0][i] = PIECES[i] + "N";
        }
        for (int i=0; i<PIECES.length; i++){
            plateau[SIZE-1][i] = PIECES[i] + "B";
        }
        for(int i=0; i<SIZE; i++){
            plateau[1][i]="PN";
            plateau[(SIZE-2)][i]="PB";
        }
        for (int i=2; i<(SIZE-2);i++){
            for (int j=0; j<SIZE; j++){
                plateau[i][j] = " " + " ";
            }
        }

        //déclaration des autres variables
        boolean noend = true;
        boolean userVerif = true;
        int tour = 0;
        final String JOUEUR_BLANC = "blanc";
        final String JOUEUR_NOIR = "noir";
        String joueur = "";
        Scanner sc = new Scanner(System.in);

        //boucle pour saisie utilisateur
        do {
            joueur = ((tour % 2) == 0) ? JOUEUR_BLANC : JOUEUR_NOIR;


                //affichage du plateau
                for (String dim1[] : plateau) {
                    for (String dim2 : dim1) {
                        System.out.print(dim2 + " ");
                    }
                    System.out.println();
                }
                do {
                    System.out.printf("Joueur %s, veuillez saisir les coordonnées de la pièce à déplacer \n", joueur);
                    int piece[] = {sc.nextInt(), sc.nextInt()};

                    //vérification de la saisie utilisateur
                    if (plateau[(piece[0])][(piece[1])].charAt(1) == (((tour % 2) == BLANC) ? 'B' : 'N' )){
                        sc.nextLine();
                        userVerif=false;
                    }
                    else {
                        System.out.println("Cette saisie est erronnée.");
                        sc.nextLine();
                        userVerif=true;
                    }
                } while (userVerif);

                tour++;


        } while(noend);

    }
}
