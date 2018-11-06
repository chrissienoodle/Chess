public class Main {

    public static void main(String[] args) {

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
                plateau[i][j] = " ";
            }
        }

        //affichage du plateau
        for (String dim1[]:plateau){
            for (String dim2: dim1) {
                System.out.print(dim2 + " ");
            }
            System.out.println();
        }
    }
}
