package org.subquark.ld36.goals;

import org.subquark.ld36.LudumDare36Entry;

import com.badlogic.gdx.InputProcessor;

public class EndGameInputHandler implements InputProcessor {
    private final LudumDare36Entry mainApp;
    
    public EndGameInputHandler(LudumDare36Entry mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        mainApp.transistToMenu();
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mainApp.transistToMenu();
        return true;
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
