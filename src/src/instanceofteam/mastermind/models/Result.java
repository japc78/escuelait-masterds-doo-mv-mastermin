package instanceofteam.mastermind.models;

public class Result {

	private int blacks;
	private int whites;

	Result(int whites, int blacks) {
		this.blacks = blacks;
        this.whites = whites;
	}

	int getWhites() {
		return whites;
	}

	int getBlacks() {
		return blacks;
	}
}
