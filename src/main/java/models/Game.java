package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private String[] wordList = {"zebra", "tarantula", "vehicle", "overtime", "fortnight", "emergency", "highlight", "resume", "guess", "appreciation", "piano", "symphony", "wishing", "queen", "passive", "collar", "spectacular", "forest", "button", "mangle"};
    private List<Character> userPuzzle = new ArrayList<Character>();
    private List<Character> guessedLetters = new ArrayList<Character>();
    private String answer;
    private int wrongGuessCount;


    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public String generateWord() {
        Random myRandomGenerator = new Random();
        int index = myRandomGenerator.nextInt(20);
        return wordList[index];
    }

    public void setAnswer(String word) {
        this.answer = word;
    }
    public String getAnswer() {
        return answer;
    }

    public void setUserPuzzle() {
        char[] answerLetters = answer.toCharArray();
        for (int i =0; i < answerLetters.length; i++){
            userPuzzle.add('_');
        }
    }

    public List<Character> getUserPuzzle(){
        return userPuzzle;
    }

    public boolean checkGuess(char letterGuess) {
        guessedLetters.add(letterGuess);
        for( char letter : this.answer.toCharArray()){
            if(letter == letterGuess){
                return true;
            }
        }
        wrongGuessCount += 1;
        return false;
    }

    public void revealLetters(char letterGuess){
        char[] answerLetters = answer.toCharArray();
        List<Integer> indices = new ArrayList<Integer>();
        for (int i =0; i< answerLetters.length; i++){
            if(answerLetters[i] == letterGuess){
                indices.add(i);
            }
        }
        for (int index: indices){
            userPuzzle.set(index, letterGuess);
        }
    }

    public boolean checkWin() {
        String guessString;
        StringBuilder builder = new StringBuilder(userPuzzle.size());
        for(Character letter: userPuzzle){
            builder.append(letter);
        }
        guessString = builder.toString();
        if (guessString.equals(answer)){
            return true;
        } else {
            return false;
        }

    }

    public int getWrongGuessCount() {
        return wrongGuessCount;
    }

}
