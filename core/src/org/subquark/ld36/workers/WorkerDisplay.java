package org.subquark.ld36.workers;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorkerDisplay {
    private final SpriteBatch batch = new SpriteBatch();
    
    private final GameState gameState;
    private final Textures textures;
    
    public WorkerDisplay(Textures textures, GameState gameState) {
        this.textures = textures;
        this.gameState = gameState;
    }
    
    public void update() {
        batch.begin();
        batch.enableBlending();
        for (Worker w : gameState.workers) {
            batch.draw(textures.worker, w.x, w.y);
        }
        batch.end();
    }
}
