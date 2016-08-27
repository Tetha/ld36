package org.subquark.ld36.scanner;

import java.util.List;

import com.badlogic.gdx.Gdx;

public class ScannerUpdater {
    private final List<Scanner> scanners;
    
    public ScannerUpdater(List<Scanner> scanners) {
        this.scanners = scanners;
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        for (Scanner s : scanners) {
            if (s.workerPower > 0) {
                s.workerPower -= deltaTime;
            }
        }
    }

}
