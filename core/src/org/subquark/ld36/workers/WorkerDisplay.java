package org.subquark.ld36.workers;

import java.util.List;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorkerDisplay {
    private static final ShapeRenderer renderer = new ShapeRenderer();
    
    private final GameState gameState;
    
    public WorkerDisplay(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        for (Worker w : gameState.workers) {
            renderer.circle(w.x, w.y, Worker.WORKER_DIAMETER);
        }
        renderer.end();
    }
}
