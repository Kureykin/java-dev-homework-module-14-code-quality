package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    private static final char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    static boolean boxAvailable = true;

    private static void showMap() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private static boolean isThatWin(char chr) {
        return  (box[0]== chr && box[1]== chr && box[2]== chr) || (box[3]== chr && box[4]== chr && box[5]== chr) || (box[6]== chr && box[7]== chr && box[8]== chr) ||
                (box[0]== chr && box[3]== chr && box[6]== chr) || (box[1]== chr && box[4]== chr && box[7]== chr) || (box[2]== chr && box[5]== chr && box[8]== chr) ||
                (box[0]== chr && box[4]== chr && box[8]== chr) || (box[2]== chr && box[4]== chr && box[6]== chr);
    }
    private static boolean whoWon() {
        showMap();

        if(isThatWin('X')) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return false;
        }
        if (isThatWin('O')) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return false;
        }
        if (!boxAvailable) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return false;
        }
        return true;
    }

    private static boolean setCharInBox(int cord, char chr) {
        if (box[cord - 1] == ' ') {
            box[cord - 1] = chr;
            return true;
        }
        return false;
    }
    private static boolean setXInBox(byte cord) {
        if (cord > 0 && cord < 10) {
            return setCharInBox(cord, 'X');
        }
        System.out.println("Invalid input. Enter again.");
        return false;
    }
    private static void setOInBox() {
        boolean end = false;
        while (!end) {
            end = setCharInBox((byte) (Math.random() * 9 + 1), 'O');
        }
    }

    private static void isItDraw() {
        boxAvailable = false;
        for(byte i = 0; i < 9; i++) {
            if(box[i] == ' ') {
                boxAvailable = true;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter box number to select. Enjoy!\n");
        showMap();

        Arrays.fill(box, ' ');

        while (whoWon()) {
            for (boolean end = false;!end;) {
                end = setXInBox(scan.nextByte());
            }
            isItDraw();
            if (boxAvailable) {
                setOInBox();
            }
        }
        scan.close();
    }
}
