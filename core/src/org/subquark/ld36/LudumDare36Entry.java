package org.subquark.ld36;

import java.util.ArrayList;
import java.util.Random;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.camp.CampDisplay;
import org.subquark.ld36.camp.CampUpdater;
import org.subquark.ld36.digsite.DigSite;
import org.subquark.ld36.digsite.DigSiteDisplay;
import org.subquark.ld36.digsite.DigSiteUpdater;
import org.subquark.ld36.level.Level;
import org.subquark.ld36.level.LevelDisplay;
import org.subquark.ld36.level.PerlinNoise;
import org.subquark.ld36.scanner.Scanner;
import org.subquark.ld36.scanner.ScannerDisplay;
import org.subquark.ld36.scanner.ScannerUpdater;
import org.subquark.ld36.shop.ShopDisplay;
import org.subquark.ld36.shop.ShopInputHandler;
import org.subquark.ld36.workers.Worker;
import org.subquark.ld36.workers.WorkerDisplay;
import org.subquark.ld36.workers.WorkerUpdater;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LudumDare36Entry extends ApplicationAdapter {
	ShapeRenderer renderer;
	Texture img;
	
	Random levelGenRandom = new Random();
	Random otherRandom = new Random();
	private float[][] noise;
	
	private GameState gameState = new GameState();
    private WorkerUpdater workerUpdater;
	private CampUpdater campUpdater;
	private ScannerUpdater scannerUpdater;
	private DigSiteUpdater digSiteUpdater;
	
	private ShopInputHandler inputHandler;
	
	private LevelDisplay levelDisplay;
	private WorkerDisplay workerDisplay;
	private CampDisplay campDisplay;
	private ScannerDisplay scannerDisplay;
	private ShopDisplay shopDisplay;
	private DigSiteDisplay digSiteDisplay;
	
	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        renderer = new ShapeRenderer();
        
        gameState.level = Level.newLevel(levelGenRandom, Level.WIDTH_TILES, Level.HEIGHT_TILES, 0.8f);
				
        workerUpdater = new WorkerUpdater(gameState);
        campUpdater = new CampUpdater(gameState);
        scannerUpdater = new ScannerUpdater(otherRandom, gameState);
        digSiteUpdater = new DigSiteUpdater(gameState);
        
        inputHandler = new ShopInputHandler(gameState);
        Gdx.input.setInputProcessor(inputHandler);
        
		workerDisplay = new WorkerDisplay(gameState);
		campDisplay = new CampDisplay(gameState);
		scannerDisplay = new ScannerDisplay(gameState);
		levelDisplay = new LevelDisplay(gameState);
		shopDisplay = new ShopDisplay(inputHandler);
		digSiteDisplay = new DigSiteDisplay(gameState);
		
		Worker testWorker = new Worker();
		gameState.workers.add(testWorker);
		testWorker.x = 100;
		testWorker.y = 100;
		testWorker.lifetimeLeft = Worker.START_LIFETIME;
		
		Camp testCamp = new Camp();
		gameState.camps.add(testCamp);
		testCamp.x = 200;
		testCamp.y = 300;
		
		Scanner testScanner = new Scanner();
		gameState.scanners.add(testScanner);
		testScanner.x = 200;
		testScanner.y = 200;
		
        Scanner testScanner2 = new Scanner();
        gameState.scanners.add(testScanner2);
        testScanner2.x = 400;
        testScanner2.y = 300;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		workerUpdater.update();
		
		campUpdater.update();
		scannerUpdater.update();
		digSiteUpdater.update();
		
		//drawGrid();
		
		levelDisplay.update();
		
        campDisplay.update();
        scannerDisplay.update();
        digSiteDisplay.update();
        
        workerDisplay.update();
        
        shopDisplay.update();
	}
	
	private void drawGrid() {
	    renderer.begin(ShapeType.Filled);
	    for (int i = 0; i < 60; i++) {
	        for (int j = 0; j < 50; j++) {
	            float noiseHere = noise[i][j];
	            if (noiseHere > 0.8) {
	                renderer.setColor(noiseHere, noiseHere, noiseHere, noiseHere);
	            } else {
	                renderer.setColor(Color.BLACK);
	            }
	            renderer.rect(i * 10, j * 10, 10, 10);
	        }
	    }
	    renderer.end();
	}
	@Override
	public void dispose () {
	}
}
