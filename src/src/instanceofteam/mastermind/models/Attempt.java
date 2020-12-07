package instanceofteam.mastermind.models;

class Attempt {
	private ProposedCombination proposedCombination;
	private Result result;

	Attempt(ProposedCombination proposedCombination, SecretCombination secretCombination) {
		this.proposedCombination = proposedCombination;
		this.result = secretCombination.evaluateCombination(this.proposedCombination);
	}

	boolean isWinner() {
		if (this.result.getBlacks() == Game.LENGTH_COMBINATION) {
			return true;
		}
		return false;
	}

	Result getResult() {
		return this.result;
	}

	@Override
	public String toString() {
		return this.proposedCombination.toString();
	}
}