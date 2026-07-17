import java.util.Scanner;
public class RPSLS {
    enum Choice {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }
    boolean winner(Choice a, Choice b) {
        if (a == b) {
            return false; // It's a tie
        }
        switch (a) {
            case ROCK:
                return (b == Choice.SCISSORS || b == Choice.LIZARD) ? true : false;
            case PAPER:
                return (b == Choice.ROCK || b == Choice.SPOCK) ? true : false;
            case SCISSORS:
                return (b == Choice.PAPER || b == Choice.LIZARD) ? true : false;
            case LIZARD:
                return (b == Choice.SPOCK || b == Choice.PAPER) ? true : false;
            case SPOCK:
                return (b == Choice.SCISSORS || b == Choice.ROCK) ? true : false;
            default:
                return false;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice (Rock, Paper, Scissors, Lizard, Spock):");
        String userInput = sc.nextLine().toUpperCase();
        Choice userChoice = Choice.valueOf(userInput);  
        System.out.println("You chose: " + userChoice);
        Choice[] choices = Choice.values();
        Choice computerChoice = choices[(int) (Math.random() * choices.length)];
        System.out.println("Computer chose: " + computerChoice);
        RPSLS game = new RPSLS();
        boolean result = game.winner(userChoice, computerChoice);
        if (result) {
            System.out.println("You win!");
        } else if(result == false && userChoice != computerChoice) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a tie!");
        }
        sc.close(); 
    }
}
