package structures;

import java.util.List;

/**
 * Represents a Direction in a 2D-array as a vector [ΔRow, ΔCol].
 */
public class Direction extends Coord {
    // Pre-defined common Directions
    public static final Direction N = new Direction(-1, 0);
    public static final Direction E = new Direction(0, 1);
    public static final Direction S = new Direction(1, 0);
    public static final Direction W = new Direction(0, -1);
    public static final Direction NE = new Direction(-1, 1);
    public static final Direction SE = new Direction(1, 1);
    public static final Direction SW = new Direction(1, -1);
    public static final Direction NW = new Direction(-1, -1);

    // Pre-defined lists of common Directions to iterate over
    /** List of Directions (<b>N, NE, E, SE, S, SW, W, NW</b>) */
    public static final List<Direction> ALL = List.of(N, NE, E, SE, S, SW, W, NW);
    /** List of Directions (<b>N, E, S, W</b>) */
    public static final List<Direction> CARDINAL = List.of(N, E, S, W);
    /** List of Directions (<b>NE, SE, SW, NW</b>) */
    public static final List<Direction> ORDINAL = List.of(NE, SE, SW, NW);

    public static Direction left90(Direction dir) {
        return new Direction(-1 * dir.c(), dir.r());
    }
    public static Direction left45(Direction dir) {
        int i = ALL.indexOf(dir) - 1;
        return ALL.get(i < 0 ? ALL.size() - 1 : i);
    }

    public static Direction right90(Direction dir) {
        return new Direction(dir.c(), -1 * dir.r());
    }
    public static Direction right45(Direction dir) {
        return ALL.get((ALL.indexOf(dir) + 1) % ALL.size());
    }

    public static Direction opposite(Direction dir) {
        return new Direction(-1 * dir.r(), -1 * dir.c());
    }

    public Direction(int Δr, int Δc) {
        super(Δr, Δc);
    }

    public int Δr() { return this.r(); }
    public int Δc() { return this.c(); }

    /**
     * Returns the magnitude of this Direction as taxicab-distance from (0,0)
     * @return Magnitude of this Direction
     */
    public double magnitude() {
        return Math.abs(Δr()) + Math.abs(Δc());
    }
}