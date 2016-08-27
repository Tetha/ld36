package org.subquark.ld36.digsite;

import java.util.List;

import org.subquark.ld36.level.Level;

import com.badlogic.gdx.Gdx;

public class DigSiteUpdater {
    private final Level level;
    private final List<DigSite> digSites;
    
    public DigSiteUpdater(Level level, List<DigSite> digSites) {
        this.level = level;
        this.digSites = digSites;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        for (DigSite ds : digSites) {
            if (ds.workerPower <= 0) continue;
            
            ds.workerPower -= deltaTime;
            
            ds.depthMined += deltaTime;
            if (ds.depthMined >= DigSite.SECONDS_PER_PAYOUT) {
                ds.depthMined -= DigSite.SECONDS_PER_PAYOUT;
                int positionXInTile = ds.x / Level.TILE_PIXELS;
                int positionYInTile = ds.y / Level.TILE_PIXELS;
                
                for ( int x = positionXInTile - DigSite.MINING_RANGE_RADIUS; x < positionXInTile + DigSite.MINING_RANGE_RADIUS; x++ ) {
                    for ( int y = positionYInTile - DigSite.MINING_RANGE_RADIUS; y < positionYInTile + DigSite.MINING_RANGE_RADIUS; y++ ) {
                        if (level.hasVisibleTreasure(x, y)) {
                            Gdx.app.log("digsite updater", "MONEY!");
                        }
                    }
                }
            }
        }
    }
}
