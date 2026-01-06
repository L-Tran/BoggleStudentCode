import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// Completed by Logan Tran
public class Boggle {

    private static TST dict;
    private static boolean[][] isVisited;
    private static int boardSize;


    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();
        boardSize = board.length;
        isVisited = new boolean[boardSize][boardSize];


        // Create TST for dictionary
        dict = new TST();
        for (String word: dictionary) {
            dict.insert(word);
        }


        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                // Execute Depth first search
                dfs(i, j, "", board, goodWords);

            }
        }
        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void dfs(int row, int col, String word, char[][] board, ArrayList<String> goodWords) {
        if (row < 0 || col < 0 || row >= boardSize || col >= boardSize) {
            return;
        }
        if(isVisited[row][col]) {
            return;
        }
        word += board[row][col];

        if(dict.search(word)) {
            goodWords.add(word);
        }

        // Need ifPrefix

        isVisited[row][col] = true;

        dfs(row + 1, col, word, board, goodWords);
        dfs(row, col + 1, word, board, goodWords);
        dfs(row - 1, col, word, board, goodWords);
        dfs(row, col - 1, word, board, goodWords);

        isVisited[row][col] = false;


    }
}
