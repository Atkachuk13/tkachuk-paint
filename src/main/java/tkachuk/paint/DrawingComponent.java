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

    public Tool getTool()
    {
        return tool;
    }

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

}
