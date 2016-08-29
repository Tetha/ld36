package org.subquark.ld36.menu;

import org.subquark.ld36.LudumDare36Entry;
import org.subquark.ld36.goals.TimeConstraint;
import org.subquark.ld36.goals.TreasureDensity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuInputHandler implements InputProcessor {
    private final LudumDare36Entry mainApp;
    private final Viewport viewport;
    
    public TreasureDensity selectedTreasure = TreasureDensity.SOME;
    public TimeConstraint selectedTime = TimeConstraint.SOME;
    
    public MenuInputHandler(LudumDare36Entry mainApp, Viewport viewport) {
        this.mainApp = mainApp;
        this.viewport = viewport;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 screenCoords = new Vector2(screenX, screenY);
        //Gdx.app.debug("menu input handler", String.format("screenX: %d screenY: %d", screenX, screenY));

        Vector2 worldCoords = viewport.unproject(screenCoords);
        float clickX = worldCoords.x;
        float clickY = worldCoords.y;
        
        //Gdx.app.debug("menu input handler", String.format("clickX: %f clickY: %f", clickX, clickY));
        if (180 <= clickY && clickY <= 240) {
            // treasure row
            if (200 < clickX && clickX <= 260) {
                selectedTreasure = TreasureDensity.LOTS;
                return true;
            } else if (270 <= clickX && clickX <= 330) {
                selectedTreasure = TreasureDensity.SOME;
                return true;
            } else if (340 <= clickX && clickX <= 400) {
                selectedTreasure = TreasureDensity.NONE;
                return true;
            }
        }
        
        if (120 <= clickY && clickY <= 180) {
            // treasure row
            if (200 < clickX && clickX <= 260) {
                selectedTime = TimeConstraint.LOTS;
                return true;
            } else if (270 <= clickX && clickX <= 330) {
                selectedTime = TimeConstraint.SOME;
                return true;
            } else if (340 <= clickX && clickX <= 400) {
                selectedTime = TimeConstraint.NONE;
                return true;
            }
        }
        
        if (60 <= clickY && clickY <= 110) {
            if (270 <= clickX && clickX <= 410) {
                mainApp.transistToGame(selectedTreasure, selectedTime);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
