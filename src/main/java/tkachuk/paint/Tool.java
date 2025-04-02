package tkachuk.paint;

import java.awt.*;

// interface defines methods that a class that implement that interface must implement
public interface Tool
{
    void pressed(Graphics g, int x, int y);
    void dragged(Graphics g, int x, int y);
    void released(Graphics g, int x, int y);

}
