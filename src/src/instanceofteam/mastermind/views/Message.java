package instanceofteam.mastermind.views;

enum Message {
    START_TITLE("----- Mastermind --------"),
    ATTEMP_CAPTION("attemp(s):"),
    COMBINATION_ENTER("Propose a combination: "),
    COMBINATION_WRONG_COLOR("Wrong colors they must be: "),
    COMBINATION_WRONG_LENGTH("Wrong proposed combination length."),
    COMBINATION_WRONG_DUPLICATE_COLOR("Wrong proposed, can not repeat color."),
    RESULT_BLACKS(" blacks and "),
    RESULT_WHITES(" whites"),
    RESULT_SEPARATOR(" --> "),
    WINNER("You've won!!!"),
    LOSER("You've lost"),
    RESUMEN("Resume? (y/n)");

    private String message;

    private Message(String message) {
        this.message=message;
    }

    @Override
	public String toString() {
		return this.message;
    }
}
