package org.subquark.ld36.shop;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TopLevelDisplay {
    private static final Batch batch = new SpriteBatch();
    private static final ShapeRenderer renderer = new ShapeRenderer();
    private static final BitmapFont font = new BitmapFont();
    
    private final GameState gameState;
    
    public TopLevelDisplay(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        batch.begin();
        font.draw(batch,
                  String.format("Total Artifacts: %d / Researched Artifacts: %d / Time left: %.0f",
                                gameState.artifacts, gameState.researchedArtifacts, gameState.remainingTime()),
                  10, 480);
        batch.end();
    }
}
