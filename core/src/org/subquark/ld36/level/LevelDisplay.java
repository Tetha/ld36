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
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 50; j++) {
                boolean drawScanBox = false;
                if (level.hasVisibleTreasure(i, j)) {
                    renderer.setColor(Color.GOLD);
                } else {
                    drawScanBox = true;
                    renderer.setColor(Color.BROWN);
                }
                renderer.rect(i * 10, j * 10, 10, 10);
                
                if (drawScanBox && level.wasScanned(i, j)) {
                    renderer.setColor(1f, 0f, 0f, 0.4f);
                    renderer.rect(i * 10 + 4, j * 10 + 4, 2, 2);
                }
            }
        }
        renderer.end();
    }
    
}
