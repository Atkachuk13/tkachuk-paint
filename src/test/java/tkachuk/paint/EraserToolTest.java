package tkachuk.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EraserToolTest
{
    private Graphics2D g = mock();
    private BufferedImage image = mock();

    @Test
    void pressed()
    {
        // given
        EraserTool eraser = new EraserTool();

        // when
        eraser.pressed(image, g, 100, 200);

        // then
        assertEquals(100, eraser.getX());
        assertEquals(200, eraser.getY());
        verify(g).drawLine(100, 200, 100, 200);

    }

    @Test
    void dragged()
    {
        // given
        EraserTool eraser = new EraserTool();
        eraser.pressed(image, g, 100, 200);

        // when
        eraser.dragged(g, 150, 250);

        // then
        verify(g).drawLine(100, 200, 150, 250);
        assertEquals(150, eraser.getX());
        assertEquals(250, eraser.getY());
    }

    @Test
    void preview()
    {
        // given
        EraserTool eraser = new EraserTool();
        eraser.pressed(image, g, 100, 200);

        // when
        eraser.preview(g);

        // then
        assertEquals(100, eraser.getX());
        assertEquals(200, eraser.getY());
        verify(g).drawRect(100 - 10 / 2, 200 - 10 / 2, 10, 10);
    }

    @Test
    void released()
    {
        // given
        EraserTool eraser = new EraserTool();

        // when
        eraser.released(image, g, 50, 100);

        // then
        verifyNoMoreInteractions(g);
    }

}