package tkachuk.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

// interface defines methods that a class that implement that interface must implement
public interface Tool
{
    void pressed(BufferedImage image, Graphics2D g, int x, int y);

    void dragged(Graphics2D g, int x, int y);

    /**
     * Draws a preview of the tool's operation if released is
     *
     * @param g
     */
    void preview(Graphics2D g);

    void released(Graphics2D g, int x, int y);

}
