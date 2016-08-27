package org.subquark.ld36.digsite;

import java.util.List;

import org.subquark.ld36.level.Level;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DigSiteDisplay {
    private static final ShapeRenderer blockRenderer = new ShapeRenderer();
    private static final ShapeRenderer lineRenderer = new ShapeRenderer();
    
    private final List<DigSite> digSites;
    
    public DigSiteDisplay(List<DigSite> digSites) {
        this.digSites = digSites;
    }
    
    public void update() {
        blockRenderer.begin(ShapeType.Filled);
        lineRenderer.begin(ShapeType.Line);
        for (DigSite ds : digSites) {
            if (ds.workerPower > 0) {
                blockRenderer.setColor(Color.GRAY);
            } else {
                blockRenderer.setColor(Color.DARK_GRAY);
            }
            blockRenderer.rect(ds.x - DigSite.WIDTH/2, ds.y - DigSite.HEIGHT/2, DigSite.WIDTH, DigSite.HEIGHT);
            
            if (ds.workerPower > 0) {
                int positionXInTile = ds.x / Level.TILE_PIXELS;
                int positionYInTile = ds.y / Level.TILE_PIXELS;

                lineRenderer.rect(positionXInTile - DigSite.MINING_RANGE_RADIUS, positionYInTile - DigSite.MINING_RANGE_RADIUS,
                                  2*DigSite.MINING_RANGE_RADIUS, 2*DigSite.MINING_RANGE_RADIUS);
            }
        }
        lineRenderer.end();
        blockRenderer.end();
    }
}