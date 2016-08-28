package org.subquark.ld36.goals;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Sounds;

import com.badlogic.gdx.Gdx;

public class BuildCooldownUpdater {
    public static final float BUILD_COOLDOWN = 10f;
    
    private final GameState gameState;
    private final Sounds sounds;
    
    public BuildCooldownUpdater(Sounds sounds, GameState gameState) {
        this.sounds = sounds;
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        if (this.gameState.buildCooldown >= 0) {
            this.gameState.buildCooldown -= deltaTime;
            if (this.gameState.buildCooldown <= 0) {
                if (gameState.soundOn) {
                    this.sounds.cooldownComplete.play(gameState.volume);
                }
            }
        }
    }
}
