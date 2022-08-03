package com.tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        printState(input);
    }

    private static void printState(String state) {
        printDelimiterRow();
        printRow(state.substring(0, 3));
        printRow(state.substring(3, 6));
        printRow(state.substring(6, 9));
        printDelimiterRow();
    }

    private static void printDelimiterRow() {
        System.out.println("---------");
    }

    private static void printRow(String row) {
        System.out.println("| " + row.charAt(0) + " " + row.charAt(1) + " " + row.charAt(2) + " |");
    }
}
