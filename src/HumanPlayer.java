import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private String rock = "Rock";
    private String scissors = "Scissors";
    private String paper = "Paper";
    private String name;

    public HumanPlayer(String name){
        this.name = name;
    }


    public String takeTurn(){

        Scanner sc1 = new Scanner(System.in);
        int playerChoose;

        //Fejlhåndtering, hvis man ikke indtaster int.
        while(!sc1.hasNextInt()) {
            System.out.println("Enter a number please");
            sc1.next();
        }
        playerChoose = sc1.nextInt();
        sc1.nextLine();

            switch (playerChoose) {
                case 1:
                    System.out.println("Your choose: " + rock);
                    return rock;
                case 2:
                    System.out.println("Your choose: " + scissors);
                    return scissors;
                case 3:
                    System.out.println("Your choose: " + paper);
                    return paper;
                default:
                    System.out.println("Please choose correctly.. Try again!");

            }
        return "";
    }

}
