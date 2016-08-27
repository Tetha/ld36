package org.subquark.ld36.scanner;

public class Scanner {
    public static final int SCANNER_WIDTH = 20;
    public static final int SCANNER_HEIGHT = 20;
    public static final float POWER_FOR_ONE_WORKER = 1;
    public static final int SCAN_RADIUS_PIXEL = 100;
    public static final float COOLDOWN = 0.5f;
    
    public int x;
    public int y;
    
    public int scanningX;
    public int scanningY;
    
    public float workerPower;
    public float cooldown;
}
