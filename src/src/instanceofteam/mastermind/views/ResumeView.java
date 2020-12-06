package instanceofteam.mastermind.views;

import instanceofteam.mastermind.models.Game;
import instanceofteam.utils.Console;

public class ResumeView extends SubView {
	ResumeView(Game game) {
		super(game);
	}

	public boolean interact() {
		Console console = new Console();
		String response;
		do {
			response = console.read(Message.RESUMEN.toString());
		} while(!isYesOrNot(response));

		if (response.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}

	private boolean isYesOrNot(String s){
		if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n")) {
			return true;
		}
		return false;
	}
}