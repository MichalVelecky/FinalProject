package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTool
{
    /**
     * Scaling the image - constructor
     * @param original original image
     * @param widht width
     * @param height height
     * @return scaled image
     */
    public BufferedImage scaleImage(BufferedImage original, int widht, int height)
    {
        BufferedImage scaledImage = new BufferedImage(widht, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, widht, height, null);
        g2.dispose();
        return scaledImage;
    }
}
