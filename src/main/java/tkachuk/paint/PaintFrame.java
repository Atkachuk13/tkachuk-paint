package tkachuk.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintFrame extends JFrame
{
    private final DrawingComponent canvas = new DrawingComponent();
    private Tool lineTool = new LineTool();
    private Tool pencilTool = new PencilTool();
    private Tool eraserTool = new EraserTool();

    public PaintFrame()
    {
        //frame
        setTitle("Paint Frame");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //main panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //sub panel 1
        JPanel sub1 = new JPanel();
        sub1.setLayout(new FlowLayout());

        //sub panel 2
        JPanel sub2 = new JPanel();
        sub2.setLayout(new FlowLayout());

        // buttons panel 1
        JButton pencil = new JButton("Pencil");
        JButton line = new JButton("|");
        JButton eraser = new JButton("Eraser");

        sub1.add(pencil);
        sub1.add(line);
        sub1.add(eraser);

        // colors panel 2
        JButton colorButton = new JButton("Colors");

        sub2.add(colorButton);

        panel.add(sub1);
        panel.add(sub2);

        add(canvas, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        pencil.addActionListener(e ->
        {
            canvas.setTool(pencilTool);
        });

        line.addActionListener(e ->
        {
            canvas.setTool(lineTool);
        });

        eraser.addActionListener(e ->
        {
            canvas.setTool(eraserTool);
        });

        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    PaintFrame.this,
                    "Colors",
                    canvas.getDrawColor()
            );

            if (newColor != null)
            {
                canvas.setDrawColor(newColor);
            }
        });

        canvas.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(canvas.getDrawColor());
                canvas.getTool().dragged(g, event.getX(), event.getY());
                canvas.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {

            }
        });

        canvas.addMouseListener(new MouseListener()
        {
            private Point start;

            @Override
            public void mouseClicked(MouseEvent event)
            {

            }

            @Override
            public void mousePressed(MouseEvent event)
            {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(canvas.getDrawColor());
                canvas.getTool().pressed(g, event.getX(), event.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent event)
            {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(canvas.getDrawColor());
                canvas.getTool().released(g, event.getX(), event.getY());
                canvas.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

    }

    public static void main(String[] args)
    {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

