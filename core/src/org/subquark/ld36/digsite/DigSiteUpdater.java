package org.subquark.ld36.digsite;

import org.subquark.ld36.GameState;
import org.subquark.ld36.level.Level;

import com.badlogic.gdx.Gdx;

public class DigSiteUpdater {
    private final GameState gameState;
    
    public DigSiteUpdater(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        for (DigSite ds : gameState.digSites) {
            if (ds.workerPower <= 0) continue;
            
            ds.workerPower -= deltaTime;
            
            ds.depthMined += deltaTime;
            if (ds.depthMined >= DigSite.SECONDS_PER_PAYOUT) {
                ds.depthMined -= DigSite.SECONDS_PER_PAYOUT;
                
                for (int xO = 0; xO < ds.totalMiningDiameterHorizontallyTiles(); xO++) {
                    for (int yO = 0; yO < ds.totalMiningDiameterVerticallyTiles(); yO++) {
                        if (gameState.level.hasVisibleTreasure(ds.smallestXMinedTiles() + xO, ds.smallestYMinedTiles() + yO)) {
                            gameState.artifacts += 1;
                        }
                    }
                }
            }
        }
    }
}
