package instanceofteam.mastermind.models;

import java.util.ArrayList;

public class Game {
	private ArrayList<Attempt> attempts;
    private SecretCombination secretCombination;
    private final int NUM_ATTEMPTS = 10;
    public static final int LENGTH_COMBINATION = 4;


    public Game() {
        this.reset();
    }

    public void reset() {
        this.attempts = new ArrayList<Attempt>();
        this.secretCombination = new SecretCombination();
    }

	public boolean isMastermind() {
        if ((attempts.size() <= NUM_ATTEMPTS) && !isWinner()) {
            return true;
        }
		return false;
    }

    public boolean isWinner() {
        return attempts.get(attempts.size()-1).isWinner();
    }

    public void addCombination(String combinationLetters) {
        Attempt attempt = new Attempt(new ProposedCombination(combinationLetters), secretCombination);
        this.attempts.add(attempt);
    }

    public boolean isValidColors(String combinationLetters) {
        for (char colorLetter : combinationLetters.toCharArray()) {
            if(!Color.exist(colorLetter)) {
                return false;
            }
        }
        return true;
    }

    public String getValidColors() {
        return Color.getColors();
    }

    public int getCurrentNumAttempts() {
        return attempts.size();
    }

    public ArrayList<String> getAttemptsResult() {
        ArrayList<String> results = new ArrayList<>();
        for (Attempt attempt : attempts) {
            results.add(attempt.toString() +
                "," + attempt.getResult().getBlacks() +
                "," + attempt.getResult().getWhites());
        }
        return results;
    }

    public String getSecretCombination() {
        return this.secretCombination.toString();
    }
}
