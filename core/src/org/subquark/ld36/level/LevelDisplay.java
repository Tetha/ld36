package org.subquark.ld36.level;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LevelDisplay {
    private final ShapeRenderer renderer = new ShapeRenderer();
    private final Level level;
    
    public LevelDisplay(Level level) {
        this.level = level;
    }
    
    public void update() {
        renderer.begin(ShapeType.Filled);
        for (int i = 0; i < Level.WIDTH_TILES; i++) {
            for (int j = 0; j < Level.HEIGHT_TILES; j++) {
                boolean drawScanBox = false;
                if (level.hasVisibleTreasure(i, j)) {
                    renderer.setColor(Color.GOLD);
                } else {
                    drawScanBox = true;
                    renderer.setColor(Color.BROWN);
                }
                renderer.rect(i * Level.TILE_PIXELS, j * Level.TILE_PIXELS, Level.TILE_PIXELS, Level.TILE_PIXELS);
                
                if (drawScanBox && level.wasScanned(i, j)) {
                    renderer.setColor(1f, 0f, 0f, 0.4f);
                    int offset = (Level.TILE_PIXELS - 2) / 2;
                    renderer.rect(i * Level.TILE_PIXELS + offset, j * Level.TILE_PIXELS + offset, 2, 2);
                }
            }
        }
        renderer.end();
    }
    
}
