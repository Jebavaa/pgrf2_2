package rasterData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class RasterColor implements Raster<Integer>
{
    private final BufferedImage img;
    public RasterColor (int width, int height)
    {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public int getWidth()
    {
        return img.getWidth();
    }

    @Override
    public int getHeight()
    {
        return img.getHeight();
    }

    @Override
    public Optional<Integer> getPixel(int x, int y)
    {
        if(isValidAddress(x, y))
        {
            return Optional.of(img.getRGB(x,y) & 0xffffff);
        }
        else
        {
            return Optional.empty();
        }
    }

    @Override
    public boolean setPixel(int x, int y, Integer pixelValue)
    {
        if(isValidAddress(x, y))
        {
            img.setRGB(x, y, pixelValue);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void clear(Integer pixelValue)
    {
        Graphics graphics = img.getGraphics();
        graphics.setColor(new Color(pixelValue));
        graphics.drawRect(0, 0, getWidth(), getHeight());
    }
}
