package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = new char[9];
        str = str.toUpperCase();
        for (int i = 0; i < chars.length; i++) {
            if (str.charAt(i) != 'X' && str.charAt(i) != '_' && str.charAt(i) != 'O') {
                System.out.println("Wrong input");
            }
            chars[i] = str.charAt(i);
        }
        char[][] matrix = new char[3][3];

        System.out.println("---------");
        System.out.println("| " + chars[0] + " " + chars[1]
                + " " + chars[2] + " |");
        System.out.println("| " + chars[3] + " " + chars[4]
                + " " + chars[5] + " |");
        System.out.println("| " + chars[6] + " " + chars[7]
                + " " + chars[8] + " |");
        System.out.println("---------");

        if (isPossible(chars) && x_WinsCondition(chars) && !o_WinsCondition(chars)) {
            System.out.println("X wins");
        } else if(isPossible(chars) && o_WinsCondition(chars) && !x_WinsCondition(chars)) {
            System.out.println("O wins");
        } else if (!contains('_', chars)) {
            System.out.println("Draw");
        } else if (contains('_', chars)
                && (!o_WinsCondition(chars) || !x_WinsCondition(chars)) && isPossible(chars)) {
            System.out.println("Game not finished");
        } else if (!isPossible(chars) || o_WinsCondition(chars) && x_WinsCondition(chars)) {
            System.out.println("Impossible");
        }
    }

    public static boolean o_WinsCondition (char[] chars) {
        if (chars[0] == 'O' && chars[1] == 'O' && chars[2] == 'O'
                || chars[0] == 'O' && chars[4] == 'O' && chars[8] == 'O'
                || chars[2] == 'O' && chars[4] == 'O' && chars[6] == 'O'
                || chars[3] == 'O' && chars[4] == 'O' && chars[5] == 'O'
                || chars[6] == 'O' && chars[7] == 'O' && chars[8] == 'O'
                || chars[0] == 'O' && chars[3] == 'O' && chars[6] == 'O'
                || chars[1] == 'O' && chars[4] == 'O' && chars[7] == 'O'
                || chars[2] == 'O' && chars[5] == 'O' && chars[8] == 'O') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean x_WinsCondition (char[] chars) {
        if (chars[0] == 'X' && chars[1] == 'X' && chars[2] == 'X'
                || chars[0] == 'X' && chars[4] == 'X' && chars[8] == 'X'
                || chars[2] == 'X' && chars[4] == 'X' && chars[6] == 'X'
                || chars[3] == 'X' && chars[4] == 'X' && chars[5] == 'X'
                || chars[6] == 'X' && chars[7] == 'X' && chars[8] == 'X'
                || chars[0] == 'X' && chars[3] == 'X' && chars[6] == 'X'
                || chars[1] == 'X' && chars[4] == 'X' && chars[7] == 'X'
                || chars[2] == 'X' && chars[5] == 'X' && chars[8] == 'X') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPossible (char[] arr) {
        int countX = 0;
        int CountO = 0;
        for (char ch : arr) {
            if (ch == 'X') {
                countX++;
            } else if (ch == 'O') {
                CountO++;
            }
        }
        if (Math.abs(CountO - countX) > 1) {
            return false;
        }
        return true;
    }
}
