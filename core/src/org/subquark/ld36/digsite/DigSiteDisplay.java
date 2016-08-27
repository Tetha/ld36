package org.subquark.ld36.digsite;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DigSiteDisplay {
    private static final ShapeRenderer blockRenderer = new ShapeRenderer();
    private static final ShapeRenderer lineRenderer = new ShapeRenderer();
    
    private final GameState gameState;
    
    public DigSiteDisplay(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        blockRenderer.begin(ShapeType.Filled);
        lineRenderer.begin(ShapeType.Line);
        for (DigSite ds : gameState.digSites) {
            if (ds.workerPower > 0) {
                blockRenderer.setColor(Color.GRAY);
            } else {
                blockRenderer.setColor(Color.DARK_GRAY);
            }
            blockRenderer.rect(ds.x - DigSite.WIDTH/2, ds.y - DigSite.HEIGHT/2, DigSite.WIDTH, DigSite.HEIGHT);
            
            if (ds.workerPower > 0) {
                lineRenderer.rect(ds.smallestXMinedPixels(), ds.smallestYMinedPixels(),
                                  ds.totalMiningDiameterHorizontallyPixels(),
                                  ds.totalMiningDiameterVerticallyPixels());
            }
        }
        lineRenderer.end();
        blockRenderer.end();
    }
}
