package org.subquark.ld36.scanner;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;
import org.subquark.ld36.level.Level;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ScannerDisplay {
    //private static final ShapeRenderer blockRenderer = new ShapeRenderer();
    private static final ShapeRenderer lineRenderer = new ShapeRenderer();
    private final SpriteBatch batch = new SpriteBatch();
    
    private final GameState gameState;
    private final Textures textures;
    
    public ScannerDisplay(Textures textures, GameState gameState) {
        this.gameState = gameState;
        this.textures = textures;
    }
    
    public void update() {
        
        lineRenderer.begin(ShapeType.Line);
        for (Scanner s : gameState.scanners) {
            lineRenderer.setColor(Color.GREEN);
            if (s.cooldown > 0) {
                lineRenderer.rect(s.scanningX, s.scanningY, Level.TILE_PIXELS, Level.TILE_PIXELS);
                lineRenderer.line(s.scanningX + Level.TILE_PIXELS / 2, s.scanningY + Level.TILE_PIXELS / 2, s.x, s.y);
            }
        }
        lineRenderer.end();
            
        batch.begin();
        for (Scanner s : gameState.scanners) {
//            if (s.workerPower > 0) {
//                blockRenderer.setColor(Color.MAGENTA);
//            } else {
//                blockRenderer.setColor(Color.PURPLE);
//            }

//            blockRenderer.rect(s.x - Scanner.SCANNER_WIDTH/2, s.y - Scanner.SCANNER_HEIGHT / 2, Scanner.SCANNER_WIDTH, Scanner.SCANNER_HEIGHT);
  
            batch.draw(textures.scanner, s.x - Scanner.SCANNER_WIDTH / 2, s.y - Scanner.SCANNER_HEIGHT);

        }
        batch.end();
    }
}
