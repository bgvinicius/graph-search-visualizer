package view.graph;

import models.Vertex;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class VertexComponent {
    private final int xCord;
    private final int yCord;
    private final int value;
    private final Vertex<Integer> vertex;
    private final boolean isDirected;
    private final List<VertexComponent> adjacentVertices = new ArrayList<>();

    public VertexComponent(int x, int y, Vertex<Integer> vertex, boolean isDirected) {
        this.xCord = x;
        this.yCord = y;
        this.value = vertex.getData();
        this.vertex = vertex;
        this.isDirected = isDirected;
    }

    public void addAdjacentVertex(VertexComponent adjacent) {
        this.adjacentVertices.add(adjacent);
    }

    public Vertex<Integer> getVertex() {
        return this.vertex;
    }

    void draw(final Graphics graphics) {
        draw(graphics, Color.WHITE, Color.BLACK);
    }

    void draw(final Graphics graphics, Color fillColor, Color textColor) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D.Double circle = new Ellipse2D.Double(xCord, yCord, 30, 30);

        final Color colorBefore = g2d.getColor();
        g2d.setColor(fillColor);
        g2d.fill(circle);
        g2d.setColor(colorBefore);

        g2d.drawOval(xCord, yCord, 30, 30);
        g2d.setColor(textColor);
        g2d.drawString(value + "", (float) xCord + 12, yCord + 20);
        g2d.setColor(colorBefore);
    }

    void drawEdges(final Graphics graphics) {
        for (VertexComponent adjacentVertex : this.adjacentVertices) {
            if (isDirected) {
                drawDirectedEdge(graphics, this, adjacentVertex, 5, 5);
            } else {
                drawUndirectedEdge(graphics, this, adjacentVertex);
            }
        }
    }

    /**
     * Thanks to: https://stackoverflow.com/questions/2027613/how-to-draw-a-directed-arrow-line-in-java
     * Draw an arrow line between two points.
     */
    private void drawDirectedEdge(Graphics g, VertexComponent from, VertexComponent to, int d, int h) {

        int x1 = from.xCord;
        int y1 = from.yCord + 15;
        int x2 = to.xCord;
        int y2 = to.yCord + 15;

        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(from.xCord + 12, from.yCord + 20, to.xCord + 12, to.yCord + 20);
        g.fillPolygon(xpoints, ypoints, 3);
    }

    private void drawUndirectedEdge(Graphics g, VertexComponent from, VertexComponent to) {
        int x1 = from.xCord;
        int x2 = to.xCord;
        int y1 = from.yCord;
        int y2 = to.yCord;

        g.drawLine(x1 + 12, y1 + 20, x2 + 12, y2 + 20);
    }
}
