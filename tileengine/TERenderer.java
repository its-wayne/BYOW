package tileengine;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.Color;
import java.awt.Font;

/**
 * Utility class for rendering tiles. You do not need to modify this file. You're welcome
 * to, but be careful. We can help you most easily if you do not modify this file.
 * <p>
 * Make sure to call the initialize function before you call renderFrame!
 */
public class TERenderer {
    private static final int TILE_SIZE = 16;
    private int width;
    private int height;
    private int xOffset;
    private int yOffset;

    /**
     * Same functionality as the other initialization method. The only difference is that the xOff
     * and yOff parameters will change where the renderFrame method starts drawing. For example,
     * if you select w = 60, h = 30, xOff = 3, yOff = 4 and then call renderFrame with a
     * TETile[50][25] array, the renderer will leave 3 tiles blank on the left, 7 tiles blank
     * on the right, 4 tiles blank on the bottom, and 1 tile blank on the top.
     */
    public void initialize(int w, int h, int xOff, int yOff) {
        this.width = w;
        this.height = h;
        this.xOffset = xOff;
        this.yOffset = yOff;
        StdDraw.setCanvasSize(width * TILE_SIZE, height * TILE_SIZE);
        resetFont();
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(new Color(0, 0, 0));
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }

    /**
     * Initializes StdDraw parameters and launches the StdDraw window. w and h are the
     * width and height of the world in number of tiles. If the TETile[][] that you pass
     * to renderFrame is smaller than this, then extra blank space will be left
     * on the right and top edges of the frame. For example, if you select w = 60 and
     * h = 30, this method will create a 60 tile wide by 30 tile tall window. If
     * you then subsequently call renderFrame with a TETile[50][25] array, it will
     * leave 10 tiles blank on the right side and 5 tiles blank on the top side. If
     * you want to leave extra space on the left or bottom instead, use the other
     * initialize method.
     */
    public void initialize(int w, int h) {
        initialize(w, h, 0, 0);
    }

    /**
     * Takes in a 2d array of TETile objects and renders the 2d array to the screen, starting from
     * xOffset and yOffset.
     * <p>
     * If the array is an NxM array, then the element displayed at positions would be as follows,
     * given in units of tiles.
     * <p>
     *              positions   xOffset |xOffset+1|xOffset+2| .... |xOffset+world.length
     *                     |-----------------------------------------------------------------------|
     * (yOffset+world[0].length)-1   |  [0][M-1] | [1][M-1] | [2][M-1] | .... | [N-1][M-1]         |
     *                    |    ...    |    ...    |    ...   | .... |    ...            |
     *               yOffset+2  |  [0][2]   |  [1][2]  |  [2][2]  | .... | [N-1][2]          |
     *               yOffset+1  |  [0][1]   |  [1][1]  |  [2][1]  | .... | [N-1][1]          |
     *                 yOffset  |  [0][0]   |  [1][0]  |  [2][0]  | .... | [N-1][0]          |
     *                     |-----------------------------------------------------------------------|
     * <p>
     * By convention, the copy of the world displayed to the screen is not shown here.
     * <p>
     * Note that the show() call has intentionally been removed here. The caller is expected
     * to draw any HUD/overlay on top of the tiles and then call StdDraw.show() exactly once
     * per frame. Calling show() inside renderFrame in addition to the caller's show() causes
     * the screen to be flushed twice per frame (once without the HUD, once with it), which
     * produces a visible flicker.
     */
    public void renderFrame(TETile[][] world) {
        StdDraw.clear(new Color(0, 0, 0));
        drawTiles(world);
    }

    /**
     * Only draws tiles to the screen; does not clear or show. Useful if you want to draw
     * additional things on top of the tiles, or if you want to control the show() call
     * yourself.
     */
    public void drawTiles(TETile[][] world) {
        int numXTiles = world.length;
        int numYTiles = world[0].length;
        for (int x = 0; x < numXTiles; x += 1) {
            for (int y = 0; y < numYTiles; y += 1) {
                if (world[x][y] == null) {
                    throw new IllegalArgumentException("Tile at position x=" + x + ", y=" + y
                            + " is null.");
                }
                world[x][y].draw(x + xOffset, y + yOffset);
            }
        }
    }

    public void resetFont() {
        Font font = new Font("Monaco", Font.BOLD, 14);
        StdDraw.setFont(font);
    }
}
