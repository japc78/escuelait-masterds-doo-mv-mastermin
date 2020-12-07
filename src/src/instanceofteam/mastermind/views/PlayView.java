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
            console.write("Secret: " + this.game.getSecretCombination());
            console.write(this.game.getCurrentNumAttempts() + " "
                + Message.ATTEMP_CAPTION.toString());

            for (String result : this.game.getAttemptsResult()) {
                String combinationString = result.split(",")[0];
                String blacks = result.split(",")[1];
                String whites = result.split(",")[2];

                console.write(combinationString + Message.RESULT_SEPARATOR +
                    blacks + Message.RESULT_BLACKS +
                    whites + Message.RESULT_WHITES);
            }

            do {
                combination = console.read(Message.COMBINATION_ENTER.toString());
            } while(!isValidCombination(combination));

            this.game.addCombination(combination);

            if (this.game.isWinner()) {
                console.write(Message.WINNER.toString());
            }

        } while (this.game.isMastermind());
    }

    private boolean isValidCombination(String combination) {
        Console console = new Console();
        int length = combination.length();

        if (length != this.game.getLengthCombination()) {
            combination = console.read(Message.COMBINATION_WRONG_LENGTH.toString());
            return false;
        }

        if (!this.game.isValidColors(combination)) {
            combination = console.read(Message.COMBINATION_WRONG_COLOR.toString() + this.game.getValidColors());
            return false;
        }

        if (containRepeats(combination)) {
            combination = console.read(Message.COMBINATION_WRONG_DUPLICATE_COLOR.toString());
            return false;
        }
        return true;
    }

    private boolean containRepeats(String combination) {
        String tmp = "";
        for (char letterColor : combination.toCharArray()) {
            if (tmp.contains(String.valueOf(letterColor))) {
                return true;
            }
            tmp = tmp.concat(String.valueOf(letterColor));
        }
        return false;
    }
}