package rockpaperscissorshw;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsHW {

    private static int playerChoice;
    private static int computerChoice;
    private static int bomb = 3;

    public static void GetPlayerChoice() {

        boolean check = true;

        while (check == true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please pick rock, paper, scissors or bomb: ");
                String choice = input.next();

                switch (choice) {
                    case ("rock"):
                        System.out.println("You have chosen \'rock\'");
                        playerChoice = 1;
                        check = false;
                        break;
                    case ("paper"):
                        System.out.println("You have chosen \'paper\'");
                        playerChoice = 2;
                        check = false;
                        break;
                    case ("scissors"):
                        System.out.println("You have chosen \'scissors\'");
                        playerChoice = 3;
                        check = false;
                        break;
                    case ("bomb"):
                        if (bomb == 0) {
                            System.out.println("You cannot pick this anymore! Try something else!");
                        } else {
                            System.out.println("You have chosen \'bomb\'");
                            playerChoice = 4;
                            bomb--;
                            check = false;
                            break;
                        }
                    default:
                        System.out.println("ERROR: EXCEPTION OCCURED");
                }
            } catch (Exception e) {
                System.out.println("ERROR: EXCEPTION OCURRED. \n" + e);
            }
        }

    }

    public static void GetComputerChoice() {
        Random random = new Random();

        computerChoice = random.nextInt((3 - 1) + 1) + 1;
        switch (computerChoice) {
            case (1):
                System.out.println("The computer has chosen rock!\n");
                break;
            case (2):
                System.out.println("The computer has chosen paper!\n");
                break;
            case (3):
                System.out.println("The computer has chosen scisssors!\n");
                break;
            default:
                System.out.println("ERROR: EXCEPTION OCCURRED.");
        }
    }

    public static boolean CheckForWinner() {
        if (playerChoice == computerChoice) {
            System.out.println("You have tied! Nobody wins!\n");
            return false;
        } else if (playerChoice ==4){
            System.out.println("You have won against the computer! Congrats!\n");
            return true;
        }else if (playerChoice == 1 && computerChoice == 2) {
            System.out.println("The computer has won! Better luck next time!\n");
            return false;
        } else if (playerChoice == 2 && computerChoice == 3) {
            System.out.println("The computer has won! Better luck next time!\n");
            return false;
        } else if (playerChoice == 3 && computerChoice == 1) {
            System.out.println("he computer has won! Better luck next time!\n");
            return false;
        } else {
            System.out.println("You have won against the computer! Congrats!\n");
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Rock, Paper, Scissors with a twist!");
        System.out.println("You have the ability to use a bomb that is an instant win, but use it wisely, you cna only use it three times.\n");

        boolean check = true;
        int points = 0;

        while (check == true) {
            GetPlayerChoice();
            GetComputerChoice();
            CheckForWinner();
            if (CheckForWinner() == true) {
                points++;
            }
            System.out.println("You currently have " + points + " points!");
            System.out.println("Would you like to play again? yes or no: ");
            String answer = input.next();
            if (answer.equals("no")) {
                check = false;
            } else {
                check = true;
            }
        }

    }

}
