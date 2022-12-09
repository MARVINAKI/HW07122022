package Chess;

import java.util.ArrayList;
import java.util.List;

public class Chess {
    private List<List<Character>> chessBoard = new ArrayList<>();
    char whiteCell = '\u25A0';
    char blackCell = '\u25A1';

    public void printChessBoard() {
        for (int n = 0; n < 8; n++) {
            chessBoard.add(n, new ArrayList<>());
            for (int m = 0; m < 8; m++) {
                if (m % 2 + n % 2 == 1) {
                    chessBoard.get(n).add(m, blackCell);
                } else {
                    chessBoard.get(n).add(m, whiteCell);
                }
            }
        }
        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                System.out.print(chessBoard.get(n).get(m) + " ");
            }
            System.out.println();
        }
    }
}
