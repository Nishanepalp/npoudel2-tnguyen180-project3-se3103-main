package model;

import java.util.Random;

import model.strategyPattern.PlayStrategy;
import model.strategyPattern.CloserAway;
import model.strategyPattern.HighLow;

public class NumberGuessGame {

    public static final int MAX_KEY = 100;

    private int key;
    private int guess;
    private boolean showKeyOn;
    private int attempts;
    private GameState state;
    private PlayStrategy strategy;
    public String progressMessage;

    public NumberGuessGame() {
        key = -1;
        guess = -1;
        showKeyOn = false;
        attempts = 0;
        state = GameState.INIT;
        setStrategy(new HighLow(this));
    }

    public void start() {
        key = generateNewKey();
        guess = -1;
        attempts = 0;
        progressMessage = null;
    }

    private int generateNewKey() {
        Random r = new Random();
        int newKey;
        do {
            newKey = r.nextInt( MAX_KEY + 1);
        } while (newKey == key);
        return newKey;
    }

    public void play (int guess) {
        strategy.play(guess);
    }

    public void incAttempts() {
        ++attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public PlayStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy) {
        this.strategy = strategy;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public boolean isShowKeyOn() {
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn) {
        this.showKeyOn = showKeyOn;
    } 

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
    }

    public int getKey() {
        return key;
    }

    public String getProgressMessage() {
        return progressMessage;
    }

    public void setProgressMessage(String progressMessage) {
        this.progressMessage = progressMessage;
    }
    
    @Override
    public String toString() {
        return String.format (
            "key(%d) guess(%d) attempts(%d)", key, guess, attempts
        );
    }
}   
