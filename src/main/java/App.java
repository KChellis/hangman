import models.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {

        System.out.println("Welcome to Hangman!");

        boolean playing = true;

        while(playing){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));



            try {
                Game hangman = new Game();
                hangman.setAnswer(hangman.generateWord());
                hangman.setGuess();
                System.out.println("Your puzzle is: " + hangman.getGuess() + " Guess a letter.");

                String guess = bufferedReader.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
