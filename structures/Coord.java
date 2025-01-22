package structures;

/**
 * Represents a Coordinate in a 2D-array as (Row, Col).
 * (0,0) represents top-left.
 */
public class Coord extends Tuple.Pair<Integer, Integer> {
    public Coord(int r, int c) {
        super(r, c);
    }

    public int r() { return this.v0(); }
    public int c() { return this.v1(); }

    /**
     * Returns a new Coordinate relative to this one.
     * @param d The Direction to move in
     * @param n The number of steps (of the direction) to move in
     * @return The new Coordinate
     */
    public Coord relative(Direction d, int n) {
        return new Coord(r() + (n * d.Δr()), c() + (n * d.Δc()));
    }
    /**
     * Returns a new Coordinate relative to this one.
     * @param d The Direction to move in
     * @return The new Coordinate
     */
    public Coord relative(Direction d) { return relative(d, 1); }

    /**
     * Returns the Direction distance from this Coordinate to another.
     * @param other The other Coordinate
     * @return The Direction distance to the Coordinate
     */
    public Direction distance(Coord other) {
        return new Direction(other.r() - r(), other.c() - c());
    }
}
