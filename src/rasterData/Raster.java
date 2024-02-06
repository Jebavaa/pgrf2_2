package rasterData;

import java.util.Optional;

public interface Raster<P>
{
    int getWidth();
    int getHeight();
    Optional<P> getPixel(int x, int y);
    boolean setPixel(int x, int y, P pixelValue);
    void clear(P pixelValue);

    default boolean isValidAddress(int x, int y)
    {

        if(getWidth() > x && getHeight() > y)
        {
            return true;
        }
        return false;
    }
}
