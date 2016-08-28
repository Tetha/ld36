package org.subquark.ld36.goals;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.Gdx;

public class TimeLimitUpdater {
    private final GameState gameState;
    
    public TimeLimitUpdater(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        gameState.timeSpent += deltaTime;
    }
}
