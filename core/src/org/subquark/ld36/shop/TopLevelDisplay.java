package org.subquark.ld36.shop;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TopLevelDisplay {
    private static final Batch batch = new SpriteBatch();
    private static final ShapeRenderer renderer = new ShapeRenderer();
    private static final BitmapFont font = new BitmapFont();
    
    private final GameState gameState;
    private final Textures textures;
    
    public TopLevelDisplay(Textures textures, GameState gameState) {
        this.gameState = gameState;
        this.textures = textures;
    }
    
    public void update() {
        batch.begin();
        
        batch.draw(textures.timeLeftHeader, 0, 450);
        font.draw(batch,
                  Integer.toString((int)gameState.remainingTime()) + "s",
                  100, 470);
        
        batch.draw(textures.totalArtifactHeader, 140, 450);
        font.draw(batch,
                  Integer.toString(gameState.artifacts),
                  260, 470);
        batch.draw(textures.researchedArtifactHeader, 280, 450);
        font.draw(batch,
                  Integer.toString(gameState.researchedArtifacts) + "/" + Integer.toString(gameState.artifactsRequired),
                  390, 470);


//        font.draw(batch,
//                  String.format("Total Artifacts: %d / Researched Artifacts: %d / Time left: %.0f",
//                                gameState.artifacts, gameState.researchedArtifacts, gameState.remainingTime()),
//                  10, 480);
        batch.end();
    }
}
