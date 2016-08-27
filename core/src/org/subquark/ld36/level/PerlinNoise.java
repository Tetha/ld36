package org.subquark.ld36.level;

import java.util.Random;

import com.badlogic.gdx.Gdx;

public class PerlinNoise {
    public static final float[][] generateWhiteNoise(Random r, int width, int height) {
        float[][] noise = new float[width][height];
        for (int ii = 0; ii < width; ii++) {
            for (int jj = 0; jj < height; jj++) {
                noise[ii][jj] = r.nextFloat() % 1;
            }
        }
        return noise;
    }
    
    public static float[][] generateSmoothNoise(float[][] whiteNoise, int octave) {
        int width = whiteNoise.length;
        int height = whiteNoise[0].length;
        
        float[][] smoothNoise = new float[width][height];
        
        int samplePeriod = 1 << octave;
        float sampleFrequency = 1.0f / samplePeriod;
        
        for(int ii = 0; ii < width; ii++) {
            int sampleI0 = (ii / samplePeriod) * samplePeriod;
            int sampleI1 = (sampleI0 + samplePeriod) % width;
            float horizontalBlend = (ii - sampleI0) * sampleFrequency;
            
            for (int jj = 0; jj < height; jj++) {
                int sampleJ0 = (jj / samplePeriod) * samplePeriod;
                int sampleJ1 = (sampleJ0 + samplePeriod) % height;
                float verticalBlend = (jj - sampleJ0) * sampleFrequency;
                
                float top = lerp(whiteNoise[sampleI0][sampleJ0], whiteNoise[sampleI1][sampleJ0], horizontalBlend);
                float bottom = lerp(whiteNoise[sampleI0][sampleJ1], whiteNoise[sampleI1][sampleJ1], horizontalBlend);
                
                smoothNoise[ii][jj] = lerp(top, bottom, verticalBlend);
            }
        }
        return smoothNoise;
    }
    
    public static float[][] generatePerlinNoise(float[][] whiteNoise, int octaveCount) {
        int width = whiteNoise.length;
        int height = whiteNoise[0].length;
        
        float [][][] smoothNoise = new float[octaveCount][][];
        float persistance = 0.7f;
        
        for (int ii = 0; ii < octaveCount; ii++) {
            smoothNoise[ii] = generateSmoothNoise(whiteNoise, ii);
        }
        
        float[][] perlinNoise = new float[width][height];
        float amplitude = 1.0f;
        float totalAmplitude = 0.0f;
        
        for (int octave = octaveCount -1; octave >= 0; octave--) {
            amplitude *= persistance;
            totalAmplitude += amplitude;
            
            for (int ii = 0; ii < width; ii++) {
                for (int jj = 0; jj < height; jj++) {
                    perlinNoise[ii][jj] += smoothNoise[octave][ii][jj]*amplitude;
                }
            }
        }

        for (int ii = 0; ii < width; ii++) {
            for (int jj = 0; jj < height; jj++) {
                perlinNoise[ii][jj] /= totalAmplitude;
            }
        }
        
        return perlinNoise;
    }
    
    private static final float lerp(float x1, float x2, float t) {
        return x1 * (1 - t) + t * x2;
    }
}
