package org.subquark.ld36.shop;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ArtifactCountDisplay {
    private static final Batch batch = new SpriteBatch();
    private static final ShapeRenderer renderer = new ShapeRenderer();
    private static final BitmapFont font = new BitmapFont();
    
    private final GameState gameState;
    
    public ArtifactCountDisplay(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        batch.begin();
        font.draw(batch, "Total Artifacts: " + gameState.artifacts + " / Unresearched Artifacts: " + gameState.unresearchedArtifacts(), 10, 460);
        batch.end();
    }
}
