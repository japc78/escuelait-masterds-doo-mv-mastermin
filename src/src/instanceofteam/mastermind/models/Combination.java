package instanceofteam.mastermind.models;

abstract class Combination {
	final int LENGTH = Game.LENGTH_COMBINATION;
	Color[] colors;

	Combination() {
		this.colors = new Color[LENGTH];
	}

	Combination(String combinationLetters) {
		this.colors = new Color[LENGTH];

		for (int i = 0; i < colors.length; i++) {
			colors[i] = Color.valueOf(combinationLetters.charAt(i));
		}
	}

	@Override
	public String toString() {
		String txt = "";
		for (Color color : this.colors) {
			txt = txt.concat(color.toString());
		}
		return txt;
	}
}