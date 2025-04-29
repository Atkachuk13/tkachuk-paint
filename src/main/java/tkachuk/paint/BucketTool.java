package tkachuk.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BucketTool implements Tool
{
    private int x;
    private int y;
    private Color color;

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y)
    {
       this.x = x;
       this.y = y;
       //get color at x and y where just pressed
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
    public void released(Graphics2D g, int x, int y)
    {
        // when released change the color to a new color
        // recursively check the surounding pizels, and if its the same color as the one you originally found then you
        //fill them in (continue untill hit a diff color)
    }
}
