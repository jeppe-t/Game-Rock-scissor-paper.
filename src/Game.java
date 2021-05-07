import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private int humanWinCounter;
    private int computerWinCounter;

    HumanPlayer player = new HumanPlayer("Player");
    ComputerPlayer computer = new ComputerPlayer("Computer");


    public void run(){
        System.out.println("Welcome my friend to this awsome game of:\n!<<<Rock - scissors - Paper>>>!");
        menu();
    }


    public void menu(){

        Scanner sc2 = new Scanner(System.in);
        boolean run = true;

            while (run == true) {

                System.out.println("\nMenu:\n1. Start game\n2. Read Rules\n3. Show score\n4. Quit");

                //Fejlhåndtering, hvis man ikke indtaster int.
                while(!sc2.hasNextInt()) {
                    System.out.println("Enter a number please");
                    sc2.next();
                }
                int menuChoice = sc2.nextInt();
                sc2.nextLine();

                switch (menuChoice) {
                    case 1:
                        System.out.println("\nLet the game begin!!!");
                        playGame();
                        break;
                    case 2:
                        rules();
                        break;
                    case 3:
                        checkScore();
                        break;
                    case 4:
                        System.out.println("Thanks for playing - Goodbye!!!");
                        run = false;
                    default:
                        System.out.println("PLease enter a number from the menu!");
                }
            }

    }


    public void checkScore(){
        System.out.println("Current score:\nPlayer: " + humanWinCounter + "\nComputer: " + computerWinCounter);
        }


    public void rules(){
        System.out.println("\nRules:\n1. Player start by choosing between Rock, Scissors or paper\n" +
                "2. Computer then takes turn and chooses between Rock, Scissors or paper\n-Rock beats scissors" +
                "\n-Scissors beats paper" + "\n-Paper beats rock\n-Same choice is a draw\n" +
                "3. The game is best of 3, so the first one to win twice is the winner" );
    }


    public void playGame(){

        // Reset counter after and before each match.
        humanWinCounter = 0;
        computerWinCounter = 0;

        do {
            System.out.println("Enter your choice?\n1. Rock\n2. Scissors\n3. Paper");
            String playerResult = player.takeTurn();
            String computerResult = computer.takeTurn();
            System.out.println("Computer Choose: " + computerResult + "\n");
            resultOfGame(playerResult, computerResult);
            //humanWinCounter++;

            } while(computerWinCounter != 2 && humanWinCounter != 2 ); // When you wins twice(2) you won the match.
            endGameMessage();
    }

    public void resultOfGame(String playerResult, String computerResult){

        //Player chooses Rock defined here.
        if (playerResult.equals("Rock") && computerResult.equals("Rock")) {
            System.out.println(("its a draw - play again!\n"));
        } else if (playerResult.equals("Rock") && computerResult.equals("Scissors")) {
            System.out.println(("You won Man!!!\n"));
            humanWinCounter++;
        } else if (playerResult.equals("Rock") && computerResult.equals("Paper")) {
            System.out.println(("Ohh no - You lost!!!\n"));
            computerWinCounter++;
        }

        //Player chooses Scissors defined here.
        else if (playerResult.equals("Scissors") && computerResult.equals("Rock")) {
            System.out.println(("Ohh no - You lost!!!\n"));
            computerWinCounter++;
        } else if (playerResult.equals("Scissors") && computerResult.equals("Scissors")) {
            System.out.println(("its a draw - play again!\n"));
        } else if (playerResult.equals("Scissors") && computerResult.equals("Paper")) {
            System.out.println(("You won Man!!!\n"));
            humanWinCounter++;

        }

        //Player chooses Paper defined here.
        else if (playerResult.equals("Paper") && computerResult.equals("Rock")) {
            System.out.println(("You won Man!!!\n"));
            humanWinCounter++;
        } else if (playerResult.equals("Paper") && computerResult.equals("Scissors")) {
            System.out.println(("Ohh no - You lost!!!\n"));
            computerWinCounter++;
        } else if (playerResult.equals("Paper") && computerResult.equals("Paper")) {
            System.out.println(("its a draw - play again!\n"));

        }
    }


    public void endGameMessage(){
        if(humanWinCounter == 2){
            System.out.println("Congrats - You won the match");
        } else{
            System.out.println("Damn - You lost the match");
        }
    }

}
