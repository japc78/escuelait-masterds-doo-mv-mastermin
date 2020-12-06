package instanceofteam.mastermind.models;

import java.util.ArrayList;

public class Game {
	private ArrayList<Attempt> attempts;
    private SecretCombination secretCombination;
    private final int NUM_ATTEMPTS = 10;

    public Game() {
        this.attempts = new ArrayList<Attempt>();
        this.secretCombination = new SecretCombination();
    }

	public boolean isMastermind() {
        if (attempts.size() <= NUM_ATTEMPTS) {
            return true;
        }
		return false;
    }

    public void addCombination(String combination) {
        this.attempts.add(new Attempt(new ProposedCombination(combination), secretCombination));
    }

    public boolean isValidColors(String combination) {
        for (String colorLetter : combination.split(combination)) {
            if(!Color.exist(colorLetter.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public boolean containRepeats(String combination) {
        for (String letterColor : combination.split(combination)) {
            if (combination.indexOf(letterColor) > 1) {
                return false;
            }
        }
        return true;
    }

    public String getValidColors() {
        return Color.getColors();
    }

    public int getNumAttempts() {
        return NUM_ATTEMPTS;
    }
}
