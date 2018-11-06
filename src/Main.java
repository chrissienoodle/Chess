import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int BLANC = 0;
        final int NOIR = 1;
        final String EMPTY = " " + " ";

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
                plateau[i][j] = EMPTY;
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
        int piece[] = {0,0};
        int move[] = {0 ,0};

        //boucle pour saisies utilisateur
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
                    piece[0] = sc.nextInt();
                    piece[1] = sc.nextInt();

                    //vérification de la saisie utilisateur
                    if ((piece[0]<0) || (piece[1]<0) || (piece[0]>(SIZE-1)) ||(piece[1]>(SIZE-1))) {
                        System.out.println("Cette saisie est erronnée.");
                        sc.nextLine();
                        userVerif = true;
                    }
                    else{

                        if (plateau[(piece[0])][(piece[1])].charAt(1) == (((tour % 2) == BLANC) ? 'B' : 'N')) {
                            sc.nextLine();
                            userVerif = false;
                        } else {
                            System.out.println("Cette saisie est erronnée.");
                            sc.nextLine();
                            userVerif = true;
                        }
                    }
                } while (userVerif);

                //saisie du déplacement
                do {
                    System.out.printf("Joueur %s, veuillez saisir les coordonnées de la case où vous souhaitez placer votre pièce \n", joueur);
                    move[0] = sc.nextInt();
                    move[1] = sc.nextInt();

                    //vérification de la saisie utilisateur
                    if ((move[0]<0) || (move[1]<0) || (move[0]>(SIZE-1)) ||(move[1]>(SIZE-1))) {
                        System.out.println("Cette saisie est erronnée.");
                        sc.nextLine();
                        userVerif = true;
                    }
                    else {
                        //déplacement de la pièce
                        plateau[(move[0])][(move[1])]= plateau[(piece[0])][(piece[1])];
                        plateau[(piece[0])][(piece[1])] = EMPTY;
                        userVerif = false;
                    }

                } while (userVerif);


                tour++;


        } while(noend);

    }
}
