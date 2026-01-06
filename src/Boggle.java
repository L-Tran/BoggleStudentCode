import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// Completed by Logan Tran
public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // Create TST for dictionary
        TST dict = new TST();
        for (String word: dictionary) {
            dict.insert(word);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                // Execute Depth first search
                Stack<Character> stack = new Stack<>();
                boolean[] isVisited = new boolean[board.length * board.length];
                String currentWord = "";
                stack.push(board[i][j]);
                while (!stack.isEmpty()) {
                    char current = stack.pop();
                    isVisited[current] = true;
                    currentWord += current;
                    if(dict.search(currentWord))  {
                        goodWords.add(currentWord);
                    }
                    // iterate to next chars
                }

            }
        }




        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
}
