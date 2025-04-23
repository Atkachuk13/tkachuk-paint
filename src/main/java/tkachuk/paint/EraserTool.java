package tkachuk.paint;

import java.awt.*;

public class EraserTool implements Tool
{
    private int x;
    private int y;
    private final int eraserSize = 10;

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
        g.fillRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize);
    }

    @Override
    public void dragged(Graphics g, int x, int y)
    {
        g.fillRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize);
        this.x = x;
        this.y = y;
    }

    @Override
    public void preview(Graphics g)
    {
        g.drawRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize);
    }

    @Override
    public void released(Graphics g, int x, int y)
    {

    }
}
