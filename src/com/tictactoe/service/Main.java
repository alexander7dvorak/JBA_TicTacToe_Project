package com.tictactoe.service;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Service
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean userXMove = true;
    private static boolean[][] occupied = new boolean[3][3];

    @PostConstruct
    public static void start() {
        printState();
    }

    private static void printState() {
        Printer.printDelimiterRow();
        Printer.printRow();
        Printer.printRow();
        Printer.printRow();
        Printer.printDelimiterRow();
        int[] moveCoordinates = promptUser();
        printState(move("         ", moveCoordinates));
    }

    private static void printState(String state) {
        refreshOccupied(state);
        Printer.printDelimiterRow();
        Printer.printRow(state.substring(0,3));
        Printer.printRow(state.substring(3,6));
        Printer.printRow(state.substring(6,9));
        Printer.printDelimiterRow();
        if (!StateAnalyzer.isEndingState(state)) {
            int[] moveCoordinates = promptUser();
            printState(move(state, moveCoordinates));
        }
    }

    private static void refreshOccupied(String state) {
        for (int i = 0, j = 0; i < state.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                j++;
            }
            occupied[j][i % 3] = state.charAt(i) == 'X' || state.charAt(i) == 'O';
        }
    }

    private static int[] promptUser() {
        int[] result = {0, 0};
        boolean moved = false;
        while(!moved) {
            try {
                result[0] = scanner.nextInt();
                result[1] = scanner.nextInt();

                if ((result[0] > 0 && result[0] < 4) && (result[1] > 0 && result[1] < 4)) {
                    if (occupied[result[0] - 1][result[1] - 1]) {
                        Printer.printCellIsOccupied();
                    } else {
                        moved = true;
                    }
                } else {
                    Printer.printInvalidCoordinateNumberWarning();
                }
            } catch (NumberFormatException e) {
                Printer.printNonNumericSymbolWarning();
            }
        }
        return result;
    }

    private static String move(String previousState, int[] cellCoordinates) {
        StringBuilder result = new StringBuilder(previousState);
        result.setCharAt((cellCoordinates[0] - 1) * 3 + cellCoordinates[1] - 1, userXMove ? 'X' : 'O');
        userXMove = !userXMove;
        return result.toString();
    }
}
