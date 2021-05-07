import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer implements Player {

    private String name;

    public ComputerPlayer(String name){
        this.name = name;
    }

    public String takeTurn() {
        Random random = new Random();
        String computerChoices[] = new String[]{"Rock","Scissors", "Paper"};
        String result = computerChoices[random.nextInt(computerChoices.length)];
        return result;

    }



}
