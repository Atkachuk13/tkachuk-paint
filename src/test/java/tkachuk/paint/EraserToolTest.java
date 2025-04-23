package tkachuk.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EraserToolTest
{
    private Graphics g = mock();

    @Test
    void pressed()
    {
        // given
        EraserTool eraser = new EraserTool();

        // when
        eraser.pressed(g, 100, 200);

        // then
        assertEquals(100, eraser.getX());
        assertEquals(200, eraser.getY());
        verify(g).fillRect(100, 200, 10, 10);
    }

    @Test
    void dragged()
    {
        // given
        EraserTool eraser = new EraserTool();

        // when
        eraser.dragged(g, 100, 200);

        // then
        verify(g).fillRect(100, 200, 10, 10);
        assertEquals(100, eraser.getX());
        assertEquals(200, eraser.getY());
    }

    @Test
    void preview()
    {
        // given
        EraserTool eraser = new EraserTool();

        // when
        eraser.dragged(g, 100, 200);

        // then
        assertEquals(100, eraser.getX());
        assertEquals(200, eraser.getY());
        verify(g).fillRect(100, 200, 10, 10);
    }

    @Test
    void released()
    {
        // given
        EraserTool eraser = new EraserTool();

        // when
        eraser.released(g, 50, 100);

        // then
        verifyNoMoreInteractions(g);
    }

}