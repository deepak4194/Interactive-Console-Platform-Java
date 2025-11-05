import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

interface OnlineGaming
{
	void playTicTacToe();
	void playEightPuzzle();
	void playNumberGuessingGame();
	void playRockPaperScissors();
	void hangMan();
}

public class Games implements OnlineGaming
{
    public static void main(String[] args) 
	{
		Games g = new Games();
        Scanner scanner = new Scanner(System.in);
        int choice;
		while (true)
		{
			System.out.println("Choose a game to play:");
			System.out.println("1. Tic Tac Toe");
			System.out.println("2. Eight Puzzle");
			System.out.println("3. Number Guessing Game");
			System.out.println("4. Rock Paper Scissors");
			System.out.println("5. Hangman");
			System.out.println("6. Exit");
			System.out.print("Enter the number of the game you want to play : ");
			choice = scanner.nextInt();
			System.out.println("");
			switch (choice) 
			{
				case 1:
					g.playTicTacToe();
					break;
				case 2:
					g.playEightPuzzle();
					break;
				case 3:
					g.playNumberGuessingGame();
					break;
				case 4:
					g.playRockPaperScissors();
					break;
				case 5:
					g.hangMan();
					break;
				case 6:
					System.out.println("Thanks for playing...");
					break;
				default:
					System.out.println("Invalid choice. Exiting...");
			}
			if(choice==6)
				break;
		}
    }

    // Tic Tac Toe Game
    public void playTicTacToe() 
	{
        char[][] board = new char[3][3];
        char currentPlayer = 'X';

        initializeBoard(board);
        displayBoard(board);

        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) 
		{
            System.out.print("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            System.out.println(""); 
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '\u0000') 
			{
                board[row][col] = currentPlayer;
                displayBoard(board);
                if (checkWin(board, row, col, currentPlayer)) 
				{
                    System.out.println("Player " + currentPlayer + " wins!");
					System.out.println(" ");
                    gameEnded = true;
                } 
				else if (checkDraw(board)) 
				{
                    System.out.println("It's a draw!");
					System.out.println("");
                    gameEnded = true;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } 
			else 
			{
                System.out.println("Invalid move! Try again.");
				System.out.println("");
            }
        }
    }

    private static void initializeBoard(char[][] board) 
	{
        for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                board[i][j] = '\u0000';
            }
        }
    }

    private static void displayBoard(char[][] board) 
	{
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) 
		{
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
			{
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean checkWin(char[][] board, int row, int col, char currentPlayer) 
	{
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
                (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
                (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean checkDraw(char[][] board) 
	{
        for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                if (board[i][j] == '\u0000') 
				{
                    return false;
                }
            }
        }
        return true;
    }

    // Implement the Eight Puzzle game
        public void playEightPuzzle() 
		{
        int[][] puzzle = {{1, 5, 2}, {4, 8, 3}, {7, 6, 0}}; // Initial state of the puzzle
        int[][] target = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}; // Target state to solve
        Scanner scanner = new Scanner(System.in);
		System.out.println("Goal Puzzle :");
		displayGoalPuzzle(target);
        while (!Arrays.deepEquals(puzzle, target)) 
		{
            displayPuzzle(puzzle);
            System.out.print("Enter the number you want to move (1-8) or 0 to exit:");
            int move = scanner.nextInt();
            System.out.println("");
            if (move == 0) 
			{
                System.out.println("Exiting the game.");
				System.out.println("");
                break;
            }
            if (!makeMove(puzzle, move)) 
			{
                System.out.println("Invalid move! Please try again.");
				System.out.println("");
            }
        }
        if (Arrays.deepEquals(puzzle, target)) 
		{
            System.out.println("Congratulations! You solved the puzzle.");
			System.out.println("");
        }
    }
	
	public static void displayGoalPuzzle(int[][] target) 
	{
        for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                System.out.print(target[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displayPuzzle(int[][] puzzle) 
	{
        System.out.println("Present State : ");
		for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean makeMove(int[][] puzzle, int move) 
	{
        int[] position = findPosition(puzzle, move);
        if (position == null) 
		{
            return false;
        }
        
        int row = position[0];
        int col = position[1];
        
        int[] blankPosition = findPosition(puzzle, 0);
        int blankRow = blankPosition[0];
        int blankCol = blankPosition[1];
        
        if ((Math.abs(row - blankRow) == 1 && col == blankCol) || (Math.abs(col - blankCol) == 1 && row == blankRow)) 
		{
            puzzle[blankRow][blankCol] = move;
            puzzle[row][col] = 0;
            return true;
        } 
		else 
		{
            return false;
        }
    }
    
    public static int[] findPosition(int[][] puzzle, int value) 
	{
        int[] position = new int[2];
        for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                if (puzzle[i][j] == value) 
				{
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return null;
    }

    public void playNumberGuessingGame() 
	{
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");
		System.out.println("");
		
        while (!hasGuessedCorrectly) 
		{
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
			System.out.println("");
            attempts++;

            if (guess == numberToGuess) 
			{
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
				System.out.println("");
                hasGuessedCorrectly = true;
            } 
			else if (guess < numberToGuess) 
			{
                System.out.println("Try a higher number.");
				System.out.println("");
            } 
			else 
			{
                System.out.println("Try a lower number.");
				System.out.println("");
            }
        }
    }

    public void playRockPaperScissors() 
	{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        System.out.println("Welcome to Rock Paper Scissors!");
		System.out.println("");

        while (true) 
		{
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String playerChoice = scanner.next().toLowerCase();
			System.out.println("");
            if (!Arrays.asList(choices).contains(playerChoice)) 
			{
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
				System.out.println("");
                continue;
            }

            String computerChoice = choices[random.nextInt(choices.length)];

            System.out.println("Computer's choice: " + computerChoice);

            if (playerChoice.equals(computerChoice)) 
			{
                System.out.println("It's a tie!");
				System.out.println("");				
            } 
			else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper"))) 
			{
                System.out.println("You win!");
				System.out.println("");
            } 
			else {
                System.out.println("Computer wins!");
				System.out.println("");
            }

            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            System.out.println("");
            if (!playAgain.equals("yes")) {
                break;
            }
        }
    }
	
	public void hangMan()
	{
		Scanner scanner = new Scanner(System.in);

        String[] words = {"java", "hangman", "programming", "computer", "language"}; 
        String wordToGuess = words[(int) (Math.random() * words.length)];
        char[] guessedLetters = new char[wordToGuess.length()];

        for (int i = 0; i < guessedLetters.length; i++) 
		{
            guessedLetters[i] = '_';
        }

        int attempts = 7;
        boolean wordGuessed = false;

        while (attempts > 0 && !wordGuessed) 
		{
            System.out.println("Word to guess: " + String.valueOf(guessedLetters));
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
			System.out.println("");
            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) 
			{
                if (wordToGuess.charAt(i) == guess) 
				{
                    guessedLetters[i] = guess;
                    found = true;
                }
            }

            if (!found) 
			{
                attempts--;
                System.out.println("Incorrect guess!");
				System.out.println("");
            }

            if (String.valueOf(guessedLetters).equals(wordToGuess)) 
			{
                wordGuessed = true;
            }
        }

        if (wordGuessed) 
		{
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
			System.out.println("");
        } 
		else 
		{
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
			System.out.println("");
        }
	}
}
