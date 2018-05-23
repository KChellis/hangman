package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private String[] wordList = {"zebra"};
    private List<Character> userGuess = new ArrayList<Character>();
    private List<Character> guessedLetters = new ArrayList<Character>();
    private String answer;

    public String[] getWordList() {
        return wordList;
    }

    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public String generateWord() {
        Random myRandomGenerator = new Random();
        int index = myRandomGenerator.nextInt(1);
        return wordList[index];
    }

    public void setAnswer(String word) {
        this.answer = word;
    }
    public String getAnswer() {
        return answer;
    }

    public List<Character> setGuess() {
        char[] answerLetters = answer.toCharArray();
        for (int i =0; i < answerLetters.length; i++){
            userGuess.add('_');
        }

        return userGuess;
    }



    public List<Character> getGuess(){
        return userGuess;
    }

    public boolean checkGuess(char letterGuess) {
        guessedLetters.add(letterGuess);
        for( char letter : this.answer.toCharArray()){
            if(letter == letterGuess){
                return true;
            }
        }
        return false;
    }

    public List<Character> revealLetters(char letterGuess){
        char[] answerLetters = answer.toCharArray();
        List<Integer> indices = new ArrayList<Integer>();
        for (int i =0; i< answerLetters.length; i++){
            if(answerLetters[i] == letterGuess){
                indices.add(i);
            }
        }
        for (int index: indices){
            userGuess.set(index, letterGuess);
        }

        return userGuess;
    }

    public boolean checkWin() {
        String guessString;
        StringBuilder builder = new StringBuilder(userGuess.size());
        for(Character letter: userGuess){
            builder.append(letter);
        }
        guessString = builder.toString();
        if (guessString.equals(answer)){
            return true;
        } else {
            return false;
        }

    }

}
