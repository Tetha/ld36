package org.subquark.ld36.workers;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorkerDisplay {
    private static final ShapeRenderer renderer = new ShapeRenderer();
    
    private final List<Worker> workers;
    
    public WorkerDisplay(List<Worker> workers) {
        this.workers = workers;
    }
    
    public void update() {
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        for (Worker w : workers) {
            renderer.circle(w.x, w.y, 5);
        }
        renderer.end();
    }
}
