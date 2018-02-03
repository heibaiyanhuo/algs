package leetcode.problems;

public class A079_Word_Search {


    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, wordArray)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int idx, char[] word) {

        if (idx == word.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] != word[idx]){
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, i + 1, j, idx + 1, word) || dfs(board, i - 1, j, idx + 1, word) || dfs(board, i, j + 1, idx + 1, word) || dfs(board, i, j - 1, idx + 1, word);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        A079_Word_Search solution = new A079_Word_Search();
        char[][] board = new char[][]{{'A','B','C','E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "SEEB"));
    }
}
