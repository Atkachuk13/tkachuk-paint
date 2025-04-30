package tkachuk.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LineToolTest
{
    private Graphics2D g = mock();
    private BufferedImage image = mock();

    @Test
    void pressed()
    {
        // given
        LineTool line = new LineTool();

        // when
        line.pressed(image, g, 100, 200);

        // then
        assertEquals(100, line.getX1());
        assertEquals(200, line.getY1());
        verify(g).drawLine(100, 200, 100, 200);
    }

    @Test
    void dragged()
    {
        // given
        LineTool line = new LineTool();
        line.pressed(image, g, 100, 200);

        // when
        line.dragged(g, 150, 300);

        // then
        verify(g).drawLine(100, 200, 100, 200);
        assertEquals(150, line.getX2());
        assertEquals(300, line.getY2());
    }

    @Test
    void preview()
    {
        // given
        LineTool line = new LineTool();
        line.pressed(image, g, 100, 200);

        // when
        line.dragged(g, 200, 300);

        // then
        verify(g).drawLine(100, 200, 100, 200);
        assertEquals(200, line.getX2());
        assertEquals(300, line.getY2());
    }

    @Test
    void released()
    {
        // given
        LineTool line = new LineTool();
        line.pressed(image, g, 100, 200);

        // when
        line.released(image, g, 200, 300);

        // then
        verify(g).drawLine(100, 200, 200, 300);
    }

}