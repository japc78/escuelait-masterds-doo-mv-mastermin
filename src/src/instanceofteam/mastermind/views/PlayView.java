package instanceofteam.mastermind.views;

import instanceofteam.mastermind.models.Game;
import instanceofteam.utils.Console;

public class PlayView extends SubView{
	PlayView(Game game) {
        super(game);
    }

    public void interact() {
        Console console = new Console();
        String combination;
        do {
            console.write(Message.ATTEMP_CAPTION.toString());

            do {
                combination = console.read(Message.COMBINATION_ENTER.toString());
            } while(!isValidCombination(combination));

            this.game.addCombination(combination);

        } while (!this.game.isMastermind());
    }

    private boolean isValidCombination(String combination) {
        Console console = new Console();
        int length = combination.length();

        if (length != this.game.getNumAttempts()) {
            combination = console.read(Message.COMBINATION_WRONG_LENGTH.toString());
            return false;
        }

        if (!this.game.isValidColors(combination)) {
            combination = console.read(Message.COMBINATION_WRONG_COLOR.toString() + this.game.getValidColors());
            return false;
        }

        if (this.game.containRepeats(combination)) {
            combination = console.read(Message.COMBINATION_WRONG_DUPLICATE_COLOR.toString());
            return false;
        }
        return true;
    }
}