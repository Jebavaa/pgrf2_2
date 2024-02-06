package rasterData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class RasterDepth implements Raster<Double>
{

    private final double[][] img;

    public RasterDepth(int width, int height)
    {
        img = new double[width][height];
    }
    @Override
    public int getWidth()
    {
        return img.length;
    }

    @Override
    public int getHeight()
    {
        return img[0].length;
    }

    @Override
    public Optional<Double> getPixel(int x, int y)
    {
        if(isValidAddress(x, y))
        {
            return Optional.of(img[x][y]);
        }
        else
        {
            return Optional.empty();
        }
    }

    @Override
    public boolean setPixel(int x, int y, Double pixelValue)
    {

        if(isValidAddress(x, y))
        {
            img[x][y] = pixelValue;
            return true;
        }
        return false;
    }

    @Override
    public void clear(Double pixelValue)
    {
        for(int i = 0; i > img.length; i++)
            {
                for(int j = 0; j >img[0].length; j++)
                {
                    img[i][j] = pixelValue;
                }
            }
    }
}
