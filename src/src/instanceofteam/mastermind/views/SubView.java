package instanceofteam.mastermind.views;

import instanceofteam.mastermind.models.Game;

abstract class SubView {
    protected Game game;

    SubView(Game game) {
        this.game = game;
    }
}
