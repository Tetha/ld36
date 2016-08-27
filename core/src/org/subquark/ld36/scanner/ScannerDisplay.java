package org.subquark.ld36.scanner;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ScannerDisplay {
    private static final ShapeRenderer renderer = new ShapeRenderer();
    private final List<Scanner> scanners;
    
    public ScannerDisplay(List<Scanner> scanners) {
        this.scanners = scanners;
    }
    
    public void update() {
        renderer.begin(ShapeType.Filled);
        for (Scanner s : scanners) {
            if (s.workerPower > 0) {
                renderer.setColor(Color.MAGENTA);
            } else {
                renderer.setColor(Color.PURPLE);
            }

            renderer.rect(s.x - Scanner.SCANNER_WIDTH/2, s.y - Scanner.SCANNER_HEIGHT / 2, Scanner.SCANNER_WIDTH, Scanner.SCANNER_HEIGHT);
        }
        renderer.end();
    }
}
