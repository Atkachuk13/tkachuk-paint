package tkachuk.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Draw the buffer image to the screen.
 */
public class DrawingComponent extends JComponent
{
    private Color drawColor = Color.BLACK;
    private final BufferedImage image = new BufferedImage(
            800, 650, BufferedImage.TYPE_INT_RGB);
    Point startPoint;
    Point endPoint;
    private Tool tool = new PencilTool();

    public DrawingComponent()
    {
        // set the image to all white
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
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

//    public void setStartPoint(Point point)
//    {
//        this.startPoint = point;
//        endPoint = point;
//        repaint();
//    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

        if (startPoint != null && endPoint != null)
        {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }

        tool.preview(g);

    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void setTool(Tool tool)
    {
        this.tool = tool;
    }

//    public void drawFromMouse(int x, int y)
//    {
//        Graphics g = image.getGraphics();
//        g.setColor(drawColor);
//        tool.dragged(g, x, y);
////        if (oldx != -1 && oldy != -1)
////        {
////            g.drawLine(oldx, oldy, x, y);
////        }
////        oldx = x;
////        oldy = y;
//        repaint();  // tells the operating system to recall the whole drawing component
//    }

//    public void drawLine(int x1, int y1, int x2, int y2)
//    {
//        Graphics g = image.getGraphics();
//        g.setColor(drawColor);
//        g.drawLine(x1, y1, x2, y2);
//        repaint();
//    }
//
//    public void showLine(Point point)
//    {
//        endPoint = point;
//        repaint();
//    }
}
