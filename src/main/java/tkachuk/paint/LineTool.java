package tkachuk.paint;

import java.awt.*;

public class LineTool implements Tool
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int getX1()
    {
        return x1;
    }

    public int getY1()
    {
        return y1;
    }

    public int getX2()
    {
        return x2;
    }

    public int getY2()
    {
        return y2;
    }

    @Override
    public void pressed(Graphics g, int x, int y)
    {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x;
        this.y2 = y;
        g.drawLine(x, y, x, y);
    }

    @Override
    public void dragged(Graphics g, int x, int y)
    {
        this.x2 = x;
        this.y2 = y;
    }

    @Override
    public void preview(Graphics g)
    {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void released(Graphics g, int x, int y)
    {
        g.drawLine(this.x1, this.y1, x, y);
    }
}
