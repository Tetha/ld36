package org.subquark.ld36.digsite;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DigSiteDisplay {
    private static final SpriteBatch batch = new SpriteBatch();
    private static final ShapeRenderer lineRenderer = new ShapeRenderer();
    
    private final GameState gameState;
    private final Textures textures;
    
    public DigSiteDisplay(Textures textures, GameState gameState) {
        this.gameState = gameState;
        this.textures = textures;
    }
    
    public void update() {
//        lineRenderer.begin(ShapeType.Line);
        batch.begin();
        for (DigSite ds : gameState.digSites) {
//            if (ds.workerPower > 0) {
//                batch.setColor(Color.GRAY);
//            } else {
//                batch.setColor(Color.DARK_GRAY);
//            }
            batch.draw(textures.digger, ds.x - DigSite.WIDTH/2, ds.y - DigSite.HEIGHT/2, DigSite.WIDTH, DigSite.HEIGHT);
            
//            if (ds.workerPower > 0) {
//                lineRenderer.rect(ds.smallestXMinedPixels(), ds.smallestYMinedPixels(),
//                                  ds.totalMiningDiameterHorizontallyPixels(),
//                                  ds.totalMiningDiameterVerticallyPixels());
//            }
        }
        batch.end();
//        lineRenderer.end();
    }
}
