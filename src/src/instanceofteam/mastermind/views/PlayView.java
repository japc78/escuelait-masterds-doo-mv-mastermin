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
            } while(!this.game.isValidCombination(combination));

            this.game.setCombination(combination);

        } while (!this.game.isMastermind());
	}
}