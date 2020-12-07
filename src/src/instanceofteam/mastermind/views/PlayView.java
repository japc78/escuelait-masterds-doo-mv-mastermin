package instanceofteam.mastermind.views;

import instanceofteam.mastermind.models.Game;
import instanceofteam.utils.Console;

public class PlayView extends SubView{
    AttemptView attemptView;

    PlayView(Game game) {
        super(game);
        attemptView = new AttemptView(this.game);
    }

    public void interact() {
        Console console = new Console();
        do {
            console.write("Secret: " + this.game.getSecretCombination());
            attemptView.interact();
            if (this.game.isWinner()) {
                console.write(Message.WINNER.toString());
            }

        } while (this.game.isMastermind());
    }
}