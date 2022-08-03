package com.tictactoe;


public class StateAnalyzer {
    public static void analyzeState(String state) {
        boolean winsX = isWinning(state, 'X');
        boolean winsO = isWinning(state, 'O');
        boolean hasEmptyCell = state.contains("_");
        int countX = (int) state.chars().filter(ch -> ch == 'X').count();
        int countO = (int) state.chars().filter(ch -> ch == 'O').count();

        printResult(winsX, winsO, hasEmptyCell, countX, countO);
    }

    private static boolean isWinning(String state, char player) {
        return  state.charAt(0) == player && state.charAt(1) == player && state.charAt(2) == player ||
                state.charAt(3) == player && state.charAt(4) == player && state.charAt(5) == player ||
                state.charAt(6) == player && state.charAt(7) == player && state.charAt(8) == player ||
                state.charAt(0) == player && state.charAt(3) == player && state.charAt(6) == player ||
                state.charAt(1) == player && state.charAt(4) == player && state.charAt(7) == player ||
                state.charAt(2) == player && state.charAt(5) == player && state.charAt(8) == player ||
                state.charAt(0) == player && state.charAt(4) == player && state.charAt(8) == player ||
                state.charAt(2) == player && state.charAt(4) == player && state.charAt(6) == player;
    }

    private static void printResult(boolean winsX, boolean winsO, boolean hasEmptyCell, int countX, int countO) {
        if(Math.abs(countX - countO) > 1) {
            System.out.println("Impossible");
            return;
        }

        if (winsX) {
            if (winsO) {
                System.out.println("Impossible");
            } else {
                System.out.println("X wins");
            }
        } else if(winsO) {
                System.out.println("O wins");
        } else if (hasEmptyCell) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }
}
