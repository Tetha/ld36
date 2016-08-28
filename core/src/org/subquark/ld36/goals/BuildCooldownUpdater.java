package org.subquark.ld36.goals;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.Gdx;

public class BuildCooldownUpdater {
    public static final float BUILD_COOLDOWN = 10f;
    
    private final GameState gameState;
    
    public BuildCooldownUpdater(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        if (this.gameState.buildCooldown >= 0) {
            this.gameState.buildCooldown -= deltaTime;
        }
    }
}
