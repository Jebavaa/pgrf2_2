package rasterData;

import java.util.Optional;

public class ZBuffer implements Raster<Integer>
{

    private final RasterColor rasterColor;
    private final RasterDepth rasterDepth;
    public ZBuffer(RasterColor rasterColor)
    {
        this.rasterColor = rasterColor;
        // TODO create raster depth same dimension
    }

    @Override
    public int getWidth() // voláme metody rasterů
    {
        return rasterColor.getWidth();
    }

    @Override
    public int getHeight()
    {
        return rasterColor.getHeight();
    }

    @Override
    public Optional<Integer> getPixel(int x, int y)
    {
        return rasterColor.getPixel(x, y);
    }

    @Override
    public boolean setPixel(int x, int y, Integer pixelValue)
    {
        return rasterColor.setPixel(x, y, pixelValue);
    }

    public boolean setPixel(int x, int y, Integer pixelValue, double depth)
    {
        return false;
        // TODO Z-test
        // zkontrolovat jestli je stará hloubka větší než nová ( from rasterDepth)
        // pokud ano, set pixel in rasterColor using piixelValue a set pixel in rasterDepth using depth return true, jinak false
    }

    @Override
    public void clear(Integer pixelValue)
    {
        rasterColor.clear(pixelValue);
    }

    @Override
    public boolean isValidAddress(int x, int y)
    {
        return Raster.super.isValidAddress(x, y);
    }
}
