package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = new char[9];
        str = str.toUpperCase();
        for (int i = 0; i < chars.length; i++) {
            if (str.charAt(i) != 'X' && str.charAt(i) != ' ' && str.charAt(i) != 'O') {
                System.out.println("Wrong input");
            }
            chars[i] = str.charAt(i);
        }
        char[][] matrix = new char[4][4];
        matrix[1][3] = chars[0];
        matrix[2][3] = chars[1];
        matrix[3][3] = chars[2];
        matrix[1][2] = chars[3];
        matrix[2][2] = chars[4];
        matrix[3][2] = chars[5];
        matrix[1][1] = chars[6];
        matrix[2][1] = chars[7];
        matrix[3][1] = chars[8];

        boolean xTurn = true;
        drawField(matrix);

        while (!x_WinsCondition(chars) || !o_WinsCondition(chars) || !contains(' ', chars)) {
            try {
                System.out.print("Enter the coordinates: ");
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                if (isEmpty(matrix, first, second)) {
                    if (xTurn) {
                        matrix[first][second] = 'X';
                        xTurn = false;
                    } else {
                        matrix[first][second] = 'O';
                        xTurn = true;
                    }
                    drawField(matrix);
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }

        if (isPossible(chars) && x_WinsCondition(chars) && !o_WinsCondition(chars)) {
            System.out.println("X wins");
        } else if(isPossible(chars) && o_WinsCondition(chars) && !x_WinsCondition(chars)) {
            System.out.println("O wins");
        } else if (!contains(' ', chars)) {
            System.out.println("Draw");
        } else if (contains(' ', chars)
                && (!o_WinsCondition(chars) || !x_WinsCondition(chars)) && isPossible(chars)) {
            System.out.println("Game not finished");
        } else if (!isPossible(chars) || o_WinsCondition(chars) && x_WinsCondition(chars)) {
            System.out.println("Impossible");
        }
    }

    public static void drawField (char[][] matrix) {
        System.out.println("---------");
        System.out.println("| " + matrix[1][3] + " " + matrix[2][3]
                + " " + matrix[3][3] + " |");
        System.out.println("| " + matrix[1][2] + " " + matrix[2][2]
                + " " + matrix[3][2] + " |");
        System.out.println("| " + matrix[1][1] + " " + matrix[2][1]
                + " " + matrix[3][1] + " |");
        System.out.println("---------");
    }

    public static boolean isEmpty (char[][] matrix, int first, int second) {
        if (matrix[first][second] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
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
