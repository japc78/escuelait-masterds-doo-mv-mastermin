package instanceofteam.mastermind.views;

import instanceofteam.utils.Console;

public class StartView {

    public void interact() {
        Console console = new Console();
        console.write(Message.START_TITLE.toString());
	}
}
