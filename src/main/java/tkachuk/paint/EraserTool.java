package tkachuk.paint;

import java.awt.*;
import java.awt.image.BufferedImage;


// setStroke
public class EraserTool implements Tool
{
    private int x;
    private int y;
    private Stroke stroke = new BasicStroke(10);

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
        g.drawLine(x, y, x, y);
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.setStroke(stroke);
        g.drawLine(this.x, this.y ,x ,y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void preview(Graphics2D g)
    {
        g.setStroke(stroke);
        g.drawRect(x - 10 / 2, y - 10 / 2, 10, 10);
    }

    @Override
    public void released(BufferedImage image, Graphics2D g, int x, int y)
    {

    }
}
