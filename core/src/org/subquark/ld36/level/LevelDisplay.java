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
                if (level.hasVisibleTreasure(i, j)) {
                    renderer.setColor(Color.GOLD);
                } else {
                    renderer.setColor(Color.BROWN);
                }
                renderer.rect(i * 10, j * 10, 10, 10);
            }
        }
        renderer.end();
    }
    
}
