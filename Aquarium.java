import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class Aquarium {
    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My Aquarium");
        canvas.setBackgroundColor(new Color(205, 238, 250));
        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(0);
        drawScene(painter);
    }

    /**
     * Draws two fish, two jellyfish, seaweed, and bubbles.
     * @param painter the drawing tool used for the scene
     */
    public static void drawScene(PainterAPI painter) {
        drawDecorations(painter);
        drawFish(painter, -190, 120, 110, new Color(245, 155, 55));
        drawFish(painter, -40, -60, 76, new Color(70, 145, 220));
        drawJellyfish(painter, 165, 135, 95, new Color(235, 135, 175));
        drawJellyfish(painter, 215, -90, 65, new Color(155, 115, 205));
        painter.liftPen();
    }

    /**
     * Draws a filled circle with its center at (x, y).
     * All drawing methods keep the painter facing right, its starting direction.
     * @param painter the drawing tool
     * @param x the horizontal coordinate of the center
     * @param y the vertical coordinate of the center
     * @param radius the distance from the center to the edge
     * @param color the outline and fill color
     */
    public static void drawCircle(PainterAPI painter, double x, double y,
                                  double radius, Color color) {
        painter.liftPen();
        painter.moveTo(x, y - radius);
        painter.setPenColor(color);
        painter.setPenWidth(2);
        painter.lowerPen();
        painter.startFill(color);
        painter.circle(radius);
        painter.finishFill();
        painter.liftPen();
    }

    /**
     * Draws a filled triangle pointing right.
     * @param painter the drawing tool
     * @param x the left edge of the triangle's bounding box
     * @param y the top edge of the triangle's bounding box; positive y is up
     * @param size the width and height of the triangle
     * @param color the outline and fill color
     */
    public static void drawTriangle(PainterAPI painter, double x, double y,
                                    double size, Color color) {
        painter.liftPen();
        painter.moveTo(x, y);
        painter.setPenColor(color);
        painter.setPenWidth(2);
        painter.lowerPen();
        painter.startFill(color);
        painter.moveTo(x + size, y - size / 2);
        painter.moveTo(x, y - size);
        painter.moveTo(x, y);
        painter.finishFill();
        painter.liftPen();
    }

    /**
     * Draws a fish facing right, with a round body, an eye, and a triangle tail.
     * @param painter the drawing tool
     * @param x the horizontal coordinate of the body's center
     * @param y the vertical coordinate of the body's center
     * @param bodySize the diameter of the round body
     * @param bodyColor the color of the body and tail
     */
    public static void drawFish(PainterAPI painter, double x, double y,
                                double bodySize, Color bodyColor) {
        drawTriangle(painter, x - bodySize * 0.95, y + bodySize * 0.25,
                     bodySize * 0.5, bodyColor);
        drawCircle(painter, x, y, bodySize / 2, bodyColor);
        drawCircle(painter, x + bodySize * 0.22, y + bodySize * 0.1,
                   bodySize * 0.11, Color.WHITE);
        drawCircle(painter, x + bodySize * 0.25, y + bodySize * 0.1,
                   bodySize * 0.05, Color.BLACK);
    }

    /**
     * Draws a jellyfish with a round head, two eyes, and downward tentacles.
     * @param painter the drawing tool
     * @param x the horizontal coordinate of the head's center
     * @param y the vertical coordinate of the head's center
     * @param headSize the diameter of the head
     * @param headColor the color of the head and tentacles
     */
    public static void drawJellyfish(PainterAPI painter, double x, double y,
                                     double headSize, Color headColor) {
        painter.setPenColor(headColor);
        painter.setPenWidth(4);
        for (int i = 0; i < 5; i++) {
            double tentacleX = x - headSize * 0.32 + i * headSize * 0.16;
            painter.liftPen();
            painter.moveTo(tentacleX, y - headSize * 0.25);
            painter.lowerPen();
            painter.moveTo(tentacleX - headSize * 0.08, y - headSize * 0.65);
            painter.moveTo(tentacleX + headSize * 0.08, y - headSize * 0.95);
            painter.moveTo(tentacleX, y - headSize * 1.3);
            painter.liftPen();
        }
        drawCircle(painter, x, y, headSize / 2, headColor);
        drawCircle(painter, x - headSize * 0.18, y,
                   headSize * 0.1, Color.WHITE);
        drawCircle(painter, x + headSize * 0.18, y,
                   headSize * 0.1, Color.WHITE);
        drawCircle(painter, x - headSize * 0.18, y - headSize * 0.02,
                   headSize * 0.045, Color.BLACK);
        drawCircle(painter, x + headSize * 0.18, y - headSize * 0.02,
                   headSize * 0.045, Color.BLACK);
    }

    /**
     * Draws both types of decoration in the aquarium.
     * @param painter the drawing tool
     */
    public static void drawDecorations(PainterAPI painter) {
        drawSeaweed(painter, -315, -245, 135);
        drawSeaweed(painter, -245, -245, 95);
        drawBubbles(painter, 335, -190, 7);
    }

    /**
     * Draws green seaweed with repeated triangle leaves.
     * @param painter the drawing tool
     * @param x the horizontal coordinate of the plant's base
     * @param y the vertical coordinate of the plant's base
     * @param height the total height of the plant
     */
    public static void drawSeaweed(PainterAPI painter, double x, double y,
                                   double height) {
        Color leafColor = new Color(45, 145, 80);
        painter.liftPen();
        painter.moveTo(x, y);
        painter.setPenColor(leafColor);
        painter.setPenWidth(4);
        painter.lowerPen();
        painter.moveTo(x, y + height);
        painter.liftPen();
        for (int i = 0; i < 5; i++) {
            double leafY = y + (i + 1) * height / 5;
            double leafSize = height * 0.22;
            drawTriangle(painter, x - leafSize, leafY, leafSize, leafColor);
            drawTriangle(painter, x, leafY, leafSize, leafColor);
        }
    }

    /**
     * Draws a vertical group of small, light-colored bubbles.
     * @param painter the drawing tool
     * @param x the horizontal coordinate of the bubble column
     * @param y the vertical coordinate of the lowest bubble
     * @param count the number of bubbles to draw
     */
    public static void drawBubbles(PainterAPI painter, double x, double y,
                                   int count) {
        for (int i = 0; i < count; i++) {
            double bubbleY = y + i * 48;
            double radius = 8 + i;
            drawCircle(painter, x, bubbleY, radius, new Color(130, 195, 225));
            drawCircle(painter, x, bubbleY, radius - 2, new Color(230, 250, 255));
        }
    }
}
