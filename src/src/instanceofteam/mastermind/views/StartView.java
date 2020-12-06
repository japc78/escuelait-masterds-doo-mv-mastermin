package instanceofteam.mastermind.views;

import instanceofteam.mastermind.models.Game;
import instanceofteam.utils.Console;

public class StartView extends SubView{
    public StartView(Game game) {
        super(game);
    }

	public void interact() {
        Console console = new Console();
        console.write(Message.START_TITLE.toString());
	}
}
