package instanceofteam.mastermind.models;

abstract class Combination {
	public static final int LENGTH = 4;
	Color[] colors;

	Combination() {
		this.colors = new Color[LENGTH];
	}

	Combination(String combination) {
		this.colors = new Color[LENGTH];

		for (int i = 0; i < colors.length; i++) {
			colors[i] = Color.getColorByChar(combination.charAt(i));
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