/**
 * Priority Queue Interface
 * @author Cody Bandrowski
 */
public interface PriorityQueue {
    /**
     * add method
     * Adds a player object to the priority queue
     * @param a
     */
    void add(Player a);

    /**
     * getHighestScoreplayer method
     * Get the player with the highest score. Use the player’s score to determine priority
     * THE PLAYER SHOULD ALSO BE REMOVED FROM THE PRIORITY QUEUE
     * @return
     */
    Player getHighestScoreplayer();

    /**
     * clear method
     * clear all players from the priority queue
     */
    void clear();

    /**
     * getSize method
     * Returns the number of players being stored in the priority queue
     * @return
     */
    int getSize();

    /**
     * isEmpty method
     * Returns true if the priority queue is empty.
     * @return
     */
    boolean isEmpty();
}
