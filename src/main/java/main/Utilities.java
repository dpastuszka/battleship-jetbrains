package main;

import main.board.Row;

import java.io.IOException;
import java.util.Scanner;

public class Utilities {
    static Scanner input = new Scanner(System.in);

    public static int[][] parseShipPlacementCoordinates(int shipLength) {
        boolean gotRightCoordinates = false;
        int[][]  coordinates = new int[2][2];

        try {
        while (!gotRightCoordinates) {
            String inputString = input.nextLine().trim().toUpperCase();
            String[] split = inputString.split("\\s+");
            int pointAX = Row.valueOf(split[0].substring(0, 1)).getRowNumber();
            int pointAY = Integer.parseInt(split[0].substring(1)) - 1;
            int pointBX = Row.valueOf(split[1].substring(0, 1)).getRowNumber();
            int pointBY = Integer.parseInt(split[1].substring(1)) - 1;

            if (pointAX == pointBX) {
                int startY = Math.min(pointAY, pointBY);
                int endY = Math.max(pointAY, pointBY);
                int length = endY - startY;
                if (shipLength == length + 1) {
                    coordinates[0][0] = pointAX;
                    coordinates[0][1] = startY;
                    coordinates[1][0] = pointBX;
                    coordinates[1][1] = endY;
                    gotRightCoordinates = true;
                }
                else {
                    System.out.println("Error! Wrong ship length, try again:");
                }
            }
            else if (pointAY == pointBY) {
                int startX = Math.min(pointAX, pointBX);
                int endX = Math.max(pointAX, pointBX);
                int length = endX - startX;
                if (shipLength == length + 1) {
                    coordinates[0][0] = startX;
                    coordinates[0][1] = pointAY;
                    coordinates[1][0] = endX;
                    coordinates[1][1] = pointBY;
                    gotRightCoordinates = true;
                }
                else {
                    System.out.println("Error! Wrong ship length, try again:");
                }
            }
            else {
                System.out.println("Error! Ship have to be vertical or horizontal");
            }

        }
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Incorrect coordinates, try again:");
        }

        return coordinates;
    }

    public static int[][] parseShootCoordinates() {
        int[][] coordinates = new int[1][2];
        boolean gotRightCoordinates = false;

        while(!gotRightCoordinates) {
            String userInput = input.nextLine();
            char row = userInput.charAt(0);
            int column = Integer.parseInt(userInput.substring(1)) - 1;

            if (row >= 'A' && row <= 'J' && column >= 0 && column <= 9) {
                coordinates[0][0] = Row.valueOf(String.valueOf(row)).getRowNumber();
                coordinates[0][1] = column;
                gotRightCoordinates = true;
            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }

        return coordinates;
    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player\n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
