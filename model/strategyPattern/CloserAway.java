package model.strategyPattern;

import model.NumberGuessGame;

public class CloserAway implements PlayStrategy {
    
    private NumberGuessGame game;

    public CloserAway(NumberGuessGame game) {
        this.game = game;
    }

    @Override
    public void play(int guess) {
        game.incAttempts();
        int prevDiff = Math.abs(game.getKey() - game.getGuess());
        int newDiff = Math.abs(game.getKey() - guess);
        game.setGuess(guess);
        if (newDiff - prevDiff < 0) {
            game.setProgressMessage("Getting closer");
        }
        else {
            game.setProgressMessage("Not getting closer");
        }
    }




}
