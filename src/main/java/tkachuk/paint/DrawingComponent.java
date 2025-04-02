package tkachuk.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent extends JComponent
{
    private Color drawColor = Color.BLACK;
    private final BufferedImage image = new BufferedImage(
            800, 650, BufferedImage.TYPE_INT_RGB);
    private int oldx;
    private int oldy;
    Point startPoint;
    Point endPoint;

    public DrawingComponent()
    {
        // set the image to all white
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    public void setOldxy(int oldx, int oldy)
    {
        this.oldx = oldx;
        this.oldy = oldy;
        repaint();
    }

    public void setDrawColor(Color drawColor)
    {
        this.drawColor = drawColor;
        repaint();
    }

    public Color getDrawColor()
    {
        return drawColor;
    }

    public void setStartPoint(Point point)
    {
        this.startPoint = point;
        endPoint = startPoint;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

    }

    public void drawFromMouse(int x, int y)
    {
        Graphics g = image.getGraphics();
        g.setColor(drawColor);
        if (oldx != -1 && oldy != -1)
        {
            g.drawLine(oldx, oldy, x, y);
        }
        oldx = x;
        oldy = y;

        repaint();  // tells the operating system to recall the whole drawing component
    }

    public void drawLine(int x1, int y1, int x2, int y2)
    {
        Graphics g = image.getGraphics();
        g.setColor(drawColor);
        g.drawLine(x1, y1, x2, y2);
        repaint();

    }

    public void showLine(Point point)
    {
        endPoint = point;
        repaint();
    }
}
