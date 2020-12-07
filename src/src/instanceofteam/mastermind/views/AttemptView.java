package instanceofteam.mastermind.views;

import instanceofteam.mastermind.models.Game;
import instanceofteam.utils.Console;

public class AttemptView extends SubView {
    AttemptView(Game game) {
        super(game);
    }

    public void interact() {
        Console console = new Console();
        String combinationLetters;

        console.write(this.game.getCurrentNumAttempts() + " "
        + Message.ATTEMP_CAPTION.toString());

        for (String result : this.game.getAttemptsResult()) {
            String combination = result.split(",")[0];
            String blacks = result.split(",")[1];
            String whites = result.split(",")[2];

            console.write(combination + Message.RESULT_SEPARATOR +
                blacks + Message.RESULT_BLACKS +
                whites + Message.RESULT_WHITES);
        }

        do {
            combinationLetters = console.read(Message.COMBINATION_ENTER.toString());
        } while(!isValidCombination(combinationLetters));

        this.game.addCombination(combinationLetters);
    }

    private boolean isValidCombination(String combinationLetters) {
        Console console = new Console();
        int length = combinationLetters.length();

        if (length != Game.LENGTH_COMBINATION) {
            combinationLetters = console.read(Message.COMBINATION_WRONG_LENGTH.toString());
            return false;
        }

        if (!this.game.isValidColors(combinationLetters)) {
            combinationLetters = console.read(Message.COMBINATION_WRONG_COLOR.toString() + this.game.getValidColors());
            return false;
        }

        if (containRepeats(combinationLetters)) {
            combinationLetters = console.read(Message.COMBINATION_WRONG_DUPLICATE_COLOR.toString());
            return false;
        }
        return true;
    }

    private boolean containRepeats(String combinationLetters) {
        String tmp = "";
        for (char letterColor : combinationLetters.toCharArray()) {
            if (tmp.contains(String.valueOf(letterColor))) {
                return true;
            }
            tmp = tmp.concat(String.valueOf(letterColor));
        }
        return false;
    }

}