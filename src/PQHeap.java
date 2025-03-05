import java.util.Arrays;

/**
 * PQHeap class - Implements a max heap using an array to
 * store player instances based on their score
 * Implements the PriorityQueue
 * @author Cody Bandrowski
 */
public class PQHeap implements PriorityQueue{
    private Player[] heap;
    private int size;

    /**
     * Default Constructor
     * Starts heap with size of 10
     */
    public PQHeap(){
        heap = new Player[10];
        size = 0;
    }

    /**
     * Copy Constructor
     * Creates deep copy of another PQHeap
     * @param other PQHeap to copy
     */
    public PQHeap(PQHeap other ){
        this.size = other.size;
        this.heap = new Player[other.size];
        for(int i = 0; i<size; i++){
            this.heap[i] = new Player(other.heap[i]);
        }
    }

    /**
     * CreateClone
     * Create a deep copy of the current PQHeap
     * @return a new PQHeap with same data
     */
    public PQHeap createClone(){
        return new PQHeap(this);
    }

    /**
     * add method
     * Adds a player object to the priority queue
     *
     * @param a
     */
    @Override
    public void add(Player a) {
        if(size == heap.length){
            Player[] temp = new Player[heap.length*2];
            for(int i = 0; i<size; i++){
                temp[i] = new Player(heap[i]);
            }
            heap = temp;
        }
        heap[size] = a;
        heapifyUp(size);
        size++;
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
        if(isEmpty()){
            return null;
        }
        Player highest = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown(0);
        return highest;
    }

    /**
     * clear method
     * clear all players from the priority queue
     */
    @Override
    public void clear() {
        size = 0;
            heap = new Player[10];

    }

    /**
     * getSize method
     * Returns the number of players being stored in the priority queue
     *
     * @return int size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * isEmpty method
     * Returns true if the priority queue is empty.
     *
     * @return true if empty False If contains data
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Swap two elements in the heap
     * @param i first index
     * @param j second index
     */
    private void swap(int i, int j) {
        Player temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Heapify up operation to maintain heap property after insertion
     * @param index of newly added element
     */
    private void heapifyUp(int index){
        int parentIndex = (index-1)/2;
        while(index > 0 && heap[parentIndex].getScore() > heap[index].getScore()){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
    }

    /**
     * Heapidy down operation to maintain heap property after removal
     * @param index to heapify down
     */
    private void heapifyDown(int index){
        int largest = index;
        int leftChild = 2*index + 1;
        int rightChild = 2*index + 2;
        if(leftChild < size && heap[leftChild].getScore() > heap[largest].getScore()){
            largest = leftChild;
        }
        if(rightChild < size && heap[rightChild].getScore() > heap[largest].getScore()){
            largest = rightChild;
        }
        if(largest != index){
            swap(index, largest);
            heapifyDown(largest);
        }
    }
}
