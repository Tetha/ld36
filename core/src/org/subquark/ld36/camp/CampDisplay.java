package org.subquark.ld36.camp;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class CampDisplay {
    private static final ShapeRenderer renderer = new ShapeRenderer();

    
    private final List<Camp> camps;
    
    public CampDisplay(List<Camp> camps) {
        this.camps = camps;
    }
    
    public void update() {
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.RED);
        for (Camp c : camps) {
            renderer.rect(c.x - Camp.CAMP_WIDTH/2, c.y - Camp.CAMP_HEIGHT / 2, Camp.CAMP_WIDTH, Camp.CAMP_HEIGHT);
        }
        renderer.end();
    }
}
