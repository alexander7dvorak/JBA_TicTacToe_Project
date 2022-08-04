package com.tictactoe.service;

public class StateAnalyzer {
    public static boolean isEndingState(String state) {
        boolean hasEmptyCell = state.contains(" ");
        boolean winsX = isWinning(state, 'X');
        boolean winsO = isWinning(state, 'O');
        int countX = (int) state.chars().filter(ch -> ch == 'X').count();
        int countO = (int) state.chars().filter(ch -> ch == 'O').count();

        return printResult(winsX, winsO, hasEmptyCell, countX, countO);
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

    private static boolean printResult(boolean winsX, boolean winsO, boolean hasEmptyCell, int countX, int countO) {
        if(Math.abs(countX - countO) > 1) {
            return false;
        }

        if (winsX) {
            if (winsO) {
                return false;
            } else {
                System.out.println("X wins");
                return true;
            }
        } else if(winsO) {
            System.out.println("O wins");
            return true;
        } else if (!hasEmptyCell) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }
}
