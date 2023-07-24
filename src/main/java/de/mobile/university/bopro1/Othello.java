package de.mobile.university.bopro1;

import java.util.Scanner;

public class Othello {

    public void play() {
        Game game = new Game();
        game.start();
    }

    private class Game {
        private final Player player1;
        private final Player player2;
        private final Board board;
        private Player lastPlayBy;
        private String message;
        private Player winner;

        public Game() {
            player1 = new Player('X', "Player 1");
            player2 = new Player('O', "Player 2");
            board = new Board(8);
            message = "Welcome to Othello!";
        }

        public void start() {
            while (winner == null) {
                System.out.println(this);
                nextTurn();
                message = "Enjoy the Game!";
            }
            message = "Game Over!";
            System.out.println(this);
            if (winner != null) {
                System.out.println("Congratulations, "
                        + winner.getName() + "! You are the winner!");
            } else {
                System.out.println("It's a tie. No winner!");
            }
        }

        private void nextTurn() {
            if (isBoardFull()) {
                determineWinner();
                return;
            }

            if (null == lastPlayBy) {
                turn(player1);
            } else if (lastPlayBy.equals(player1)) {
                turn(player2);
            } else {
                turn(player1);
            }
        }

        private void turn(Player player) {
            String coordinates;
            do {
                coordinates = getPlayerInput(player);
            } while (!validateInputAndPosition(coordinates));

            updateBoard(coordinates, player);
            convertOpponentStones(coordinates, player);
            lastPlayBy = player;
        }

        private String getPlayerInput(Player player) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.toString() + ", it's your turn!");
            System.out.println("Enter coordinates for your next move:");
            return scanner.nextLine().toUpperCase();
        }

        private boolean validateInputAndPosition(String coordinates) {
            if (!checkInput(coordinates)) {
                System.out.println("Invalid coordinates," +
                        " please try again");
                return false;
            }
            int row = Character.getNumericValue(coordinates.charAt(0));
            char column = coordinates.charAt(1);
            if (board.getPosition(row, column) != null) {
                System.out.println("Field is already used," +
                        " please try again");
                return false;
            }
            return true;
        }

        private void updateBoard(String coordinates, Player player) {
            int row = Character.getNumericValue(coordinates.charAt(0));
            char column = coordinates.charAt(1);
            board.setPosition(row, column, player);
        }

        private boolean checkInput(String input) {
            if (input == null || input.length() != 2) {
                return false;
            }

            char firstDigit = input.charAt(0);
            char secondDigit = input.charAt(1);

            if (!Character.isDigit(firstDigit)
                    || firstDigit < '1' || firstDigit > '8') {
                return false;
            }
            return Character.isLetter(secondDigit)
                    && secondDigit >= 'A' && secondDigit <= 'H';
        }

        private void convertOpponentStones(String coordinates,
                                           Player currentPlayer) {
            int row = Character.getNumericValue(coordinates
                    .charAt(0)) - 1;
            int col = coordinates.charAt(1) - 'A';

            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int dir = 0; dir < 8; dir++) {
                int x = row + dx[dir];
                int y = col + dy[dir];

                boolean validDirection = isValidDirection(x, y,
                        dx[dir], dy[dir], currentPlayer);

                if (validDirection) {
                    convertStonesInDirection(x, y, dx[dir],
                            dy[dir], currentPlayer);
                }
            }
        }

        private boolean isValidDirection(int x, int y, int dx,
                                         int dy, Player currentPlayer) {
            while (x >= 0 && x < board.getSize()
                    && y >= 0 && y < board.getSize()) {
                Player stone = board.getPosition(x + 1,
                        (char) ('A' + y));
                if (stone == null) {
                    return false;
                } else if (stone == currentPlayer) {
                    return true;
                }
                x += dx;
                y += dy;
            }
            return false;
        }

        private void convertStonesInDirection(
                int x, int y, int dx, int dy, Player currentPlayer) {
            int row = x + 1;
            int col = y + 1;
            while (row >= 1 && row <= board.getSize()
                    && col >= 1 && col <= board.getSize()) {
                Player stone = board.getPosition(row,
                        (char) ('A' + col - 1));
                if (stone == currentPlayer) {
                    break;
                }
                board.setPosition(row,
                        (char) ('A' + col - 1), currentPlayer);
                row += dx;
                col += dy;
            }
        }


        private boolean isBoardFull() {
            int boardSize = board.getSize();
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (board.getPosition(i + 1,
                            (char) ('A' + j)) == null) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void determineWinner() {
            int player1Stones = 0;
            int player2Stones = 0;
            int boardSize = board.getSize();

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    Player stone = board.getPosition(i + 1,
                            (char) ('A' + j));
                    if (stone == player1) {
                        player1Stones++;
                    } else if (stone == player2) {
                        player2Stones++;
                    }
                }
            }

            if (player1Stones > player2Stones) {
                winner = player1;
            } else if (player2Stones > player1Stones) {
                winner = player2;
            } else {
                winner = null;
            }
        }


        @Override
        public String toString() {
            int boardSize = board.getSize();
            int cellWidth = 3;
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(System.lineSeparator());
            sb.append(player1.toString()).append(" VS ")
                    .append(player2.toString());
            sb.append(System.lineSeparator());
            sb.append("-".repeat(Math.max(0,
                    boardSize * cellWidth + 1)));
            sb.append(System.lineSeparator());
            sb.append(board);
            sb.append("-".repeat(Math.max(0,
                    boardSize * cellWidth + 1)));
            return sb.toString();
        }
    }

    private class Board {

        private final Player[][] board;
        private final int size;

        public Board(int size) {
            this.size = size;
            board = new Player[this.size][this.size];
        }

        public int getSize() {
            return this.size;
        }

        public Player getPosition(int xAxis, char yAxis) {
            int columnIndex = yAxis - 'A';
            int rowIndex = xAxis - 1;
            if (rowIndex >= 0 && rowIndex < board.length
                    && columnIndex >= 0 && columnIndex
                    < board[0].length) {
                return board[rowIndex][columnIndex];
            } else {
                throw new IllegalArgumentException
                        ("Invalid position coordinates.");
            }
        }

        public void setPosition(int xAxis,
                                char yAxis, Player player) {
            int columnIndex = yAxis - 'A';
            int rowIndex = xAxis - 1;
            if (rowIndex >= 0 && rowIndex < board.length
                    && columnIndex >= 0 && columnIndex
                    < board[0].length) {
                board[rowIndex][columnIndex] = player;
            } else {
                throw new IllegalArgumentException
                        ("Invalid position coordinates.");
            }
        }

        @Override
        public String toString() {
            int boardSize = board.length;
            int cellWidth = 2;

            StringBuilder sb = new StringBuilder();
            sb.append("  ");
            for (int j = 0; j < boardSize; j++) {
                sb.append((char) ('A' + j)).append("  ");
            }
            sb.append(System.lineSeparator());
            for (int i = 0; i < boardSize; i++) {
                sb.append(i + 1).append(' '); // Row number
                for (int j = 0; j < boardSize; j++) {
                    Player player = board[i][j];
                    char symbol = player != null
                            ? player.getSymbol() : '-';
                    sb.append(String.format("%-" + (cellWidth)
                            + "s", symbol)).append(' ');
                }
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    private static class Player {
        private final char symbol;
        private final String name;

        Player(char symbol, String name) {
            this.symbol = symbol;
            this.name = name;
        }

        public char getSymbol() {
            return symbol;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " (" + symbol + ")";
        }
    }
}