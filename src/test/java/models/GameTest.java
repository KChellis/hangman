package models;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void newGame_instantiatesCorrectly() throws Exception {
        Game testGame = new Game();
        assertEquals(true, testGame instanceof Game);
    }

    @Test
    public void newGame_getsWordList_Array() {
        Game testGame = new Game();
        assertEquals(true, testGame.getWordList() instanceof String[]);
    }
    @Test
    public void newGame_getsGuessedLetters_Array() {
        Game testGame = new Game();
        assertEquals(true, testGame.getGuessedLetters() instanceof ArrayList);
    }

    @Test
    public void generateWord_randomlyChoosesWord_string() {
        Game testGame = new Game();
        assertEquals(true, testGame.generateWord() instanceof String);
    }

    @Test
    public void newGame_setsAnswer_zebra() {
        Game testGame = new Game();
        assertEquals(true, testGame.setAnswer("zebra") instanceof String);
    }

    @Test
    public void newGame_getAnswer_zebra() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals("zebra", testGame.getAnswer());
    }

    @Test
    public void setsGuess_createsEmptyGuessString_string() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals("_____", testGame.setGuess());
    }


    @Test
    public void newGame_getGuess_String() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setGuess();
        assertEquals("_____", testGame.getGuess());
    }

    @Test
    public void newGame_checksGuess_addsToCharacterGuessedList() {
        Game testGame = new Game();
        ArrayList<Character> expected = new ArrayList<Character>();
        expected.add('z');
        testGame.checkGuess('z');
        assertEquals(expected, testGame.getGuessedLetters());
    }

    @Test
    public void checksGuess_checksIfGuessInAnswer_true() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals(true, testGame.checkGuess('z'));
    }
    @Test
    public void checksGuess_checksIfGuessNotInAnswer_false() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals(false, testGame.checkGuess('g'));
    }

    @Test
    public void revealLetters_revealsLettersInUserGuess_string() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setGuess();
        assertEquals("z____", testGame.revealLetters('z'));

    }

    @Test
    public void checkWin_returnsFalseIfWrongGuess_false() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setGuess();
        assertEquals(false, testGame.checkWin());
    }

    @Test
    public void checkWin_returnsTrueIfCorrectGuess_true() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setGuess();
        testGame.revealLetters('z');
        testGame.revealLetters('e');
        testGame.revealLetters('b');
        testGame.revealLetters('r');
        testGame.revealLetters('a');
        assertEquals(true, testGame.checkWin());
    }
}