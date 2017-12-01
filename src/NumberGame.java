/**
 * Created by Nate on 2/20/17.
 */

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    private int max;
    private Scanner input = new Scanner(System.in);
    private final int QUIT = -1;

    private boolean isHigher(final int target, final int guess){return guess > target;}

    private boolean isLower(final int target, final int guess){return guess < target;}

    public boolean hasQuit(){return max == QUIT;}

    public NumberGame() {}

    public void Prep() {
        System.out.println();
        System.out.println("Guessing game: To play choose the max number you want to have for the game. If you " +
                "give up up enter 0 and if you want to quit enter -1");
        System.out.print("Enter the max: ");
        max = input.nextInt();
    }

    public void Run() {
        final int GIVE_UP = 0;
        int guessCount = 0;

        Random randomNumber = new Random();
        int target = randomNumber.nextInt(max) + 1;

        System.out.println("Enter first guess");
        int guess = input.nextInt();

        while (guess != target && guess != GIVE_UP && guess != QUIT) {
            if(isHigher(target, guess))
                System.out.println("Guess number " + ++guessCount + " is to high, try again");
            else if(isLower(target, guess))
                System.out.println("Guess number " + ++guessCount + " is to low, try again");
            System.out.println("Try again: ");
            guess = input.nextInt();
        }
        if (guess == target){
            System.out.println("CONGRATS YOU GOT IT and in only " + guessCount + " tries");
            Prep();
            if(!hasQuit())
                Run();
        } else if (guess == GIVE_UP){
            System.out.println("The number you are looking for is " + target);
            Prep();
            if(!hasQuit())
                Run();
        }


    }


}

