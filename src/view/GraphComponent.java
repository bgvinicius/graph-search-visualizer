package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A JPanel which draws a graph.
 * The purpose of this component is to be reused on other screens.
 */
public class GraphComponent extends JPanel {
    void draw(Graphics g, double x, double y, int i) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 30, 30);

        final Color colorBefore = g2d.getColor();
        g2d.setColor(Color.WHITE);
        g2d.fill(circle);
        g2d.setColor(colorBefore);
        g2d.drawOval((int) x, (int) y, 30, 30);
        g2d.drawString(i + "", (float) x + 12, (float) y + 20);
//        g2d.drawOval();
//        g2d.drawOval(0, 0, 50, 50);
//        g2d.drawLine(400, 400, 500, 500);
    }

    void drawEdge(Graphics g, int from, int to, double[][] coordenadas) {
        int x1 = (int) coordenadas[0][from];
        int x2 = (int) coordenadas[0][to];
        int y1 = (int) coordenadas[1][from];
        int y2 = (int) coordenadas[1][to];

        g.drawLine(x1 + 12, y1 + 20, x2 + 12, y2 + 20);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
//
        System.out.println("apsasça");
//        draw(g, 0, 0);
//        draw(g, 450, 450);
//        draw(g, 500, 500);

        int n = 5;
        final double[][] coordenadas = gerarCoordenadas(n);

        // scale & reposition points to fit well in the screen
        for (int i = 0; i < n; i++) {
            double x = (coordenadas[0][i] * 200d) + 325d;
            double y = (coordenadas[1][i] * 200d) + 325d;
            coordenadas[0][i] = x;
            coordenadas[1][i] = y;
        }

        drawEdge(g, 0, 1, coordenadas);
        drawEdge(g, 1, 2, coordenadas);
        drawEdge(g, 1, 3, coordenadas);
        drawEdge(g, 3, 4, coordenadas);
        drawEdge(g, 2, 4, coordenadas);

        // draw points on screen
        for (int i = 0; i < n; i++) {
            double x = coordenadas[0][i];
            double y = coordenadas[1][i];
            draw(g, x, y, i);
        }

    }

    public static double[][] gerarCoordenadas(int n) {
        double[][] coordenadas = new double[2][n];
        double x,y, r = 1, ang = 0;

        for (int i = 0; i < n; i++) {
            ang = (((360 / n) * i) * Math.PI / 180);
            x = r * Math.cos(ang);
            y = r * Math.sin(ang);

            if (Math.abs(x) < Math.pow(10, -5))
                x = 0;
            if (Math.abs(y) < Math.pow(10, -5))
                y = 0;
            coordenadas[0][i] = x;
            coordenadas[1][i] = y;
        }

        return coordenadas;
    }
}
