package tkachuk.paint;

import java.awt.*;
import java.awt.image.BufferedImage;


// setStroke
public class EraserTool implements Tool
{
    private int x;
    private int y;
    private final int size = 10;
    Stroke stroke = new BasicStroke(10);

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y)
    {
        this.x = x;
        this.y = y;
        g.setColor(Color.WHITE);
        g.setStroke(stroke);
        g.fillRect(x - size / 2, y - size / 2, size, size);
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.setStroke(stroke);
        g.fillRect(x - size / 2, y - size / 2, size, size);
        this.x = x;
        this.y = y;
    }

    @Override
    public void preview(Graphics2D g)
    {
        g.setColor(Color.WHITE);
        g.setStroke(stroke);
        g.drawRect(x - size / 2, y - size / 2, size, size);
    }

    @Override
    public void released(Graphics2D g, int x, int y)
    {

    }
}
