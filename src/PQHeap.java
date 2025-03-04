/**
 * PQHeap class - Implements a max heap using an array to
 * store player instances based on their score
 * Implements the PriorityQueue
 * @author Cody Bandrowski
 */
public class PQHeap implements PriorityQueue{
    private Player[] heap;

    /**
     * add method
     * Adds a player object to the priority queue
     *
     * @param a
     */
    @Override
    public void add(Player a) {

    }

    /**
     * getHighestScoreplayer method
     * Get the player with the highest score. Use the player’s score to determine priority
     * THE PLAYER SHOULD ALSO BE REMOVED FROM THE PRIORITY QUEUE
     *
     * @return
     */
    @Override
    public Player getHighestScoreplayer() {
        return null;
    }

    /**
     * clear method
     * clear all players from the priority queue
     */
    @Override
    public void clear() {

    }

    /**
     * getSize method
     * Returns the number of players being stored in the priority queue
     *
     * @return
     */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * isEmpty method
     * Returns true if the priority queue is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }
}
