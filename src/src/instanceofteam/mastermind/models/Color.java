package instanceofteam.mastermind.models;

import java.util.Arrays;
import java.util.List;

enum Color {
	RED('r'),
	GREEN('g'),
	BLUE('b'),
	YELLOW('y'),
	ORANGE('o'),
	PINK('p');

	private final char colorLetter;

	private Color(char colorLetter) {
		this.colorLetter = colorLetter;
	}

	static boolean exist(char colorLetter) {
		List<Color> colors = Arrays.asList(Color.values());

		if (colors.contains(valueOf(colorLetter))) {
			return true;
		}
		return false;
	}

	static Color valueOf(char colorLetter) {
		for (Color color: Color.values()) {
			if (color.colorLetter == colorLetter) {
				return color;
			}
		}
		return null;
	}


	static String getColors() {
		String colors = "";
		for (Color color : Color.values()) {
			colors = colors.concat(color.toString());
		}
		return colors;
	}

	@Override
	public String toString() {
		return String.valueOf(this.colorLetter);
	}
}