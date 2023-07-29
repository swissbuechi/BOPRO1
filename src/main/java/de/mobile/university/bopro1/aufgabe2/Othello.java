package de.mobile.university.bopro1.aufgabe2;

import java.util.Scanner;

public class Othello {

    private final Character[][] board;
    private final char player1;
    private final char player2;
    private Character lastPlayBy;
    private String message;
    private Character winner;

    public Othello() {
        player1 = 'X';
        player2 = 'O';
        board = new Character[8][8];
        message = "Welcome to Othello!";
    }

    public void start() {
        while (winner == null) {
            System.out.println(printGame());
            nextTurn();
            message = "Enjoy the Game!";
        }
        message = "Game Over!";
        System.out.println(printGame());
        if (winner != null) {
            System.out.println("Congratulations, "
                    + winner + "! You are the winner!");
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

    private void turn(Character player) {
        String coordinates;
        do {
            coordinates = getPlayerInput(player);
        } while (!validateInputAndPosition(coordinates));

        updateBoard(coordinates, player);
        convertOpponentStones(coordinates, player);
        lastPlayBy = player;
    }

    private String getPlayerInput(Character player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player + ", it's your turn!");
        System.out.println("Enter coordinates " +
                "for your next move:");
        return scanner.nextLine().toUpperCase();
    }

    private boolean validateInputAndPosition(
            String coordinates) {
        if (!checkInput(coordinates)) {
            System.out.println("Invalid coordinates," +
                    " please try again");
            return false;
        }
        int col = coordinates.charAt(0) - 'A';
        int row = Character.getNumericValue(
                coordinates.charAt(1)) - 1;
        if (getPosition(row, col) != null) {
            System.out.println("Field is already used," +
                    " please try again");
            return false;
        }
        return true;
    }

    private void updateBoard(String coordinates, char player) {
        int col = coordinates.charAt(0) - 'A';
        int row = Character.getNumericValue(
                coordinates.charAt(1)) - 1;
        setPosition(row, col, player);
    }

    private boolean checkInput(String input) {
        if (input == null || input.length() != 2) {
            return false;
        }

        char firstDigit = input.charAt(0);
        char secondDigit = input.charAt(1);

        if (!Character.isLetter(firstDigit)
                || firstDigit < 'A' || firstDigit > 'H') {
            return false;
        }
        return Character.isDigit(secondDigit)
                && secondDigit >= '1' && secondDigit <= '8';
    }

    private void convertOpponentStones(String coordinates,
                                       char currentPlayer) {
        int row = Character.getNumericValue(coordinates
                .charAt(1)) - 1;
        int col = coordinates.charAt(0) - 'A';

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

    private boolean isValidDirection
            (int x, int y, int dx, int dy,
             Character currentPlayer) {
        while (x >= 0 && x < 8
                && y >= 0 && y < 8) {
            Character stone = getPosition(x, y);
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
            int x, int y, int dx, int dy,
            char currentPlayer) {
        int row = x;
        int col = y;
        while (row >= 0 && row < 8 && col >= 0 && col < 8) {
            char stone = getPosition(row, col);
            if (stone == currentPlayer) {
                break;
            }
            setPosition(row, col, currentPlayer);
            row += dx;
            col += dy;
        }
    }


    private boolean isBoardFull() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getPosition(i, j) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private void determineWinner() {
        int player1Stones = 0;
        int player2Stones = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char stone = getPosition(i, j);
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

    private Character getPosition(int row, int col) {
        if (row >= 0 && row < board.length
                && col >= 0 && col < board[0].length) {
            return board[row][col];
        } else {
            throw new IllegalArgumentException
                    ("Invalid position coordinates.");
        }
    }

    private void setPosition(int row, int col, char player) {
        if (row >= 0 && row < board.length
                && col >= 0 && col < board[0].length) {
            board[row][col] = player;
        } else {
            throw new IllegalArgumentException
                    ("Invalid position coordinates.");
        }
    }

    private String printGame() {
        int cellWidth = 3;
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(System.lineSeparator());
        sb.append(player1).append(" VS ")
                .append(player2);
        sb.append(System.lineSeparator());
        final String separator = "-".repeat(Math.max(0,
                8 * cellWidth + 1));
        sb.append(separator);
        sb.append(System.lineSeparator());
        sb.append(printBoard());
        sb.append(separator);
        return sb.toString();
    }

    private String printBoard() {
        int cellWidth = 2;
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int j = 0; j < 8; j++) {
            sb.append((char) ('A' + j))
                    .append("  ");
        }
        sb.append(System.lineSeparator());
        for (int i = 0; i < 8; i++) {
            sb.append(i + 1).append(' ');
            for (int j = 0; j < 8; j++) {
                Character player = board[i][j];
                char symbol = player != null
                        ? player : '-';
                sb.append(String.format("%-"
                        + (cellWidth)
                        + "s", symbol)).append(' ');
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}