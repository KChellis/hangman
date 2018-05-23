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
                boolean guessing = true;
                Game hangman = new Game();
                System.out.println("Would you like to input your own word? y/n");
                String option = bufferedReader.readLine().toLowerCase();
                if(option.equals("y")){
                    System.out.println("Enter your word:");
                    String userWord = bufferedReader.readLine().toLowerCase();
                    hangman.setAnswer(userWord);
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");
                    System.out.println("---------");

                }else{
                    hangman.setAnswer(hangman.generateWord());
                }

                hangman.setUserPuzzle();

                while(guessing){
                    System.out.println("You have guessed: " + hangman.getGuessedLetters());
                    String puzzle;
                    StringBuilder builder = new StringBuilder(hangman.getUserPuzzle().size());
                    for(Character letter: hangman.getUserPuzzle()){
                        builder.append(letter + " ");
                    }
                    puzzle = builder.toString();
                    System.out.println("Your puzzle is: " + puzzle + " Guess a letter.");
                    String userInput = bufferedReader.readLine().toLowerCase();
                    char guess = userInput.charAt(0);
                    boolean inWord = hangman.checkGuess(guess);
                    if (inWord) {
                        hangman.revealLetters(guess);
                        if(hangman.checkWin()){
                            System.out.println("Congratulations you guessed the word was " + hangman.getAnswer() + "!");
                            guessing = false;
                        }

                    }else {
                        System.out.println("Sorry, '" + guess + "' is not in the word. Try Again");
                    }
                    if(hangman.getWrongGuessCount() == 6){
                        System.out.println("You have run out of turns. The word was " + hangman.getAnswer() + ".");
                        guessing = false;
                    }


                }
                System.out.println("Would you like to play again? y/n");
                String playAgain = bufferedReader.readLine().toLowerCase();
                if(playAgain.equals("n")){
                    playing = false;
                }




            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
