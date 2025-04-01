package tkachuk.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class DrawingComponent extends JComponent
{
private Color drawColor = Color.BLACK;
    private final BufferedImage image = new BufferedImage(
            800,650,
            BufferedImage.TYPE_INT_RGB);
    private  int oldx;
    private int oldy;

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
    public DrawingComponent()
    {
        // set the image to all white
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,image.getWidth(),image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(image,0,0,null);

    }

    public void drawFromMouse(int x, int y)
    {
        Graphics g = image.getGraphics();
        g.setColor(drawColor);
        if(oldx != -1 && oldy != -1)
        {
            g.drawLine(oldx,oldy,x,y);
        }
        oldx = x;
        oldy = y;

        repaint();  // tells the operating system to recall the whole drawing component
    }

    public void drawLine(int x, int y)
    {

    }
}
