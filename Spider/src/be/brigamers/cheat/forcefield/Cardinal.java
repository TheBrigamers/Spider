package be.brigamers.cheat.forcefield;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * A class to manage orientation using cardinals
 *
 * @author Alexis "Kwizzy"
 */
public enum Cardinal {
    N,
    NE,
    E,
    SE,
    S,
    SW,
    W,
    NW;


    /**
     * Get the Cardinal object from a player, by its orientation
     *
     * @param player The player to get the Cardinal
     * @return The player orientation as a {@link Cardinal} object
     */
    @Deprecated
    public static Cardinal getFullCardinal(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;

        if (rotation < 0)
            rotation += 360.0;

        if (0 <= rotation && rotation < 22.5)
            return W;
        else if (22.5 <= rotation && rotation < 67.5)
            return NW;
        else if (67.5 <= rotation && rotation < 112.5)
            return N;
        else if (112.5 <= rotation && rotation < 157.5)
            return NE;
        else if (157.5 <= rotation && rotation < 202.5)
            return E;
        else if (202.5 <= rotation && rotation < 247.5)
            return SE;
        else if (247.5 <= rotation && rotation < 292.5)
            return S;
        else if (292.5 <= rotation && rotation < 337.5)
            return SW;
        else if (337.5 <= rotation && rotation < 360.0)
            return W;

        return null;
    }

    /**
     * Return a simple (only S, W, E, or N) Cardinal from a player by its orientation
     *
     * @param player The player to get the orientation from
     * @return The player orientation as a Cardinal (S, W, E, or N)
     */
    public static Cardinal getCardinal(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;

        if (rotation < 0)
            rotation += 360.0;

        if (0 <= rotation && rotation < 67.5)
            return W;
        else if (67.5 <= rotation && rotation < 157.5)
            return N;
        else if (157.5 <= rotation && rotation < 247.5)
            return E;
        else if (247.5 <= rotation && rotation < 337.5)
            return S;
        else if (337.5 <= rotation && rotation < 360.0)
            return W;

        return null;
    }

    /**
     * @param loc  Location
     * @param dist distance
     * @return the block behind
     */
    public Location blockFront(Location loc, Integer dist) {
        Location l = loc;
        switch (this) {
            case E:
                return l.add(+dist, 0, 0);
            case W:
                return l.add(-dist, 0, 0);
            case N:
                return l.add(0, 0, -dist);
            case S:
                return l.add(0, 0, +dist);
            default:
                return l.add(0, 0, 0);
        }
    }

    /**
     * Get the block in the direction of the given cardinal, from a given location, at the given
     * distance
     *
     * @param loc  Location
     * @param dist distance
     * @return the block left
     */
    public Location blockLeft(Location loc, Integer dist) {
        Location l = loc;
        switch (this) {
            case E:
                return l.add(0, 0, -dist);
            case W:
                return l.add(0, 0, +dist);
            case N:
                return l.add(-dist, 0, 0);
            case S:
                return l.add(+dist, 0, 0);
            default:
                return l.add(0, 0, 0);
        }
    }

    /**
     * Get the block in the direction of the given cardinal, from a given location, at the given
     * distance
     *
     * @param loc  Location
     * @param dist distance
     * @return the block right
     */
    public Location blockRight(Location loc, Integer dist) {
        Location l = loc;
        switch (this) {
            case E:
                return l.add(0, 0, +dist);
            case W:
                return l.add(0, 0, -dist);
            case N:
                return l.add(+dist, 0, 0);
            case S:
                return l.add(-dist, 0, 0);
            default:
                return l.add(0, 0, 0);
        }
    }

    /**
     * Get the block in the direction of the given cardinal, from a given location, at the given
     * distance
     *
     * @param loc  Location
     * @param dist distance
     * @return the block behind
     */
    public Location blockBehind(Location loc, Integer dist) {
        Location l = loc;
        switch (this) {
            case E:
                return l.add(-dist, 0, 0);
            case W:
                return l.add(+dist, 0, 0);
            case N:
                return l.add(0, 0, +dist);
            case S:
                return l.add(0, 0, -dist);
            default:
                return l.add(0, 0, 0);
        }
    }

    /**
     * Reverse the direction, by example Card.reverse(N) returns S
     *
     * @param card The direction to reverse
     * @return The reversed direction
     */
    public Cardinal reverse(Cardinal card) {
        switch (card) {
            case E:
                return W;
            case W:
                return E;
            case N:
                return S;
            case S:
                return N;
            case NW:
                return SE;
            case NE:
                return SW;
            case SE:
                return NW;
            case SW:
                return NE;
            default:
                return null;
        }
    }
}