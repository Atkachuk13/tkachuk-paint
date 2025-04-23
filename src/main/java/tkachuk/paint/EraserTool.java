package tkachuk.paint;

import java.awt.*;

public class EraserTool implements Tool
{
    private int x;
    private int y;
    private final int size = 10;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public void pressed(Graphics g, int x, int y)
    {
        this.x = x;
        this.y = y;
        g.fillRect(x - size / 2, y - size / 2, size, size);
    }

    @Override
    public void dragged(Graphics g, int x, int y)
    {
        g.fillRect(x - size / 2, y - size / 2, size, size);
        this.x = x;
        this.y = y;
    }

    @Override
    public void preview(Graphics g)
    {
        g.drawRect(x - size / 2, y - size / 2, size, size);
    }

    @Override
    public void released(Graphics g, int x, int y)
    {

    }
}
