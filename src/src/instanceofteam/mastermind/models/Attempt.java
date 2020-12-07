package instanceofteam.mastermind.models;

class Attempt {
	private ProposedCombination proposedCombination;
	private Result result;

	public Attempt(ProposedCombination proposedCombination, SecretCombination secretCombination) {
		this.proposedCombination = proposedCombination;
		this.result = secretCombination.evaluateCombination(this.proposedCombination);
	}

	public boolean isWinner() {
		if (this.result.getBlacks() == ProposedCombination.LENGTH) {
			return true;
		}
		return false;
	}

	public int getResultBlacks() {
		return this.result.getBlacks();
	}

	public int getResultWhites() {
		return this.result.getWhites();
	}

	@Override
	public String toString() {
		return this.proposedCombination.toString();
	}
}