package sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sudoku {

    private int[][] board;
    private int[][] solution;
    private Random random;
    private JFrame frame;
    private JTextField[][] textFields;
    private boolean gameOver;

    public Sudoku() {
        this.board = new int[9][9];
        this.solution = new int[9][9];
        this.random = new Random();
        generateSolution();
        generateBoard();
        createGUI();
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
        if (row == 8 && col == 9) {
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

    private void createGUI() {
        frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        textFields = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER);
                if (board[i][j] != 0) {
                    textField.setText(String.valueOf(board[i][j]));
                    textField.setEditable(false);
                }
                textFields[i][j] = textField;
                gridPanel.add(textField);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(e -> {
            if (gameOver) {
                return;
            }
            boolean isValid = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (textFields[i][j].isEditable()) {
                        try {
                            int num = Integer.parseInt(textFields[i][j].getText());
                            if (!isValidMove(i, j, num)) {
                                isValid = false;
                            } else {
                                board[i][j] = num;
                            }
                        } catch (NumberFormatException ex) {
                            isValid = false;
                        }
                    }
                }
            }
            if (isValid) {
                if (isSolved()) {
                    JOptionPane.showMessageDialog(frame, "Congratulations, you solved the Sudoku!");
                    gameOver = true;
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid move, try again.");
            }
        });

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            gameOver = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    textFields[i][j].setText("");
                    textFields[i][j].setEditable(true);
                    board[i][j] = 0;
                }
            }
            generateSolution();
            generateBoard();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != 0) {
                        textFields[i][j].setText(String.valueOf(board[i][j]));
                        textFields[i][j].setEditable(false);
                    }
                }
            }
        });

        frame.add(gridPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(newGameButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
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

    public static void main(String[] args) {
        new Sudoku();
    }
}
