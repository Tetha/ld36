package org.subquark.ld36.level;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LevelDisplay {
    private final SpriteBatch batch = new SpriteBatch();
    private final ShapeRenderer renderer = new ShapeRenderer();
    
    private final GameState gameState;
    private final Textures textures;
    
    public LevelDisplay(Textures textures, GameState gameState) {
        this.gameState = gameState;
        this.textures = textures;
    }
    
    public void update() {
        batch.begin();
        for (int i = 0; i < Level.WIDTH_TILES; i++) {
            for (int j = 0; j < Level.HEIGHT_TILES; j++) {
                Texture texture;
                if (gameState.level.hasVisibleTreasure(i, j)) {
                    texture = textures.treasure;
                } else {
                    //drawScanBox = true;
                    texture = textures.sand;
                }
                
                batch.draw(texture , i * Level.TILE_PIXELS, j * Level.TILE_PIXELS);
            }
        }
        batch.end();
        
        renderer.begin(ShapeType.Filled);
        for (int i = 0; i < Level.WIDTH_TILES; i++) {
            for (int j = 0; j < Level.HEIGHT_TILES; j++) {
                boolean drawScanBox = false;
                if (gameState.level.hasVisibleTreasure(i, j)) {
                    renderer.setColor(Color.GOLD);
                } else {
                    drawScanBox = true;
                    renderer.setColor(Color.BROWN);
                }
//                renderer.rect(i * Level.TILE_PIXELS, j * Level.TILE_PIXELS, Level.TILE_PIXELS, Level.TILE_PIXELS);
                
                if (drawScanBox && gameState.level.wasScanned(i, j)) {
                    renderer.setColor(1f, 0f, 0f, 0.4f);
                    int offset = (Level.TILE_PIXELS - 2) / 2;
                    renderer.rect(i * Level.TILE_PIXELS + offset, j * Level.TILE_PIXELS + offset, 2, 2);
                }
            }
        }
        renderer.end();
    }
    
}
