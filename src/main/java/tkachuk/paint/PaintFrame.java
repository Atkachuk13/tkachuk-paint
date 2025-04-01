package tkachuk.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintFrame extends JFrame
{
    private final DrawingComponent canvas = new DrawingComponent();
    private boolean pencilPressed = false;
    private boolean linePressed = false;

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

        sub1.add(pencil);
        sub1.add(line);

        // buttons panel 2
        JButton green = new JButton();
        green.setBackground(Color.GREEN);
        JButton blue = new JButton();
        blue.setBackground(Color.BLUE);
        JButton red = new JButton();
        red.setBackground(Color.RED);
        JButton magenta = new JButton();
        magenta.setBackground(Color.MAGENTA);
        JButton black = new JButton();
        black.setBackground(Color.BLACK);

        sub2.add(green);
        sub2.add(blue);
        sub2.add(red);
        sub2.add(magenta);
        sub2.add(black);

        panel.add(sub1);
        panel.add(sub2);

        add(canvas, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        pencil.addActionListener(e ->
        {
            pencilPressed = true;
            linePressed = false;
        });

        line.addActionListener(e ->
        {
            pencilPressed = false;
            linePressed = true;
        });

        green.addActionListener(e -> canvas.setDrawColor(Color.GREEN));
        blue.addActionListener(e -> canvas.setDrawColor(Color.BLUE));
        red.addActionListener(e -> canvas.setDrawColor(Color.RED));
        magenta.addActionListener(e -> canvas.setDrawColor(Color.MAGENTA));
        black.addActionListener(e -> canvas.setDrawColor(Color.BLACK));

        canvas.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                if (pencilPressed)
                {
                    canvas.drawFromMouse(event.getX(), event.getY());
                }
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {

            }
        });

        canvas.addMouseListener(new MouseListener()
        {
            private int startX;
            private int startY;

            @Override
            public void mouseClicked(MouseEvent event)
            {

            }

            @Override
            public void mousePressed(MouseEvent event)
            {
                if (linePressed)
                {
                    startX = event.getX();
                    startY = event.getY();
                } else if (pencilPressed)
                {
                    canvas.setOldxy(event.getX(), event.getY());
                }

            }

            @Override
            public void mouseReleased(MouseEvent event)
            {
                if (linePressed)
                {
                    canvas.drawLine(startX, startY, event.getX(), event.getY());
                }
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
