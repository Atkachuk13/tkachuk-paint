package tkachuk.paint;

import java.awt.*;

public class EraserTool implements Tool
{
    private int x;
    private int y;

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

    }

    @Override
    public void dragged(Graphics g, int x, int y)
    {

    }

    @Override
    public void preview(Graphics g)
    {

    }

    @Override
    public void released(Graphics g, int x, int y)
    {

    }
}
