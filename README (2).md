# Interactive Console Platform Java

A console-based interactive entertainment platform featuring five classic activities implemented in Java. This project demonstrates object-oriented programming concepts, interface implementation, and menu-driven architecture.

## Overview

This platform provides a unified interface to access multiple interactive console activities through a single Java application. Built with clean architecture using interfaces and modular design patterns.

## Features

The platform includes five interactive activities:

- **Tic Tac Toe** - Classic two-player strategy challenge on a 3x3 grid
- **Eight Puzzle** - Sliding puzzle solver with goal state matching
- **Number Guessing** - Random number prediction with attempt tracking
- **Rock Paper Scissors** - Single-player challenge against computer AI
- **Hangman** - Word guessing challenge with limited attempts

## Technologies Used

- **Language**: Java
- **Libraries**: java.util.Scanner, java.util.Arrays, java.util.Random
- **Paradigm**: Object-Oriented Programming (OOP)
- **Design Pattern**: Interface-based implementation


## Architecture

The project uses an interface-driven design:

- **Interface**: `OnlineGaming` - Defines method contracts for all activities
- **Implementation Class**: `Games` - Implements all interface methods
- **Main Menu**: Interactive console menu for activity selection

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)
- Command line terminal or IDE (Eclipse, IntelliJ IDEA, VS Code)

### Setup

1. Clone the repository:
```bash
git clone https://github.com/yourusername/interactive-console-platform-java.git
cd interactive-console-platform-java
```

2. Compile the Java file:
```bash
javac Games.java
```

3. Run the application:
```bash
java Games
```

## Usage

Upon running the application, you'll see a menu with six options:

```
Choose a game to play:
1. Tic Tac Toe
2. Eight Puzzle
3. Number Guessing Game
4. Rock Paper Scissors
5. Hangman
6. Exit
```

Enter the number corresponding to your choice and follow the on-screen instructions for each activity.

### Activity Instructions

#### 1. Tic Tac Toe
- Two players alternate turns (X and O)
- Enter row and column numbers (1-3) for your move
- First player to align three marks wins

#### 2. Eight Puzzle
- Rearrange numbered tiles to match the goal state
- Enter the number you want to move (1-8)
- Only adjacent tiles to the blank space can move

#### 3. Number Guessing
- Guess the random number between 1 and 100
- Receive hints (higher/lower) after each guess
- Track your attempts to completion

#### 4. Rock Paper Scissors
- Enter your choice: rock, paper, or scissors
- Computer makes a random selection
- Classic rules apply for determining winner

#### 5. Hangman
- Guess letters to reveal the hidden word
- You have 7 incorrect attempts before losing
- Words are randomly selected from a predefined list

## Code Structure

### Interface Definition
```java
interface OnlineGaming {
    void playTicTacToe();
    void playEightPuzzle();
    void playNumberGuessingGame();
    void playRockPaperScissors();
    void hangMan();
}
```

### Main Class
The `Games` class implements the `OnlineGaming` interface and provides implementations for all five activities plus helper methods for each.

## Key Methods

| Method | Description |
|--------|-------------|
| `playTicTacToe()` | Implements two-player Tic Tac Toe logic |
| `playEightPuzzle()` | Sliding puzzle solver with goal matching |
| `playNumberGuessingGame()` | Random number generation and comparison |
| `playRockPaperScissors()` | Player vs computer choice comparison |
| `hangMan()` | Word guessing with attempt tracking |

## Features Demonstrated

- **Interface Implementation** - Clean contract-based design
- **Menu-Driven Architecture** - User-friendly console navigation
- **Input Validation** - Robust error handling for user inputs
- **Modular Design** - Separate methods for each activity
- **Game Logic** - Win/loss/draw detection algorithms
- **Random Generation** - Dynamic content creation

