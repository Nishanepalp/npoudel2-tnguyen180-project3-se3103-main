package model.strategyPattern;

import model.NumberGuessGame;

public class HighLow implements PlayStrategy {

    private NumberGuessGame game;

    public HighLow(NumberGuessGame game) {
        this.game = game;
    }

    @Override
    public void play(int guess) {
        game.incAttempts();
        game.setGuess(guess);
        int diff = guess - game.getKey();
        if (diff < 0) {
            game.setProgressMessage("Go Higher!");
        }
        else if (diff == 0) {
            game.setProgressMessage(String.format("You got it! The key was + %d", game.getKey()));
        }
        else {
            game.setProgressMessage("Go Lower!");
        }

    }
    
}
