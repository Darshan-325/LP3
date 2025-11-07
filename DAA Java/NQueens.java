import java.util.Scanner;

public class NQueens {

    static void printBoard(int[][] board, int N) {
        System.out.println("Final N-Queens matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solveNQueens(int[][] board, int row, int N) {
        if (row >= N)
            return true;

        for (int col = 0; col < N; col++) {
            if (board[row][col] == 1 || !isSafe(board, row, col, N))
                continue;

            board[row][col] = 1;

            if (solveNQueens(board, row + 1, N))
                return true;

            board[row][col] = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of chessboard N: ");
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        System.out.print("Enter row (0-based) for first queen: ");
        int firstRow = sc.nextInt();

        System.out.print("Enter column (0-based) for first queen: ");
        int firstCol = sc.nextInt();

        board[firstRow][firstCol] = 1;

        int startRow = (firstRow == 0) ? 1 : 0;

        if (solveNQueens(board, startRow, N)) {
            printBoard(board, N);
        } else {
            System.out.println("No solution exists with the first queen at (" + firstRow + "," + firstCol + ")");
        }

        sc.close();
    }
}
