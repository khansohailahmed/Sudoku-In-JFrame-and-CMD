package sudoku;

import java.util.Random;
import java.util.Scanner;

public class Sudokuincmd {

    private int[][] board;
    private int[][] solution;
    private Random random;
    private Scanner scanner;

    public Sudokuincmd() {
        this.board = new int[9][9];
        this.solution = new int[9][9];
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        generateSolution();
        generateBoard();
    }

    private void generateSolution() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solution[i][j] = 0;
            }
        }
        fillSolution(0, 0);
    }

    private boolean fillSolution(int row, int col) {
        if (row == 9 - 1 && col == 9) {
            return true;
        }
        if (col == 9) {
            row++;
            col = 0;
        }
        if (solution[row][col] != 0) {
            return fillSolution(row, col + 1);
        }
        for (int num = 1; num <= 9; num++) {
            if (isValidSolution(row, col, num)) {
                solution[row][col] = num;
                if (fillSolution(row, col + 1)) {
                    return true;
                }
                solution[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValidSolution(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (solution[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (solution[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (solution[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private void generateBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (random.nextInt(2) == 0) {
                    board[i][j] = solution[i][j];
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public void play() {
        printBoard();
        while (true) {
            System.out.println("Enter row (0-8):");
            int row = scanner.nextInt();
            System.out.println("Enter column (0-8):");
            int col = scanner.nextInt();
            System.out.println("Enter number (1-9):");
            int num = scanner.nextInt();
            if (isValidMove(row, col, num)) {
                board[row][col] = num;
                printBoard();
                if (isSolved()) {
                    System.out.println("Congratulations, you solved the Sudoku!");
                    break;
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % 3 == 0 && j < 8) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println("---------+---------+---------");
            }
        }
    }

    public static void main(String[] args) {
        Sudokuincmd sudoku1 = new Sudokuincmd();
        sudoku1.play();
    }
}
