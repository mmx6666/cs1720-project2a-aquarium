import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class Aquarium {
    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "Aquarium - Initial Checkpoint");
        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(2);
        painter.forward(100);
        painter.turnRight(90);
        painter.circle(35);
        drawScene(painter);
    }

    /**
     * Plans the whole aquarium: two fish, two jellyfish, seaweed, and bubbles.
     * @param painter the drawing tool used for the scene
     */
    public static void drawScene(PainterAPI painter) {
        // Calls drawFish twice with different sizes and colors.
        // Calls drawJellyfish twice with different sizes and colors.
        // Calls drawDecorations for the seaweed and bubbles.
    }

    /**
     * Draws a filled circle with its center at (x, y).
     * @param painter the drawing tool
     * @param x the horizontal coordinate of the center
     * @param y the vertical coordinate of the center
     * @param radius the distance from the center to the edge
     * @param color the outline and fill color
     */
    public static void drawCircle(PainterAPI painter, double x, double y,
                                  double radius, Color color) {
    }

    /**
     * Draws a filled triangle pointing right.
     * @param painter the drawing tool
     * @param x the left edge of the triangle's bounding box
     * @param y the top edge of the triangle's bounding box
     * @param size the width and height of the triangle
     * @param color the outline and fill color
     */
    public static void drawTriangle(PainterAPI painter, double x, double y,
                                    double size, Color color) {
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
        // Calls drawCircle for the body and eye.
        // Calls drawTriangle for the tail.
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
        // Calls drawCircle for the head and eyes.
    }

    /**
     * Draws both types of decoration in the aquarium.
     * @param painter the drawing tool
     */
    public static void drawDecorations(PainterAPI painter) {
        // Calls drawSeaweed for plants near the bottom.
        // Calls drawBubbles for a column of bubbles on the right.
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
        // Calls drawTriangle in a loop to repeat the leaves.
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
        // Calls drawCircle in a loop to repeat the bubbles.
    }
}
