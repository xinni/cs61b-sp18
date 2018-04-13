package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int hexRowOffet(int size, int row) {
        if (row > (size * 2 - 1)) {
            throw new RuntimeException("Row is overflow");
        }
        if (row > size) {
            return  row - size;
        }
        return size - row + 1;
    }

    public int hexRowWidth(int size, int row) {
        int returnVal;
        if (row > (size * 2 - 1)) {
            throw new RuntimeException("Row is overflow");
        }
        if (row > size) {
            returnVal = (row - size) * 2 + size;
        } else {
            returnVal = (row - size + 1) * 2 + size;
        }
        return returnVal;
    }

    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {

    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];

        Position p = new Position(25, 25);

        addHexagon(world, p, 3, Tileset.GRASS);

        ter.renderFrame(world);
    }
}
