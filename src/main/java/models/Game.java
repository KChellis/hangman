package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private String[] wordList = {"zebra"};
    private String userGuess;
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

    public String setAnswer(String word) {
        this.answer = word;
        return answer;
    }

    public String setGuess() {
        char[] answerLetters = answer.toCharArray();
        List<Character> letters = new ArrayList<Character>();
        for (int i =0; i < answerLetters.length; i++){
            letters.add('_');
        }
        StringBuilder builder = new StringBuilder(letters.size());
        for(Character letter : letters){
            builder.append(letter);
        }
        userGuess = builder.toString();
        return userGuess;
    }

    public String getAnswer() {
        return answer;
    }

    public String getGuess(){
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

    public String revealLetters(char letterGuess){
        char[] guessLetters = userGuess.toCharArray();
        char[] answerLetters = answer.toCharArray();
        List<Integer> indices = new ArrayList<Integer>();
        for (int i =0; i< answerLetters.length; i++){
            if(answerLetters[i] == letterGuess){
                indices.add(i);
            }
        }
        for (int index: indices){
            guessLetters[index]= letterGuess;
        }
        userGuess = guessLetters.toString();
        StringBuilder builder = new StringBuilder(guessLetters.length);
        for(Character letter : guessLetters){
            builder.append(letter);
        }
        userGuess = builder.toString();
        return userGuess;
    }

    public boolean checkWin() {
        if (userGuess.equals(answer)){
            return true;
        } else {
            return false;
        }

    }

}
