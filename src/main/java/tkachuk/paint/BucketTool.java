package tkachuk.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BucketTool implements Tool
{
    private int x;
    private int y;
    private Color currColor;
    private Color newColor;

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y)
    {
        this.x = x;
        this.y = y;
        //get color at x and y where just pressed
        newColor = g.getColor();
        currColor = new Color(image.getRGB(x, y));
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {

    }

    @Override
    public void preview(Graphics2D g)
    {

    }

    @Override
    public void released(BufferedImage image, Graphics2D g, int x, int y)
    {
        // when released change the color to a new color
        /* recursively check the surrounding pixels, and if it's the same color as the one you originally found then you
        fill them in (continue until hit a diff color)*/
        if (currColor.equals(newColor))
        {
            return;
        }

        fill(image, x, y, currColor, newColor);
    }

    private void fill(BufferedImage image, int x, int y, Color tColor, Color rColor)
    {
        if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight())
        {
            return;
        }

        Color currentColor = new Color(image.getRGB(x, y));

        if (!currentColor.equals(tColor) || currentColor.equals(rColor))
        {
            return;
        }

        image.setRGB(x, y, rColor.getRGB());

        fill(image, x + 1, y, tColor, rColor);
        fill(image, x - 1, y, tColor, rColor);
        fill(image, x, y + 1, tColor, rColor);
        fill(image, x, y - 1, tColor, rColor);
    }
}
