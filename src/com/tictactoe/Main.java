package com.tictactoe;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean usersMove = false;
    private static final boolean[][] occupied = new boolean[3][3];

    public static void main(String[] args) {
        String input = scanner.next();
        printState(input);
    }

    private static void printState(String state) {
        refreshOccupied(state);
        printDelimiterRow();
        printRow(state.substring(0, 3));
        printRow(state.substring(3, 6));
        printRow(state.substring(6, 9));
        printDelimiterRow();
        //StateAnalyzer.analyzeState(state);
        if (!usersMove) {
            int[] moveCoordinates = promptUser();
            usersMove = true;
            printState(move(state, moveCoordinates));
        }
    }

    private static void refreshOccupied(String state) {
        for (int i = 0, j = 0; i < state.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                j++;
            }
            occupied[j][i % 3] = state.charAt(i) != '_';
        }
    }
    private static void printDelimiterRow(){
        System.out.println("---------");
    }

    private static void printRow(String row) {
        System.out.println("| " + row.charAt(0) + " " + row.charAt(1) + " " + row.charAt(2) + " |");
    }

    private static int[] promptUser() {
        int[] result = {0, 0};
        boolean moved = false;
        while(!moved) {
            try {
                //printPromptMessage();
                result[0] = scanner.nextInt();
                result[1] = scanner.nextInt();

                if ((result[0] > 0 && result[0] < 4) && (result[1] > 0 && result[1] < 4)) {
                    if (occupied[result[0] - 1][result[1] - 1]) {
                        printCellIsOccupied();
                    } else {
                        moved = true;
                    }
                } else {
                    printInvalidCoordinateNumberWarning();
                }
            } catch (NumberFormatException e) {
                printNonNumericSymbolWarning();
            }
        }
        return result;
    }

    private static String move(String previousState, int[] cellCoordinates) {
        StringBuilder result = new StringBuilder(previousState);
        result.setCharAt((cellCoordinates[0] - 1) * 3 + cellCoordinates[1] - 1,'X');
        return result.toString();
    }

    private static void printPromptMessage() {
        System.out.print("Please, make a move by specifying 2 coordinate numbers: ");
    }

    private static void printInvalidCoordinateNumberWarning() {
        System.out.println("Coordinates should be from 1 to 3!");
    }

    private static void printNonNumericSymbolWarning() {
        System.out.println("You should enter numbers!");
    }

    private static void printCellIsOccupied() {
        System.out.println("This cell is occupied! Choose another one!");
    }

}
