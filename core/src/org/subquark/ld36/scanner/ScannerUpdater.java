package org.subquark.ld36.scanner;

import java.util.Random;

import org.subquark.ld36.GameState;
import org.subquark.ld36.level.Level;

import com.badlogic.gdx.Gdx;

public class ScannerUpdater {
    private final Random r;
    private final GameState gameState;
    
    public ScannerUpdater(Random r, GameState gameState) {
        this.r = r;
        this.gameState = gameState;
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        for (Scanner s : gameState.scanners) {
            if (s.cooldown > 0) {
                s.cooldown -= deltaTime;
            }
            
            if (s.workerPower > 0 && s.cooldown <= 0) {
                s.workerPower -= deltaTime;
                s.cooldown = Scanner.COOLDOWN;
                
                int scannedTilePixelX = s.x + r.nextInt(2 * Scanner.SCAN_RADIUS_PIXEL) - Scanner.SCAN_RADIUS_PIXEL;
                int scannedTilePixelY = s.y + r.nextInt(2 * Scanner.SCAN_RADIUS_PIXEL) - Scanner.SCAN_RADIUS_PIXEL;
                
                int scannedTileX = scannedTilePixelX / Level.TILE_PIXELS;
                int scannedTileY = scannedTilePixelY / Level.TILE_PIXELS;

                s.scanningX = scannedTileX * Level.TILE_PIXELS;
                s.scanningY = scannedTileY * Level.TILE_PIXELS;
                
                gameState.level.markScanned(scannedTileX, scannedTileY);
            }
        }
    }

}
