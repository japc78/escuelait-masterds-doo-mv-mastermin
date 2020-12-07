package instanceofteam.mastermind.models;

class SecretCombination extends Combination {
	public SecretCombination() {
		super();
		String randomCombination = this.getRandomCombination();

		for (int i = 0; i < LENGTH; i++) {
			colors[i] = Color.valueOf(randomCombination.charAt(i));
		}
	}

	private String getRandomCombination() {
		String combination = "";
		int index;

		do {
			index = randomIndex(Color.values().length);
			if (combination.indexOf(Color.values()[index].toString()) < 0) {
				combination = combination.concat(Color.values()[index].toString());
			}
		} while (combination.length() <= LENGTH);

		return combination;
	}

	public Result evaluateCombination(ProposedCombination proposedCombination) {
		String combination = proposedCombination.toString();
		int blacks = 0;
		int whites = 0;

		for (int i = 0; i < LENGTH; i++) {
			if (combination.indexOf(this.colors[i].toString()) == i) {
				blacks ++;
			} else if (combination.indexOf(this.colors[i].toString()) > 0) {
				whites ++;
			}
		}
        return new Result(whites, blacks);
	}

	private int randomIndex(int arrayLength) {
		return (int)(Math.random() * arrayLength);
	}
}
