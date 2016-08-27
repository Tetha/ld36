package org.subquark.ld36;

import java.util.ArrayList;
import java.util.List;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.camp.CampDisplay;
import org.subquark.ld36.camp.CampUpdater;
import org.subquark.ld36.scanner.Scanner;
import org.subquark.ld36.scanner.ScannerDisplay;
import org.subquark.ld36.scanner.ScannerUpdater;
import org.subquark.ld36.workers.Worker;
import org.subquark.ld36.workers.WorkerDisplay;
import org.subquark.ld36.workers.WorkerUpdater;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LudumDare36Entry extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	private List<Worker> workers;
	private List<Camp> camps;
	private List<Scanner> scanners;
	
	private WorkerUpdater workerUpdater;
	private CampUpdater campUpdater;
	private ScannerUpdater scannerUpdater;
	
	private WorkerDisplay workerDisplay;
	private CampDisplay campDisplay;
	private ScannerDisplay scannerDisplay;
	
	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

	    workers = new ArrayList<Worker>();
		camps = new ArrayList<Camp>();
		scanners = new ArrayList<Scanner>();
				
        workerUpdater = new WorkerUpdater(camps, scanners, workers);
        campUpdater = new CampUpdater(workers, camps);
        scannerUpdater = new ScannerUpdater(scanners);
        
		workerDisplay = new WorkerDisplay(workers);
		campDisplay = new CampDisplay(camps);
		scannerDisplay = new ScannerDisplay(scanners);
		
		
		Worker testWorker = new Worker();
		workers.add(testWorker);
		testWorker.x = 100;
		testWorker.y = 100;
		testWorker.lifetimeLeft = Worker.START_LIFETIME;
		
		Camp testCamp = new Camp();
		camps.add(testCamp);
		testCamp.x = 200;
		testCamp.y = 300;
		
		Scanner testScanner = new Scanner();
		scanners.add(testScanner);
		testScanner.x = 200;
		testScanner.y = 200;
		
        Scanner testScanner2 = new Scanner();
        scanners.add(testScanner2);
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
		
        campDisplay.update();
        scannerDisplay.update();
        workerDisplay.update();
	}
	
	@Override
	public void dispose () {
	}
}
