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
        Gdx.app.debug("menu input handler", String.format("screenX: %d screenY: %d", screenX, screenY));

        Vector2 worldCoords = viewport.unproject(screenCoords);
        float clickX = worldCoords.x;
        float clickY = worldCoords.y;
        
        Gdx.app.debug("menu input handler", String.format("clickX: %f clickY: %f", clickX, clickY));
        if (130 + 10 <= clickX && clickX <= 130 + 10 + 90
            && 310 + 10 <= clickY && clickY <= 310 + 10 + 40) {
            Gdx.app.log("menu input", "much time / lots of treasure");
            mainApp.transistToGame(TreasureDensity.LOTS, TimeConstraint.LOTS);
            return true;
        }
        if (230 + 10 <= clickX && clickX <= 230 + 10 + 90
            && 310 + 10 <= clickY && clickY <= 310 + 10 + 40) {
            Gdx.app.log("menu input", "some time / lots of treasure");
            mainApp.transistToGame(TreasureDensity.LOTS, TimeConstraint.SOME);
            return true;
        }
        if (330 + 10 <= clickX && clickX <= 330 + 10 + 90
            && 310 + 10 <= clickY && clickY <= 310 + 10 + 40) {
            Gdx.app.log("menu input", "no time / lots of treasure");
            mainApp.transistToGame(TreasureDensity.LOTS, TimeConstraint.NONE);
            return true;
        }
            
        if (130 + 10 <= clickX && clickX <= 130 + 10 + 90
            && 260 + 10 <= clickY && clickY <= 260 + 10 + 40) {
            Gdx.app.log("menu input", "much time / some treasure treasure");
            mainApp.transistToGame(TreasureDensity.SOME, TimeConstraint.LOTS);
            return true;
        }
        if (230 + 10 <= clickX && clickX <= 230 + 10 + 90
            && 260 + 10 <= clickY && clickY <= 260 + 10 + 40) {
            Gdx.app.log("menu input", "some time / some treasure treasure");
            mainApp.transistToGame(TreasureDensity.SOME, TimeConstraint.SOME);
            return true;
        }
        if (330 + 10 <= clickX && clickX <= 330 + 10 + 90
            && 260 + 10 <= clickY && clickY <= 260 + 10 + 40) {
            Gdx.app.log("menu input", "no time / some treasure treasure");
            mainApp.transistToGame(TreasureDensity.SOME, TimeConstraint.NONE);
            return true;
        }
            
        if (130 + 10 <= clickX && clickX <= 130 + 10 + 90
            && 210 + 10 <= clickY && clickY <= 210 + 10 + 40) {
            Gdx.app.log("menu input", "much time / almost no treasure");
            mainApp.transistToGame(TreasureDensity.NONE, TimeConstraint.LOTS);
            return true;
        }
        if (230 + 10 <= clickX && clickX <= 230 + 10 + 90
            && 210 + 10 <= clickY && clickY <= 210 + 10 + 40) {
            Gdx.app.log("menu input", "some time / almost no treasure");
            mainApp.transistToGame(TreasureDensity.NONE, TimeConstraint.SOME);
            return true;
        }
        if (330 + 10 <= clickX && clickX <= 330 + 10 + 90
            && 210 + 10 <= clickY && clickY <= 210 + 10 + 40) {
            Gdx.app.log("menu input", "no time / almost no treasure");
            mainApp.transistToGame(TreasureDensity.NONE, TimeConstraint.NONE);
            return true;
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
