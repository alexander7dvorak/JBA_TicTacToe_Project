package com.tictactoe;

public class Printer {
    /* Uncomment if instructions are needed for the user
    public static void printPromptMessage() {
        System.out.print("Please, make a move by specifying 2 coordinate numbers: ");
    }
    */

    public static void printDelimiterRow(){
        System.out.println("---------");
    }

    public static void printRow() {
        System.out.println("|       |");
    }
    public static void printRow(String row) {
        System.out.println("| " + row.charAt(0) + " " + row.charAt(1) + " " + row.charAt(2) + " |");
    }

    public static void printInvalidCoordinateNumberWarning() {
        System.out.println("Coordinates should be from 1 to 3!");
    }

    public static void printNonNumericSymbolWarning() {
        System.out.println("You should enter numbers!");
    }

    public static void printCellIsOccupied() {
        System.out.println("This cell is occupied! Choose another one!");
    }
}
