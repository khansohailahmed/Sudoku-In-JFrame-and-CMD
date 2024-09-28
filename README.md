# Sudoku Game in Java (JFrame and Command Line)

## Project Overview

This project is a **Java-based Sudoku game** that offers two different gameplay interfaces:
1. **Graphical User Interface (GUI) version using `JFrame`**: This interactive version allows users to play Sudoku with a graphical interface.
2. **Command-Line Interface (CLI) version**: A simpler, text-based version that runs in the command line.

Both versions generate solvable Sudoku puzzles using a **backtracking algorithm**. The game ensures that each puzzle has a unique solution, and the program includes functionality to validate the player's input and verify if the puzzle is solved correctly.

## Key Features

### 1. **Backtracking Algorithm for Puzzle Generation**
   - The game generates valid Sudoku puzzles using a backtracking algorithm, ensuring that every puzzle has a unique solution.

### 2. **Graphical User Interface (GUI)**
   - Built using **Java Swing** and **JFrame**, the GUI version provides an interactive Sudoku grid where users can select cells and input numbers.
   - Users can fill in the grid interactively by clicking on the cells and typing in their answers.
   - Visual feedback is provided to show whether the puzzle is solved correctly.

### 3. **Command-Line Interface (CLI)**
   - A simple, text-based version that runs in the command line.
   - Users can play Sudoku by typing their moves into the terminal, providing a minimalist, no-frills gameplay experience.
   - The CLI version validates inputs and checks if the puzzle is solved.

### 4. **Input Validation**
   - Both versions of the game check user input to ensure valid Sudoku entries (numbers between 1-9) are made.
   - The game also checks for duplicate numbers in rows, columns, and 3x3 grids, warning users of invalid moves.

### 5. **Solution Checking**
   - The game automatically verifies whether the player has correctly solved the puzzle.
   - If the solution is correct, a success message is displayed.

## Technologies Used

- **Java**: The core programming language used to build both the GUI and CLI versions.
- **Java Swing and JFrame**: Used to create the graphical user interface for the Sudoku game.
- **Backtracking Algorithm**: Ensures that the Sudoku puzzles are solvable and have a unique solution.

## Installation and Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed on your system.
2. **Java IDE**: Optional but recommended. You can use IntelliJ IDEA, Eclipse, or NetBeans for running the project.

### Steps to Set Up

1. **Clone the Repository**  
   Clone the GitHub repository to your local machine:
   ```bash
   git clone https://github.com/khansohailahmed/Sudoku-JFrame-CMD.git
   ```

2. **Compile and Run the Program**
   You can either compile and run the project using an IDE or via the command line.

   #### Running the GUI Version:
   ```bash
   javac SudokuGUI.java
   java SudokuGUI
   ```

   #### Running the CLI Version:
   ```bash
   javac SudokuCLI.java
   java SudokuCLI
   ```

## Gameplay Instructions

### GUI Version (JFrame)
1. Launch the **SudokuGUI** application.
2. A 9x9 Sudoku grid will be displayed.
3. Click on any cell to enter a number between 1-9.
4. Once you fill the grid, the game will automatically check if the solution is correct and display a success message if solved correctly.

### CLI Version (Command Line)
1. Launch the **SudokuCLI** application from the terminal.
2. The Sudoku grid will be displayed in text form.
3. Enter your moves by specifying the row, column, and number (e.g., `5 3 9` to place `9` at row 5, column 3).
4. After completing the grid, the program will check your solution and inform you whether the puzzle is solved correctly.

## Project Structure

```
├── src
│   ├── SudokuGUI.java   # Main class for the graphical version of the game
│   ├── SudokuCLI.java   # Main class for the command-line version of the game
│   ├── SudokuGrid.java  # Class for handling the Sudoku grid logic and validation
│   ├── Backtracking.java # Class implementing the puzzle generation algorithm
│   └── README.md        # This README file
```

### Classes

- **SudokuGUI**: Handles the GUI version of the game using Java Swing and JFrame.
- **SudokuCLI**: Handles the command-line version of the game.
- **SudokuGrid**: Contains the core logic for checking the validity of user inputs, managing the Sudoku grid, and checking if the puzzle is solved.
- **Backtracking**: Implements the backtracking algorithm for generating solvable Sudoku puzzles.

## Contributing

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push the changes to your fork.
5. Open a pull request with a description of your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any issues or questions, feel free to reach out via khansohailtufailahmed@gmail.com.
