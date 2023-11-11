package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.strategyPattern.CloserAway;
import model.strategyPattern.HighLow;
import view.AppWindow;

public class StrategySelectionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case AppWindow.highLowAction:
                App.game.setStrategy(new HighLow(App.game));
                break;
            case AppWindow.closerAwayAction:
                App.game.setStrategy(new CloserAway(App.game));
                break;
        }
    }
    
}