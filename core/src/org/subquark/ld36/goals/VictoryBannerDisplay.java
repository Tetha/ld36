package org.subquark.ld36.goals;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VictoryBannerDisplay {
    public static final SpriteBatch batch = new SpriteBatch();
    private static final BitmapFont font = new BitmapFont();
    
    private final Textures textures;
    private final GameState gameState;
    
    public VictoryBannerDisplay(Textures textures, GameState gameState) {
        this.textures = textures;
        this.gameState = gameState;
    }
    
    public void update() {
        batch.begin();
        if (gameState.wasWon()) {
            batch.draw(textures.victoryBanner, 220, 250);
        } else {
            batch.draw(textures.defeatBanner, 220, 250);
        }

        batch.draw(textures.requiredArtifactHeader, 220, 200);
        font.draw(batch,
                  Integer.toString(gameState.artifactsRequired),
                  340, 220);
        
        batch.draw(textures.totalArtifactHeader, 220, 150);
        font.draw(batch,
                  Integer.toString(gameState.artifacts),
                  340, 170);
        
        batch.draw(textures.researchedArtifactHeader, 220, 100);
        font.draw(batch,
                  Integer.toString(gameState.researchedArtifacts),
                  340, 120);

        
        batch.draw(textures.timeLeftHeader, 220, 50);
        font.draw(batch,
                  Integer.toString((int)gameState.remainingTime()) + "s",
                  340, 70);
        batch.end();
    }
}
